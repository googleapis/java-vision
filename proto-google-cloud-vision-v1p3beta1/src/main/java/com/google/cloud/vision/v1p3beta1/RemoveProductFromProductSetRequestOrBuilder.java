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
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/vision/v1p3beta1/product_search_service.proto

package com.google.cloud.vision.v1p3beta1;

public interface RemoveProductFromProductSetRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1p3beta1.RemoveProductFromProductSetRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The resource name for the ProductSet to modify.
   * Format is:
   * `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * </pre>
   *
   * <code>string name = 1;</code>
   *
   * @return The name.
   */
  java.lang.String getName();
  /**
   *
   *
   * <pre>
   * The resource name for the ProductSet to modify.
   * Format is:
   * `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * </pre>
   *
   * <code>string name = 1;</code>
   *
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString getNameBytes();

  /**
   *
   *
   * <pre>
   * The resource name for the Product to be removed from this ProductSet.
   * Format is:
   * `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * </pre>
   *
   * <code>string product = 2;</code>
   *
   * @return The product.
   */
  java.lang.String getProduct();
  /**
   *
   *
   * <pre>
   * The resource name for the Product to be removed from this ProductSet.
   * Format is:
   * `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * </pre>
   *
   * <code>string product = 2;</code>
   *
   * @return The bytes for product.
   */
  com.google.protobuf.ByteString getProductBytes();
}
