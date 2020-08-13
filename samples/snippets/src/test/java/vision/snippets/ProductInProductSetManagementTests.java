/*
 * Copyright 2019 Google LLC
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

package vision.snippets;

import static com.google.common.truth.Truth.assertThat;

import com.example.vision.ProductInProductSetManagement;
import com.example.vision.ProductManagement;
import com.example.vision.ProductSetManagement;
import com.example.vision.snippets.PurgeProductsInProductSet;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProductInProductSetManagementTests {
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

  @Before
  public void setUp() throws IOException {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
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
    System.setOut(null);
  }

  @Test
  public void testPurgeProductsInProductSet() throws Exception {
    // Act
    ProductInProductSetManagement.addProductToProductSet(
            PROJECT_ID, COMPUTE_REGION, PRODUCT_ID, PRODUCT_SET_ID);
    ProductManagement.listProducts(
            PROJECT_ID, COMPUTE_REGION);

    // Assert
    String got = bout.toString();
    assertThat(got).contains(PRODUCT_ID);

    bout.reset();
    PurgeProductsInProductSet.purgeProductsInProductSet(
            PROJECT_ID, COMPUTE_REGION, PRODUCT_SET_ID);

    ProductManagement.listProducts(
            PROJECT_ID, COMPUTE_REGION);

    // Assert
    got = bout.toString();
    assertThat(got).doesNotContain(PRODUCT_ID);
  }
}
