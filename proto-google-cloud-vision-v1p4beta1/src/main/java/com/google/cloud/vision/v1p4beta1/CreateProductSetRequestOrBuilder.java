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
// source: google/cloud/vision/v1p4beta1/product_search_service.proto

package com.google.cloud.vision.v1p4beta1;

public interface CreateProductSetRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1p4beta1.CreateProductSetRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The project in which the ProductSet should be created.
   * Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * </pre>
   *
   * <code>
   * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   */
  java.lang.String getParent();
  /**
   *
   *
   * <pre>
   * Required. The project in which the ProductSet should be created.
   * Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * </pre>
   *
   * <code>
   * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   */
  com.google.protobuf.ByteString getParentBytes();

  /**
   *
   *
   * <pre>
   * Required. The ProductSet to create.
   * </pre>
   *
   * <code>
   * .google.cloud.vision.v1p4beta1.ProductSet product_set = 2 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  boolean hasProductSet();
  /**
   *
   *
   * <pre>
   * Required. The ProductSet to create.
   * </pre>
   *
   * <code>
   * .google.cloud.vision.v1p4beta1.ProductSet product_set = 2 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  com.google.cloud.vision.v1p4beta1.ProductSet getProductSet();
  /**
   *
   *
   * <pre>
   * Required. The ProductSet to create.
   * </pre>
   *
   * <code>
   * .google.cloud.vision.v1p4beta1.ProductSet product_set = 2 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  com.google.cloud.vision.v1p4beta1.ProductSetOrBuilder getProductSetOrBuilder();

  /**
   *
   *
   * <pre>
   * A user-supplied resource id for this ProductSet. If set, the server will
   * attempt to use this value as the resource id. If it is already in use, an
   * error is returned with code ALREADY_EXISTS. Must be at most 128 characters
   * long. It cannot contain the character `/`.
   * </pre>
   *
   * <code>string product_set_id = 3;</code>
   */
  java.lang.String getProductSetId();
  /**
   *
   *
   * <pre>
   * A user-supplied resource id for this ProductSet. If set, the server will
   * attempt to use this value as the resource id. If it is already in use, an
   * error is returned with code ALREADY_EXISTS. Must be at most 128 characters
   * long. It cannot contain the character `/`.
   * </pre>
   *
   * <code>string product_set_id = 3;</code>
   */
  com.google.protobuf.ByteString getProductSetIdBytes();
}
