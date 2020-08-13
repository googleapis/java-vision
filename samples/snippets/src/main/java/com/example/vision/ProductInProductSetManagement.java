/*
 * Copyright 2017 Google Inc.
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

// [START product_search_import]
import com.google.cloud.vision.v1p3beta1.LocationName;
import com.google.cloud.vision.v1p3beta1.Product;
import com.google.cloud.vision.v1p3beta1.ProductName;
import com.google.cloud.vision.v1p3beta1.ProductSearchClient;
import com.google.cloud.vision.v1p3beta1.ProductSet;
import com.google.cloud.vision.v1p3beta1.ProductSetName;
import com.google.cloud.vision.v1p3beta1.UpdateProductSetRequest;
import com.google.protobuf.FieldMask;

import java.io.IOException;
import java.io.PrintStream;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;
// [END product_search_import]

/**
 * This application demonstrates how to perform basic operations with Products in a Product Set.
 *
 * For more information, see the tutorial page at
 * https://cloud.google.com/vision/product-search/docs/
 */

public class ProductInProductSetManagement {

  // [START product_search_add_product_to_product_set]
  /**
   * Update a product set.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productSetId - Id of the product set.
   * @param productSetDisplayName - Display name of the product set.
   * @throws IOException - on I/O errors.
   */
  public static void addProductToProductSet(
      String projectId, String computeRegion, String productSetId, String productSetDisplayName)
      throws IOException {
    ProductSearchClient client = ProductSearchClient.create();

    // Get the full path of the product set.
    String productSetPath = ProductSetName.of(projectId, computeRegion, productSetId).toString();

    // Update the product set display name.
    ProductSet productSet =
        ProductSet.newBuilder()
            .setName(productSetPath)
            .setDisplayName(productSetDisplayName)
            .build();

    FieldMask updateMask = FieldMask.newBuilder().addPaths("display_name").build();

    UpdateProductSetRequest request =
        UpdateProductSetRequest.newBuilder()
            .setProductSet(productSet)
            .setUpdateMask(updateMask)
            .build();

    ProductSet updatedProductSet = client.updateProductSet(request);

    // Display the updated set information
    System.out.println(String.format("Product set name: %s", updatedProductSet.getName()));
    System.out.println(
        String.format(
            "Product set id: %s",
            updatedProductSet
                .getName()
                .substring(updatedProductSet.getName().lastIndexOf('/') + 1)));
    System.out.println(
        String.format("Updated product set display name: %s", updatedProductSet.getDisplayName()));
  }
  // [END product_search_add_product_to_product_set]

  // [START product_search_remove_product_from_product_set]
  /**
   * Remove a product from a product set.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productId - Id of the product.
   * @param productSetId - Id of the product set.
   * @throws IOException - on I/O errors.
   */
  public static void removeProductFromProductSet(
      String projectId, String computeRegion, String productId, String productSetId)
      throws IOException {
    ProductSearchClient client = ProductSearchClient.create();

    // Get the full path of the product set.
    ProductSetName productSetPath = ProductSetName.of(projectId, computeRegion, productSetId);

    // Get the full path of the product.
    String productPath = ProductName.of(projectId, computeRegion, productId).toString();

    // Remove the product from the product set.
    client.removeProductFromProductSet(productSetPath, productPath);

    System.out.println(String.format("Product removed from product set."));
  }
  // [END product_search_remove_product_from_product_set]

  // [START product_search_list_products_in_product_set]
  /**
   * List all products in a product set.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productSetId - Id of the product set.
   * @throws IOException - on I/O errors.
   */
  public static void listProductsInProductSet(
      String projectId, String computeRegion, String productSetId) throws IOException {
    ProductSearchClient client = ProductSearchClient.create();

    // Get the full path of the product set.
    ProductSetName productSetPath = ProductSetName.of(projectId, computeRegion, productSetId);

    // List all the products available in the product set.
    for (Product product :
        client.listProductsInProductSet(productSetPath.toString()).iterateAll()) {
      // Display the product information
      System.out.println(String.format("Product name: %s", product.getName()));
      System.out.println(
          String.format(
              "Product id: %s",
              product.getName().substring(product.getName().lastIndexOf('/') + 1)));
      System.out.println(String.format("Product display name: %s", product.getDisplayName()));
      System.out.println(String.format("Product description: %s", product.getDescription()));
      System.out.println(String.format("Product category: %s", product.getProductCategory()));
      System.out.println(
          String.format("Product labels: %s\n", product.getProductLabelsList().toString()));
    }
  }
  // [END product_search_list_products_in_product_set]

  // [START product_search_list_products]
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
  // [END product_search_list_products]

  public static void main(String[] args) throws Exception {
    ProductInProductSetManagement productInProductSetManagement =
        new ProductInProductSetManagement();
    productInProductSetManagement.argsHelper(args, System.out);
  }

  public static void argsHelper(String[] args, PrintStream out) throws Exception {
    ArgumentParser parser = ArgumentParsers.newFor("").build();
    Subparsers subparsers = parser.addSubparsers().dest("command");
    subparsers.addParser("list_products");

    Subparser listProductInProductSetParser = subparsers.addParser("list_products_in_product_set");
    listProductInProductSetParser.addArgument("productSetId");

    Subparser updateProductSetParser = subparsers.addParser("update_product_set");
    updateProductSetParser.addArgument("productSetId");
    updateProductSetParser.addArgument("productSetDisplayName");

    Subparser removeProductFromProductSetParser =
        subparsers.addParser("remove_product_from_product_set");
    removeProductFromProductSetParser.addArgument("productId");
    removeProductFromProductSetParser.addArgument("productSetId");

    String projectId = System.getenv("PROJECT_ID");
    String computeRegion = System.getenv("REGION_NAME");

    Namespace ns = null;
    try {
      ns = parser.parseArgs(args);
      if (ns.get("command").equals("list_products")) {
        listProducts(projectId, computeRegion);
      }
      if (ns.get("command").equals("update_product_set")) {
        addProductToProductSet(
            projectId,
            computeRegion,
            ns.getString("productSetId"),
            ns.getString("productSetDisplayName"));
      }
      if (ns.get("command").equals("remove_product_from_product_set")) {
        removeProductFromProductSet(
            projectId, computeRegion, ns.getString("productId"), ns.getString("productSetId"));
      }
      if (ns.get("command").equals("list_products_in_product_set")) {
        listProductsInProductSet(projectId, computeRegion, ns.getString("productSetId"));
      }

    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
