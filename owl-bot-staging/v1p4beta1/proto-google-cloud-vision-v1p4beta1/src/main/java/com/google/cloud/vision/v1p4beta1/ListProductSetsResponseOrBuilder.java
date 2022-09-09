// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/vision/v1p4beta1/product_search_service.proto

package com.google.cloud.vision.v1p4beta1;

public interface ListProductSetsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1p4beta1.ListProductSetsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * List of ProductSets.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.ProductSet product_sets = 1;</code>
   */
  java.util.List<com.google.cloud.vision.v1p4beta1.ProductSet> 
      getProductSetsList();
  /**
   * <pre>
   * List of ProductSets.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.ProductSet product_sets = 1;</code>
   */
  com.google.cloud.vision.v1p4beta1.ProductSet getProductSets(int index);
  /**
   * <pre>
   * List of ProductSets.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.ProductSet product_sets = 1;</code>
   */
  int getProductSetsCount();
  /**
   * <pre>
   * List of ProductSets.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.ProductSet product_sets = 1;</code>
   */
  java.util.List<? extends com.google.cloud.vision.v1p4beta1.ProductSetOrBuilder> 
      getProductSetsOrBuilderList();
  /**
   * <pre>
   * List of ProductSets.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.ProductSet product_sets = 1;</code>
   */
  com.google.cloud.vision.v1p4beta1.ProductSetOrBuilder getProductSetsOrBuilder(
      int index);

  /**
   * <pre>
   * Token to retrieve the next page of results, or empty if there are no more
   * results in the list.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   * @return The nextPageToken.
   */
  java.lang.String getNextPageToken();
  /**
   * <pre>
   * Token to retrieve the next page of results, or empty if there are no more
   * results in the list.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   * @return The bytes for nextPageToken.
   */
  com.google.protobuf.ByteString
      getNextPageTokenBytes();
}
