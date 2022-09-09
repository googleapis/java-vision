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

package com.google.cloud.vision.v1p3beta1.samples;

// [START vision_v1p3beta1_generated_productsearchclient_listreferenceimages_string_sync]
import com.google.cloud.vision.v1p3beta1.ProductName;
import com.google.cloud.vision.v1p3beta1.ProductSearchClient;
import com.google.cloud.vision.v1p3beta1.ReferenceImage;

public class SyncListReferenceImagesString {

  public static void main(String[] args) throws Exception {
    syncListReferenceImagesString();
  }

  public static void syncListReferenceImagesString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
      String parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString();
      for (ReferenceImage element : productSearchClient.listReferenceImages(parent).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END vision_v1p3beta1_generated_productsearchclient_listreferenceimages_string_sync]
