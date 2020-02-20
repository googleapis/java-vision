/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.vision.v1p4beta1;

import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListProductSetsPagedResponse;
import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListProductsInProductSetPagedResponse;
import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListProductsPagedResponse;
import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListReferenceImagesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class ProductSearchClientTest {
  private static MockProductSearch mockProductSearch;
  private static MockImageAnnotator mockImageAnnotator;
  private static MockServiceHelper serviceHelper;
  private ProductSearchClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockProductSearch = new MockProductSearch();
    mockImageAnnotator = new MockImageAnnotator();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockProductSearch, mockImageAnnotator));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    ProductSearchSettings settings =
        ProductSearchSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProductSearchClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createProductSetTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    ProductSet expectedResponse =
        ProductSet.newBuilder().setName(name).setDisplayName(displayName).build();
    mockProductSearch.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ProductSet productSet = ProductSet.newBuilder().build();
    String productSetId = "productSetId4216680";

    ProductSet actualResponse = client.createProductSet(parent, productSet, productSetId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProductSetRequest actualRequest = (CreateProductSetRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(productSet, actualRequest.getProductSet());
    Assert.assertEquals(productSetId, actualRequest.getProductSetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createProductSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ProductSet productSet = ProductSet.newBuilder().build();
      String productSetId = "productSetId4216680";

      client.createProductSet(parent, productSet, productSetId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listProductSetsTest() {
    String nextPageToken = "";
    ProductSet productSetsElement = ProductSet.newBuilder().build();
    List<ProductSet> productSets = Arrays.asList(productSetsElement);
    ListProductSetsResponse expectedResponse =
        ListProductSetsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllProductSets(productSets)
            .build();
    mockProductSearch.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListProductSetsPagedResponse pagedListResponse = client.listProductSets(parent);

    List<ProductSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProductSetsRequest actualRequest = (ListProductSetsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listProductSetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listProductSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getProductSetTest() {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    ProductSet expectedResponse =
        ProductSet.newBuilder().setName(name2).setDisplayName(displayName).build();
    mockProductSearch.addResponse(expectedResponse);

    ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");

    ProductSet actualResponse = client.getProductSet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProductSetRequest actualRequest = (GetProductSetRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProductSetName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getProductSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");

      client.getProductSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateProductSetTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    ProductSet expectedResponse =
        ProductSet.newBuilder().setName(name).setDisplayName(displayName).build();
    mockProductSearch.addResponse(expectedResponse);

    ProductSet productSet = ProductSet.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ProductSet actualResponse = client.updateProductSet(productSet, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateProductSetRequest actualRequest = (UpdateProductSetRequest) actualRequests.get(0);

    Assert.assertEquals(productSet, actualRequest.getProductSet());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateProductSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductSet productSet = ProductSet.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateProductSet(productSet, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteProductSetTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");

    client.deleteProductSet(name);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProductSetRequest actualRequest = (DeleteProductSetRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProductSetName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteProductSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");

      client.deleteProductSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createProductTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    String productCategory = "productCategory-1607451058";
    Product expectedResponse =
        Product.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .setProductCategory(productCategory)
            .build();
    mockProductSearch.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Product product = Product.newBuilder().build();
    String productId = "productId1753008747";

    Product actualResponse = client.createProduct(parent, product, productId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProductRequest actualRequest = (CreateProductRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(product, actualRequest.getProduct());
    Assert.assertEquals(productId, actualRequest.getProductId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createProductExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Product product = Product.newBuilder().build();
      String productId = "productId1753008747";

      client.createProduct(parent, product, productId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listProductsTest() {
    String nextPageToken = "";
    Product productsElement = Product.newBuilder().build();
    List<Product> products = Arrays.asList(productsElement);
    ListProductsResponse expectedResponse =
        ListProductsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllProducts(products)
            .build();
    mockProductSearch.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListProductsPagedResponse pagedListResponse = client.listProducts(parent);

    List<Product> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProductsRequest actualRequest = (ListProductsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listProductsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listProducts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getProductTest() {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    String productCategory = "productCategory-1607451058";
    Product expectedResponse =
        Product.newBuilder()
            .setName(name2)
            .setDisplayName(displayName)
            .setDescription(description)
            .setProductCategory(productCategory)
            .build();
    mockProductSearch.addResponse(expectedResponse);

    ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");

    Product actualResponse = client.getProduct(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProductRequest actualRequest = (GetProductRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProductName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getProductExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");

      client.getProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateProductTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    String productCategory = "productCategory-1607451058";
    Product expectedResponse =
        Product.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .setProductCategory(productCategory)
            .build();
    mockProductSearch.addResponse(expectedResponse);

    Product product = Product.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Product actualResponse = client.updateProduct(product, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateProductRequest actualRequest = (UpdateProductRequest) actualRequests.get(0);

    Assert.assertEquals(product, actualRequest.getProduct());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateProductExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      Product product = Product.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateProduct(product, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteProductTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");

    client.deleteProduct(name);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProductRequest actualRequest = (DeleteProductRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProductName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteProductExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");

      client.deleteProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createReferenceImageTest() {
    String name = "name3373707";
    String uri = "uri116076";
    ReferenceImage expectedResponse = ReferenceImage.newBuilder().setName(name).setUri(uri).build();
    mockProductSearch.addResponse(expectedResponse);

    ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
    ReferenceImage referenceImage = ReferenceImage.newBuilder().build();
    String referenceImageId = "referenceImageId1946713331";

    ReferenceImage actualResponse =
        client.createReferenceImage(parent, referenceImage, referenceImageId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReferenceImageRequest actualRequest = (CreateReferenceImageRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProductName.parse(actualRequest.getParent()));
    Assert.assertEquals(referenceImage, actualRequest.getReferenceImage());
    Assert.assertEquals(referenceImageId, actualRequest.getReferenceImageId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createReferenceImageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
      ReferenceImage referenceImage = ReferenceImage.newBuilder().build();
      String referenceImageId = "referenceImageId1946713331";

      client.createReferenceImage(parent, referenceImage, referenceImageId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteReferenceImageTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    ReferenceImageName name =
        ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");

    client.deleteReferenceImage(name);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReferenceImageRequest actualRequest = (DeleteReferenceImageRequest) actualRequests.get(0);

    Assert.assertEquals(name, ReferenceImageName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteReferenceImageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ReferenceImageName name =
          ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");

      client.deleteReferenceImage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listReferenceImagesTest() {
    int pageSize = 883849137;
    String nextPageToken = "";
    ReferenceImage referenceImagesElement = ReferenceImage.newBuilder().build();
    List<ReferenceImage> referenceImages = Arrays.asList(referenceImagesElement);
    ListReferenceImagesResponse expectedResponse =
        ListReferenceImagesResponse.newBuilder()
            .setPageSize(pageSize)
            .setNextPageToken(nextPageToken)
            .addAllReferenceImages(referenceImages)
            .build();
    mockProductSearch.addResponse(expectedResponse);

    ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");

    ListReferenceImagesPagedResponse pagedListResponse = client.listReferenceImages(parent);

    List<ReferenceImage> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReferenceImagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReferenceImagesRequest actualRequest = (ListReferenceImagesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProductName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listReferenceImagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");

      client.listReferenceImages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getReferenceImageTest() {
    String name2 = "name2-1052831874";
    String uri = "uri116076";
    ReferenceImage expectedResponse =
        ReferenceImage.newBuilder().setName(name2).setUri(uri).build();
    mockProductSearch.addResponse(expectedResponse);

    ReferenceImageName name =
        ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");

    ReferenceImage actualResponse = client.getReferenceImage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReferenceImageRequest actualRequest = (GetReferenceImageRequest) actualRequests.get(0);

    Assert.assertEquals(name, ReferenceImageName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getReferenceImageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ReferenceImageName name =
          ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");

      client.getReferenceImage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void addProductToProductSetTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
    String product = "product-309474065";

    client.addProductToProductSet(name, product);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddProductToProductSetRequest actualRequest =
        (AddProductToProductSetRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProductSetName.parse(actualRequest.getName()));
    Assert.assertEquals(product, actualRequest.getProduct());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void addProductToProductSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
      String product = "product-309474065";

      client.addProductToProductSet(name, product);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void removeProductFromProductSetTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
    String product = "product-309474065";

    client.removeProductFromProductSet(name, product);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveProductFromProductSetRequest actualRequest =
        (RemoveProductFromProductSetRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProductSetName.parse(actualRequest.getName()));
    Assert.assertEquals(product, actualRequest.getProduct());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void removeProductFromProductSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
      String product = "product-309474065";

      client.removeProductFromProductSet(name, product);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listProductsInProductSetTest() {
    String nextPageToken = "";
    Product productsElement = Product.newBuilder().build();
    List<Product> products = Arrays.asList(productsElement);
    ListProductsInProductSetResponse expectedResponse =
        ListProductsInProductSetResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllProducts(products)
            .build();
    mockProductSearch.addResponse(expectedResponse);

    ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");

    ListProductsInProductSetPagedResponse pagedListResponse = client.listProductsInProductSet(name);

    List<Product> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProductsInProductSetRequest actualRequest =
        (ListProductsInProductSetRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProductSetName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listProductsInProductSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");

      client.listProductsInProductSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void importProductSetsTest() throws Exception {
    ImportProductSetsResponse expectedResponse = ImportProductSetsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importProductSetsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockProductSearch.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();

    ImportProductSetsResponse actualResponse =
        client.importProductSetsAsync(parent, inputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportProductSetsRequest actualRequest = (ImportProductSetsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(inputConfig, actualRequest.getInputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void importProductSetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();

      client.importProductSetsAsync(parent, inputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void purgeProductsTest() {
    String name = "name3373707";
    boolean done = true;
    Operation expectedResponse = Operation.newBuilder().setName(name).setDone(done).build();
    mockProductSearch.addResponse(expectedResponse);

    PurgeProductsRequest request = PurgeProductsRequest.newBuilder().build();

    Operation actualResponse = client.purgeProducts(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeProductsRequest actualRequest = (PurgeProductsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void purgeProductsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      PurgeProductsRequest request = PurgeProductsRequest.newBuilder().build();

      client.purgeProducts(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
