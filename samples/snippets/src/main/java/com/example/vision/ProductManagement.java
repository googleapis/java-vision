/*
 * Copyright 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.vision;

import com.google.cloud.vision.v1p3beta1.LocationName;
import com.google.cloud.vision.v1p3beta1.Product;
import com.google.cloud.vision.v1p3beta1.Product.KeyValue;
import com.google.cloud.vision.v1p3beta1.ProductName;
import com.google.cloud.vision.v1p3beta1.ProductSearchClient;
import com.google.protobuf.FieldMask;

import java.io.IOException;
import java.io.PrintStream;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;

/**
 * This application demonstrates how to perform basic operations on Products.
 *
 * For more information, see the tutorial page at
 * https://cloud.google.com/vision/product-search/docs/
 */

public class ProductManagement {

  // [START vision_product_search_create_product]
  /**
   * Create one product.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productId - Id of the product.
   * @param productDisplayName - Display name of the product.
   * @param productCategory - Category of the product.
   * @param productDescription - Description of the product.
   * @param productLabels - Labels of the product.
   * @throws IOException - on I/O errors.
   */
  public static void createProduct(
      String projectId,
      String computeRegion,
      String productId,
      String productDisplayName,
      String productCategory,
      String productDescription,
      String productLabels)
      throws IOException {
    ProductSearchClient client = ProductSearchClient.create();

    // A resource that represents Google Cloud Platform location.
    LocationName projectLocation = LocationName.of(projectId, computeRegion);

    // Create a product with the product specification in the region.
    // Multiple labels are also supported.
    Product myProduct =
        Product.newBuilder()
            .setName(productId)
            .setDisplayName(productDisplayName)
            .setProductCategory(productCategory)
            .setDescription(productDescription)
            .addProductLabels(
                KeyValue.newBuilder()
                    .setKey(productLabels.split(",")[0].split("=")[0])
                    .setValue(productLabels.split(",")[0].split("=")[1])
                    .build())
            .build();
    Product product = client.createProduct(projectLocation.toString(), myProduct, productId);

    // Display the product information
    System.out.println(String.format("Product name: %s", product.getName()));
  }
  // [END vision_product_search_create_product]

  // [START vision_product_search_list_products]
  /**
   * List all products.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @throws IOException - on I/O errors.
   */
  public static void listProducts(String projectId, String computeRegion) throws IOException {
    ProductSearchClient client = ProductSearchClient.create();

    // A resource that represents Google Cloud Platform location.
    LocationName projectLocation = LocationName.of(projectId, computeRegion);

    // List all the products available in the region.
    for (Product product : client.listProducts(projectLocation).iterateAll()) {
      // Display the product information
      System.out.println(String.format("\nProduct name: %s", product.getName()));
      System.out.println(
          String.format(
              "Product id: %s",
              product.getName().substring(product.getName().lastIndexOf('/') + 1)));
      System.out.println(String.format("Product display name: %s", product.getDisplayName()));
      System.out.println(String.format("Product category: %s", product.getProductCategory()));
      System.out.println("Product labels:");
      System.out.println(
          String.format("Product labels: %s", product.getProductLabelsList().toString()));
    }
  }
  // [END vision_product_search_list_products]

  // [START vision_product_search_get_product]
  /**
   * Get information about a product.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productId - Id of the product.
   * @throws IOException - on I/O errors.
   */
  public static void getProduct(String projectId, String computeRegion, String productId)
      throws IOException {
    ProductSearchClient client = ProductSearchClient.create();

    // Get the full path of the product.
    ProductName productPath = ProductName.of(projectId, computeRegion, productId);

    // Get complete detail of the product.
    Product product = client.getProduct(productPath.toString());

    // Display the product information
    System.out.println(String.format("Product name: %s", product.getName()));
    System.out.println(
        String.format(
            "Product id: %s", product.getName().substring(product.getName().lastIndexOf('/') + 1)));
    System.out.println(String.format("Product display name: %s", product.getDisplayName()));
    System.out.println(String.format("Product description: %s", product.getDescription()));
    System.out.println(String.format("Product category: %s", product.getProductCategory()));
    System.out.println("Product labels:");
    System.out.println(
        String.format("Product labels: %s", product.getProductLabelsList().toString()));
  }
  // [END vision_product_search_get_product]

  // [START vision_product_search_update_product_labels]
  /**
   * Update the product labels.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productId -Id of the product.
   * @param productLabels - Labels of the product.
   * @throws IOException - on I/O errors.
   */
  public static void updateProductLabels(
      String projectId, String computeRegion, String productId, String productLabels)
      throws IOException {
    ProductSearchClient client = ProductSearchClient.create();

    // Get the full path of the product.
    String productPath = ProductName.of(projectId, computeRegion, productId).toString();

    // Set product name, product labels and product display name.
    // Multiple labels are also supported.
    Product product =
        Product.newBuilder()
            .setName(productPath)
            .addProductLabels(
                KeyValue.newBuilder()
                    .setKey(productLabels.split(",")[0].split("=")[0])
                    .setValue(productLabels.split(",")[0].split("=")[1])
                    .build())
            .build();

    // Set product update field name.
    FieldMask updateMask = FieldMask.newBuilder().addPaths("product_labels").build();

    // Update the product.
    Product updatedProduct = client.updateProduct(product, updateMask);

    // Display the product information
    System.out.println(String.format("Product name: %s", updatedProduct.getName()));
    System.out.println(
        String.format(
            "Updated product labels: %s", updatedProduct.getProductLabelsList().toString()));
  }
  // [END vision_product_search_update_product_labels]

  // [START vision_product_search_delete_product]
  /**
   * Delete the product and all its reference images.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productId - Id of the product.
   * @throws IOException - on I/O errors.
   */
  public static void deleteProduct(String projectId, String computeRegion, String productId)
      throws IOException {
    ProductSearchClient client = ProductSearchClient.create();

    // Get the full path of the product.
    ProductName productPath = ProductName.of(projectId, computeRegion, productId);

    // Delete a product.
    client.deleteProduct(productPath);

    System.out.println("Product deleted.");
  }
  // [END vision_product_search_delete_product]

  public static void main(String[] args) throws Exception {
    ProductManagement productManagement = new ProductManagement();
    productManagement.argsHelper(args, System.out);
  }

  public void argsHelper(String[] args, PrintStream out) throws Exception {
    ArgumentParser parser = ArgumentParsers.newFor("Product Management").build();
    Subparsers subparsers = parser.addSubparsers().dest("command");

    Subparser createProductParser = subparsers.addParser("create_product");
    createProductParser.addArgument("productId");
    createProductParser.addArgument("productDisplayName");
    createProductParser.addArgument("productCategory");
    createProductParser.addArgument("productDescription");
    createProductParser.addArgument("productLabels").nargs("?").setDefault("");

    subparsers.addParser("list_products");

    Subparser getProductParser = subparsers.addParser("get_product");
    getProductParser.addArgument("productId");

    Subparser updateProductLabelsParser = subparsers.addParser("update_product_labels");
    updateProductLabelsParser.addArgument("productId");
    updateProductLabelsParser.addArgument("productLabels");

    Subparser deleteProductParser = subparsers.addParser("delete_product");
    deleteProductParser.addArgument("productId");

    String projectId = System.getenv("PROJECT_ID");
    String computeRegion = System.getenv("REGION_NAME");

    Namespace ns = null;
    try {
      ns = parser.parseArgs(args);
      if (ns.get("command").equals("create_product")) {
        createProduct(
            projectId,
            computeRegion,
            ns.getString("productId"),
            ns.getString("productDisplayName"),
            ns.getString("productCategory"),
            ns.getString("productDescription"),
            ns.getString("productLabels"));
      }
      if (ns.get("command").equals("list_products")) {
        listProducts(projectId, computeRegion);
      }
      if (ns.get("command").equals("get_product")) {
        getProduct(projectId, computeRegion, ns.getString("productId"));
      }
      if (ns.get("command").equals("update_product_labels")) {
        updateProductLabels(
            projectId, computeRegion, ns.getString("productId"), ns.getString("productLabels"));
      }
      if (ns.get("command").equals("delete_product")) {
        deleteProduct(projectId, computeRegion, ns.getString("productId"));
      }

    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
