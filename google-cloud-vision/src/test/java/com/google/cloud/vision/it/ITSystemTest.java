/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.vision.it;

import static com.google.cloud.vision.v1.Feature.Type;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.ServiceOptions;
import com.google.cloud.vision.v1.AddProductToProductSetRequest;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.ColorInfo;
import com.google.cloud.vision.v1.CreateProductRequest;
import com.google.cloud.vision.v1.CreateProductSetRequest;
import com.google.cloud.vision.v1.CreateReferenceImageRequest;
import com.google.cloud.vision.v1.CropHint;
import com.google.cloud.vision.v1.CropHintsAnnotation;
import com.google.cloud.vision.v1.DeleteProductRequest;
import com.google.cloud.vision.v1.DeleteProductSetRequest;
import com.google.cloud.vision.v1.DeleteReferenceImageRequest;
import com.google.cloud.vision.v1.DominantColorsAnnotation;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.FaceAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.GetProductRequest;
import com.google.cloud.vision.v1.GetProductSetRequest;
import com.google.cloud.vision.v1.GetReferenceImageRequest;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageContext;
import com.google.cloud.vision.v1.ImageSource;
import com.google.cloud.vision.v1.Likelihood;
import com.google.cloud.vision.v1.ListProductSetsRequest;
import com.google.cloud.vision.v1.ListProductsInProductSetRequest;
import com.google.cloud.vision.v1.ListProductsRequest;
import com.google.cloud.vision.v1.ListReferenceImagesRequest;
import com.google.cloud.vision.v1.LocalizedObjectAnnotation;
import com.google.cloud.vision.v1.LocationName;
import com.google.cloud.vision.v1.Product;
import com.google.cloud.vision.v1.ProductName;
import com.google.cloud.vision.v1.ProductSearchClient;
import com.google.cloud.vision.v1.ProductSet;
import com.google.cloud.vision.v1.ProductSetName;
import com.google.cloud.vision.v1.ReferenceImage;
import com.google.cloud.vision.v1.ReferenceImageName;
import com.google.cloud.vision.v1.RemoveProductFromProductSetRequest;
import com.google.cloud.vision.v1.SafeSearchAnnotation;
import com.google.cloud.vision.v1.TextAnnotation;
import com.google.cloud.vision.v1.UpdateProductRequest;
import com.google.cloud.vision.v1.Vertex;
import com.google.cloud.vision.v1.WebDetection;
import com.google.cloud.vision.v1.WebDetectionParams;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static ImageAnnotatorClient imageAnnotatorClient;
  private static ProductSearchClient productSearchClient;
  private static Product product;
  private static String formatProductName;
  private static String productName;
  private static ProductSet productSet;
  private static String productSetName;
  private static String formatProductSetName;
  private static ReferenceImage referenceImage;
  private static String referenceImageName;
  private static String formatReferenceImageName;
  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String ID = UUID.randomUUID().toString().substring(0, 8);
  private static final String RESOURCES = "src/test/resources/";
  private static final String SAMPLE_BUCKET = "gs://cloud-samples-data/vision/";
  private static final String SAMPLE_URI =
      "https://storage-download.googleapis.com/cloud-samples-data/vision/";
  private static final String COMPUTE_REGION = "us-west1";
  private static final String LOCATION_NAME =
      LocationName.of(PROJECT_ID, COMPUTE_REGION).toString();
  private static final String PRODUCT_DISPLAY_NAME = "test-product-display-name-" + ID;
  private static final String PRODUCT_CATEGORY = "homegoods";
  private static final String PRODUCT_ID = "test-product-" + ID;
  private static final String KEY = "test-key-" + ID;
  private static final String VALUE = "test-value-" + ID;
  private static final Product.KeyValue KEY_VALUE =
      Product.KeyValue.newBuilder().setKey(KEY).setValue(VALUE).build();
  private static final String PRODUCT_SET_ID = "test-product-set-" + ID;
  private static final String PRODUCT_SET_DISPLAY_NAME = "test-product-set-display-name-" + ID;

  @BeforeClass
  public static void setUp() throws IOException {

    imageAnnotatorClient = ImageAnnotatorClient.create();

    /* create product */
    productSearchClient = ProductSearchClient.create();
    Product createProduct =
        Product.newBuilder()
            .setName(PRODUCT_ID)
            .setDisplayName(PRODUCT_DISPLAY_NAME)
            .setProductCategory(PRODUCT_CATEGORY)
            .build();
    CreateProductRequest productRequest =
        CreateProductRequest.newBuilder()
            .setParent(LOCATION_NAME)
            .setProduct(createProduct)
            .build();
    product = productSearchClient.createProduct(productRequest);
    productName = getName(product.getName());
    formatProductName = ProductName.of(PROJECT_ID, COMPUTE_REGION, productName).toString();

    /* create product set */
    ProductSet createProductSet =
        ProductSet.newBuilder().setDisplayName(PRODUCT_SET_DISPLAY_NAME).build();
    CreateProductSetRequest productSetRequest =
        CreateProductSetRequest.newBuilder()
            .setParent(LOCATION_NAME)
            .setProductSet(createProductSet)
            .setProductSetId(PRODUCT_SET_ID)
            .build();
    productSet = productSearchClient.createProductSet(productSetRequest);
    productSetName = getName(productSet.getName());
    formatProductSetName = ProductSetName.of(PROJECT_ID, COMPUTE_REGION, productSetName).toString();

    /* add product to product set */
    AddProductToProductSetRequest productToProductSetRequest =
        AddProductToProductSetRequest.newBuilder()
            .setName(formatProductSetName)
            .setProduct(formatProductName)
            .build();
    productSearchClient.addProductToProductSet(productToProductSetRequest);

    /* create reference image */
    ReferenceImage createReferenceImage =
        ReferenceImage.newBuilder().setUri(SAMPLE_BUCKET + "product_search/shoes_1.jpg").build();
    CreateReferenceImageRequest imageRequest =
        CreateReferenceImageRequest.newBuilder()
            .setParent(formatProductName)
            .setReferenceImage(createReferenceImage)
            .build();
    referenceImage = productSearchClient.createReferenceImage(imageRequest);
    referenceImageName = getName(referenceImage.getName());
    formatReferenceImageName =
        ReferenceImageName.of(PROJECT_ID, COMPUTE_REGION, productName, referenceImageName)
            .toString();
  }

  @AfterClass
  public static void tearDown() {

    /* delete reference image */
    DeleteReferenceImageRequest imageRequest =
        DeleteReferenceImageRequest.newBuilder().setName(formatReferenceImageName).build();
    productSearchClient.deleteReferenceImage(imageRequest);

    /* remove product from product set */
    RemoveProductFromProductSetRequest removeProductRequest =
        RemoveProductFromProductSetRequest.newBuilder()
            .setName(formatProductSetName)
            .setProduct(formatProductName)
            .build();
    productSearchClient.removeProductFromProductSet(removeProductRequest);

    /* delete product set */
    DeleteProductSetRequest deleteProductSetRequest =
        DeleteProductSetRequest.newBuilder().setName(formatProductSetName).build();
    productSearchClient.deleteProductSet(deleteProductSetRequest);

    /* delete product */
    DeleteProductRequest deleteProductRequest =
        DeleteProductRequest.newBuilder().setName(formatProductName).build();
    productSearchClient.deleteProduct(deleteProductRequest);
    productSearchClient.close();

    imageAnnotatorClient.close();
  }

  @Test
  public void detectFacesTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("face_no_surprise.jpg", Type.FACE_DETECTION, false);
    for (AnnotateImageResponse res : responses) {
      for (FaceAnnotation annotation : res.getFaceAnnotationsList()) {
        assertEquals(Likelihood.POSSIBLE, annotation.getAngerLikelihood());
        assertEquals(Likelihood.POSSIBLE, annotation.getJoyLikelihood());
        assertEquals(Likelihood.LIKELY, annotation.getSurpriseLikelihood());
      }
    }
  }

  @Test
  public void detectFacesGcsTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("face/face_no_surprise.jpg", Type.FACE_DETECTION, true);
    for (AnnotateImageResponse res : responses) {
      for (FaceAnnotation annotation : res.getFaceAnnotationsList()) {
        assertEquals(Likelihood.POSSIBLE, annotation.getAngerLikelihood());
        assertEquals(Likelihood.POSSIBLE, annotation.getJoyLikelihood());
        assertEquals(Likelihood.LIKELY, annotation.getSurpriseLikelihood());
      }
    }
  }

  @Test
  public void detectLabelsTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("wakeupcat.jpg", Type.LABEL_DETECTION, false);
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
        actual.add(annotation.getDescription());
      }
    }
    assertTrue(actual.contains("Whiskers"));
  }

  @Test
  public void detectLabelsGcsTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("label/wakeupcat.jpg", Type.LABEL_DETECTION, true);
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
        actual.add(annotation.getDescription());
      }
    }
    assertTrue(actual.contains("Whiskers"));
  }

  @Test
  public void detectLandmarksTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("landmark.jpg", Type.LANDMARK_DETECTION, false);
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getLandmarkAnnotationsList()) {
        actual.add(annotation.getDescription());
      }
    }
    assertTrue(actual.contains("Palace of Fine Arts"));
  }

  @Test
  public void detectLandmarksUrlTest() {
    ImageSource imgSource =
        ImageSource.newBuilder().setImageUri(SAMPLE_URI + "landmark/pofa.jpg").build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.LANDMARK_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getLandmarkAnnotationsList()) {
        actual.add(annotation.getDescription());
      }
    }
    assertTrue(actual.contains("Palace of Fine Arts"));
  }

  @Test
  public void detectLandmarksGcsTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("landmark/pofa.jpg", Type.LANDMARK_DETECTION, true);
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getLandmarkAnnotationsList()) {
        actual.add(annotation.getDescription());
      }
    }
    assertTrue(actual.contains("Palace of Fine Arts"));
  }

  @Test
  public void detectLogosTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("logos.png", Type.LOGO_DETECTION, false);
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getLogoAnnotationsList()) {
        assertEquals("Google", annotation.getDescription());
      }
    }
  }

  @Test
  public void detectLogosGcsTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("logo/logo_google.png", Type.LOGO_DETECTION, true);
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getLogoAnnotationsList()) {
        assertEquals("Google", annotation.getDescription());
      }
    }
  }

  @Test
  public void detectTextTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("text.jpg", Type.TEXT_DETECTION, false);
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
        actual.add(annotation.getDescription());
      }
    }
    assertTrue(actual.contains("37%"));
  }

  @Test
  public void detectTextGcsTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("text/screen.jpg", Type.TEXT_DETECTION, true);
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
        actual.add(annotation.getDescription());
      }
    }
    assertTrue(actual.contains("37%"));
  }

  @Test
  public void detectPropertiesTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("landmark.jpg", Type.IMAGE_PROPERTIES, false);
    List<Float> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      DominantColorsAnnotation colors = res.getImagePropertiesAnnotation().getDominantColors();
      for (ColorInfo color : colors.getColorsList()) {
        actual.add(color.getPixelFraction());
      }
    }
    assertTrue(actual.contains((float) 0.14140345));
  }

  @Test
  public void detectPropertiesGcsTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("landmark/pofa.jpg", Type.IMAGE_PROPERTIES, true);
    List<Float> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      DominantColorsAnnotation colors = res.getImagePropertiesAnnotation().getDominantColors();
      for (ColorInfo color : colors.getColorsList()) {
        actual.add(color.getPixelFraction());
      }
    }
    assertTrue(actual.contains((float) 0.14140345));
  }

  @Test
  public void detectSafeSearchTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("wakeupcat.jpg", Type.SAFE_SEARCH_DETECTION, false);
    for (AnnotateImageResponse res : responses) {
      SafeSearchAnnotation annotation = res.getSafeSearchAnnotation();
      assertEquals(Likelihood.VERY_UNLIKELY, annotation.getAdult());
      assertEquals(Likelihood.UNLIKELY, annotation.getRacy());
    }
  }

  @Test
  public void detectSafeSearchGcsTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("label/wakeupcat.jpg", Type.SAFE_SEARCH_DETECTION, true);
    for (AnnotateImageResponse res : responses) {
      SafeSearchAnnotation annotation = res.getSafeSearchAnnotation();
      assertEquals(Likelihood.VERY_UNLIKELY, annotation.getAdult());
      assertEquals(Likelihood.UNLIKELY, annotation.getRacy());
    }
  }

  @Test
  public void detectWebEntitiesTest() throws IOException {
    List<AnnotateImageResponse> responses = getResponsesList("city.jpg", Type.WEB_DETECTION, false);
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse imgResponse : responses) {
      for (WebDetection.WebEntity entity : imgResponse.getWebDetection().getWebEntitiesList()) {
        actual.add(entity.getDescription());
      }
    }
    assertTrue(actual.contains("Skyscraper"));
  }

  @Test
  public void detectWebEntitiesGcsTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("landmark/pofa.jpg", Type.WEB_DETECTION, true);
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse imgResponse : responses) {
      for (WebDetection.WebEntity entity : imgResponse.getWebDetection().getWebEntitiesList()) {
        actual.add(entity.getDescription());
      }
    }
    assertTrue(actual.contains("The Palace Of Fine Arts"));
  }

  @Test
  public void detectWebEntitiesIncludeGeoResultsTest() throws IOException {
    ByteString imgBytes = ByteString.readFrom(new FileInputStream(RESOURCES + "city.jpg"));
    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();
    WebDetectionParams webDetectionParams =
        WebDetectionParams.newBuilder().setIncludeGeoResults(true).build();
    ImageContext imageContext =
        ImageContext.newBuilder().setWebDetectionParams(webDetectionParams).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder()
            .addFeatures(feat)
            .setImageContext(imageContext)
            .setImage(img)
            .build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse imgResponse : responses) {
      for (WebDetection.WebEntity entity : imgResponse.getWebDetection().getWebEntitiesList()) {
        actual.add(entity.getDescription());
      }
    }
    assertTrue(actual.contains("Skyscraper"));
  }

  @Test
  public void detectWebEntitiesIncludeGeoResultsGcsTest() {
    ImageSource imgSource =
        ImageSource.newBuilder().setGcsImageUri(SAMPLE_BUCKET + "landmark/pofa.jpg").build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();
    WebDetectionParams webDetectionParams =
        WebDetectionParams.newBuilder().setIncludeGeoResults(true).build();
    ImageContext imageContext =
        ImageContext.newBuilder().setWebDetectionParams(webDetectionParams).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder()
            .addFeatures(feat)
            .setImageContext(imageContext)
            .setImage(img)
            .build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse imgResponse : responses) {
      for (WebDetection.WebEntity entity : imgResponse.getWebDetection().getWebEntitiesList()) {
        actual.add(entity.getDescription());
      }
    }
    assertTrue(actual.contains("The Palace Of Fine Arts"));
  }

  @Test
  public void detectCropHintsTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("wakeupcat.jpg", Type.CROP_HINTS, false);
    List<Integer> actual = new ArrayList<>();
    for (AnnotateImageResponse imgResponse : responses) {
      CropHintsAnnotation annotation = imgResponse.getCropHintsAnnotation();
      for (CropHint hint : annotation.getCropHintsList()) {
        for (Vertex vertex : hint.getBoundingPoly().getVerticesList()) {
          actual.add(vertex.getX());
        }
      }
    }
    assertEquals(Arrays.asList(210, 476, 476, 210), actual);
  }

  @Test
  public void detectCropHintsGcsTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("label/wakeupcat.jpg", Type.CROP_HINTS, true);
    List<Integer> actual = new ArrayList<>();
    for (AnnotateImageResponse imgResponse : responses) {
      CropHintsAnnotation annotation = imgResponse.getCropHintsAnnotation();
      for (CropHint hint : annotation.getCropHintsList()) {
        for (Vertex vertex : hint.getBoundingPoly().getVerticesList()) {
          actual.add(vertex.getX());
        }
      }
    }
    assertEquals(Arrays.asList(210, 476, 476, 210), actual);
  }

  @Test
  public void detectDocumentTextTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("text.jpg", Type.DOCUMENT_TEXT_DETECTION, false);
    String actual = "";
    for (AnnotateImageResponse imgResponse : responses) {
      TextAnnotation annotation = imgResponse.getFullTextAnnotation();
      actual = annotation.getText();
    }
    assertTrue(actual.contains("After preparation is complete"));
  }

  @Test
  public void detectDocumentTextGcs() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("text/screen.jpg", Type.DOCUMENT_TEXT_DETECTION, true);
    String actual = "";
    for (AnnotateImageResponse imgResponse : responses) {
      TextAnnotation annotation = imgResponse.getFullTextAnnotation();
      actual = annotation.getText();
    }
    assertTrue(actual.contains("After preparation is complete"));
  }

  @Test
  public void detectLocalizedObjectsTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("puppies.jpg", Type.OBJECT_LOCALIZATION, false);
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (LocalizedObjectAnnotation entity : res.getLocalizedObjectAnnotationsList()) {
        actual.add(entity.getName());
      }
    }
    assertTrue(actual.contains("Dog"));
  }

  @Test
  public void detectLocalizedObjectsGcsTest() throws IOException {
    List<AnnotateImageResponse> responses =
        getResponsesList("object_localization/puppies.jpg", Type.OBJECT_LOCALIZATION, true);
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (LocalizedObjectAnnotation entity : res.getLocalizedObjectAnnotationsList()) {
        actual.add(entity.getName());
      }
    }
    assertTrue(actual.contains("Dog"));
  }

  @Test
  public void listProductsTest() {
    ListProductsRequest request = ListProductsRequest.newBuilder().setParent(LOCATION_NAME).build();
    for (Product actualProduct : productSearchClient.listProducts(request).iterateAll()) {
      if (product.getName().equals(actualProduct.getName())) {
        assertEquals(PRODUCT_DISPLAY_NAME, actualProduct.getDisplayName());
        assertEquals(PRODUCT_CATEGORY, actualProduct.getProductCategory());
      }
    }
  }

  @Test
  public void getProductTest() {
    GetProductRequest request = GetProductRequest.newBuilder().setName(formatProductName).build();
    Product actualProduct = productSearchClient.getProduct(request);
    assertEquals(product.getName(), actualProduct.getName());
    assertEquals(PRODUCT_DISPLAY_NAME, actualProduct.getDisplayName());
    assertEquals(PRODUCT_CATEGORY, actualProduct.getProductCategory());
  }

  @Test
  public void updateProductTest() {
    Product updateProduct = product.toBuilder().addProductLabels(KEY_VALUE).build();
    UpdateProductRequest request =
        UpdateProductRequest.newBuilder().setProduct(updateProduct).build();
    Product actualProduct = productSearchClient.updateProduct(request);
    assertEquals(product.getName(), actualProduct.getName());
    assertEquals(PRODUCT_DISPLAY_NAME, actualProduct.getDisplayName());
    assertEquals(PRODUCT_CATEGORY, actualProduct.getProductCategory());
    assertEquals(ImmutableList.of(KEY_VALUE), actualProduct.getProductLabelsList());
    assertEquals(1, actualProduct.getProductLabelsCount());
  }

  @Test
  public void listProductSetsTest() {
    ListProductSetsRequest request =
        ListProductSetsRequest.newBuilder().setParent(LOCATION_NAME).build();
    for (ProductSet actualProductSet : productSearchClient.listProductSets(request).iterateAll()) {
      if (productSet.getName().equals(actualProductSet.getName())) {
        assertEquals(PRODUCT_SET_DISPLAY_NAME, actualProductSet.getDisplayName());
      }
    }
  }

  @Test
  public void getProductSetTest() {
    GetProductSetRequest request =
        GetProductSetRequest.newBuilder().setName(formatProductSetName).build();
    ProductSet actualProductSet = productSearchClient.getProductSet(request);
    assertEquals(productSet.getName(), actualProductSet.getName());
    assertEquals(PRODUCT_SET_DISPLAY_NAME, actualProductSet.getDisplayName());
  }

  @Test
  public void listProductsInProductSetTest() {
    ListProductsInProductSetRequest request =
        ListProductsInProductSetRequest.newBuilder().setName(formatProductSetName).build();
    for (Product actualProduct :
        productSearchClient.listProductsInProductSet(request).iterateAll()) {
      assertEquals(product.getName(), actualProduct.getName());
      assertEquals(PRODUCT_DISPLAY_NAME, actualProduct.getDisplayName());
      assertEquals(PRODUCT_CATEGORY, actualProduct.getProductCategory());
    }
  }

  @Test
  public void listReferenceImagesTest() {
    ListReferenceImagesRequest request =
        ListReferenceImagesRequest.newBuilder().setParent(formatProductName).build();
    for (ReferenceImage actualReferenceImage :
        productSearchClient.listReferenceImages(request).iterateAll()) {
      assertEquals(referenceImage.getName(), actualReferenceImage.getName());
      assertEquals(referenceImage.getUri(), actualReferenceImage.getUri());
    }
  }

  @Test
  public void getReferenceImageTest() {
    GetReferenceImageRequest request =
        GetReferenceImageRequest.newBuilder().setName(formatReferenceImageName).build();
    ReferenceImage actualReferenceImage = productSearchClient.getReferenceImage(request);
    assertEquals(referenceImage.getName(), actualReferenceImage.getName());
    assertEquals(referenceImage.getUri(), actualReferenceImage.getUri());
  }

  private static String getName(String name) {
    return name.substring(name.lastIndexOf("/")).replace("/", "");
  }

  private static List<AnnotateImageResponse> getResponsesList(
      String image, Type type, boolean isGcs) throws IOException {
    ImageSource imgSource;
    Image img;
    if (isGcs) {
      imgSource = ImageSource.newBuilder().setGcsImageUri(SAMPLE_BUCKET + image).build();
      img = Image.newBuilder().setSource(imgSource).build();
    } else {
      ByteString imgBytes = ByteString.readFrom(new FileInputStream(RESOURCES + image));
      img = Image.newBuilder().setContent(imgBytes).build();
    }
    Feature feat = Feature.newBuilder().setType(type).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    return response.getResponsesList();
  }
}
