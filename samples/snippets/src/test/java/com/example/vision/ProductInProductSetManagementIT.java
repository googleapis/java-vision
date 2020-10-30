/*
 * Copyright 2018 Google LLC
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

import static com.google.common.truth.Truth.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link ProductInProductSetManagement}. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class ProductInProductSetManagementIT {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String COMPUTE_REGION = "us-west1";
  private static final String PRODUCT_SET_DISPLAY_NAME =
      String.format("test_%s", UUID.randomUUID().toString());
  private static final String PRODUCT_SET_ID =
      String.format("test_%s", UUID.randomUUID().toString());
  private static final String PRODUCT_DISPLAY_NAME =
      String.format("test_%s", UUID.randomUUID().toString());
  private static final String PRODUCT_CATEGORY = "apparel";
  private static final String PRODUCT_ID = String.format("test_%s", UUID.randomUUID().toString());
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() throws IOException {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
    ProductSetManagement.createProductSet(
        PROJECT_ID, COMPUTE_REGION, PRODUCT_SET_ID, PRODUCT_SET_DISPLAY_NAME);
    ProductManagement.createProduct(
        PROJECT_ID, COMPUTE_REGION, PRODUCT_ID, PRODUCT_DISPLAY_NAME, PRODUCT_CATEGORY);
    bout.reset();
  }

  @After
  public void tearDown() throws IOException {
    ProductManagement.deleteProduct(PROJECT_ID, COMPUTE_REGION, PRODUCT_ID);
    ProductSetManagement.deleteProductSet(PROJECT_ID, COMPUTE_REGION, PRODUCT_SET_ID);
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testAddProductToProductSet() throws Exception {
    // Act
    ProductInProductSetManagement.addProductToProductSet(
        PROJECT_ID, COMPUTE_REGION, PRODUCT_ID, PRODUCT_SET_ID);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Product added to product set.");
  }

  @Test
  public void testRemoveProductFromProductSet() throws Exception {
    // Act
    ProductInProductSetManagement.addProductToProductSet(
        PROJECT_ID, COMPUTE_REGION, PRODUCT_ID, PRODUCT_SET_ID);
    ProductInProductSetManagement.listProductsInProductSet(
        PROJECT_ID, COMPUTE_REGION, PRODUCT_SET_ID);

    // Assert
    String got = bout.toString();
    assertThat(got).contains(PRODUCT_ID);

    bout.reset();

    // Act
    ProductInProductSetManagement.removeProductFromProductSet(
        PROJECT_ID, COMPUTE_REGION, PRODUCT_ID, PRODUCT_SET_ID);
    ProductInProductSetManagement.listProductsInProductSet(
        PROJECT_ID, COMPUTE_REGION, PRODUCT_SET_ID);

    // Assert
    got = bout.toString();
    assertThat(got).doesNotContain(PRODUCT_ID);
  }
}
