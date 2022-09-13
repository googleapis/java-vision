// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/vision/v1/product_search_service.proto

package com.google.cloud.vision.v1;

public interface GetProductRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1.GetProductRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. Resource name of the Product to get.
   * Format is:
   * `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <pre>
   * Required. Resource name of the Product to get.
   * Format is:
   * `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();
}
