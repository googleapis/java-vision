// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/vision/v1p3beta1/product_search_service.proto

package com.google.cloud.vision.v1p3beta1;

public interface CreateProductSetRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1p3beta1.CreateProductSetRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. The project in which the ProductSet should be created.
   * Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * </pre>
   *
   * <code>string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
   * @return The parent.
   */
  java.lang.String getParent();
  /**
   * <pre>
   * Required. The project in which the ProductSet should be created.
   * Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * </pre>
   *
   * <code>string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
   * @return The bytes for parent.
   */
  com.google.protobuf.ByteString
      getParentBytes();

  /**
   * <pre>
   * Required. The ProductSet to create.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.ProductSet product_set = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return Whether the productSet field is set.
   */
  boolean hasProductSet();
  /**
   * <pre>
   * Required. The ProductSet to create.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.ProductSet product_set = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The productSet.
   */
  com.google.cloud.vision.v1p3beta1.ProductSet getProductSet();
  /**
   * <pre>
   * Required. The ProductSet to create.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.ProductSet product_set = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  com.google.cloud.vision.v1p3beta1.ProductSetOrBuilder getProductSetOrBuilder();

  /**
   * <pre>
   * A user-supplied resource id for this ProductSet. If set, the server will
   * attempt to use this value as the resource id. If it is already in use, an
   * error is returned with code ALREADY_EXISTS. Must be at most 128 characters
   * long. It cannot contain the character `/`.
   * </pre>
   *
   * <code>string product_set_id = 3;</code>
   * @return The productSetId.
   */
  java.lang.String getProductSetId();
  /**
   * <pre>
   * A user-supplied resource id for this ProductSet. If set, the server will
   * attempt to use this value as the resource id. If it is already in use, an
   * error is returned with code ALREADY_EXISTS. Must be at most 128 characters
   * long. It cannot contain the character `/`.
   * </pre>
   *
   * <code>string product_set_id = 3;</code>
   * @return The bytes for productSetId.
   */
  com.google.protobuf.ByteString
      getProductSetIdBytes();
}
