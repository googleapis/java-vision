/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.vision.v1p4beta1.samples;

// [START vision_v1p4beta1_generated_productsearchclient_removeproductfromproductset_stringproductname_sync]
import com.google.cloud.vision.v1p4beta1.ProductName;
import com.google.cloud.vision.v1p4beta1.ProductSearchClient;
import com.google.cloud.vision.v1p4beta1.ProductSetName;
import com.google.protobuf.Empty;

public class SyncRemoveProductFromProductSetStringProductname {

  public static void main(String[] args) throws Exception {
    syncRemoveProductFromProductSetStringProductname();
  }

  public static void syncRemoveProductFromProductSetStringProductname() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
      String name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString();
      ProductName product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
      productSearchClient.removeProductFromProductSet(name, product);
    }
  }
}
// [END vision_v1p4beta1_generated_productsearchclient_removeproductfromproductset_stringproductname_sync]
