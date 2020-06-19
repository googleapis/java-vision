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

/**
 * A client to Cloud Vision API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>=================== ProductSearchClient ===================
 *
 * <p>Service Description: Manages Products and ProductSets of reference images for use in product
 * search. It uses the following resource model:
 *
 * <p>- The API has a collection of [ProductSet][google.cloud.vision.v1.ProductSet] resources, named
 * `projects/&#42;/locations/&#42;/productSets/&#42;`, which acts as a way to put different products
 * into groups to limit identification.
 *
 * <p>In parallel,
 *
 * <p>- The API has a collection of [Product][google.cloud.vision.v1.Product] resources, named
 * `projects/&#42;/locations/&#42;/products/&#42;`
 *
 * <p>- Each [Product][google.cloud.vision.v1.Product] has a collection of
 * [ReferenceImage][google.cloud.vision.v1.ReferenceImage] resources, named
 * `projects/&#42;/locations/&#42;/products/&#42;/referenceImages/&#42;`
 *
 * <p>Sample for ProductSearchClient:
 *
 * <pre>
 * <code>
 * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   ProductSet productSet = ProductSet.newBuilder().build();
 *   String productSetId = "";
 *   ProductSet response = productSearchClient.createProductSet(parent, productSet, productSetId);
 * }
 * </code>
 * </pre>
 *
 * ==================== ImageAnnotatorClient ====================
 *
 * <p>Service Description: Service that performs Google Cloud Vision API detection tasks over client
 * images, such as face, landmark, logo, label, and text detection. The ImageAnnotator service
 * returns detected entities from the images.
 *
 * <p>Sample for ImageAnnotatorClient:
 *
 * <pre>
 * <code>
 * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
 *   List&lt;AnnotateFileRequest&gt; requests = new ArrayList&lt;&gt;();
 *   BatchAnnotateFilesResponse response = imageAnnotatorClient.batchAnnotateFiles(requests);
 * }
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
package com.google.cloud.vision.v1;

import javax.annotation.Generated;
