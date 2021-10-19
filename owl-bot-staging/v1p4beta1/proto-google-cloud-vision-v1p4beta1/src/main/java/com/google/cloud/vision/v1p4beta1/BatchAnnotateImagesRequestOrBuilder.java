// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/vision/v1p4beta1/image_annotator.proto

package com.google.cloud.vision.v1p4beta1;

public interface BatchAnnotateImagesRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. Individual image annotation requests for this batch.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.AnnotateImageRequest requests = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  java.util.List<com.google.cloud.vision.v1p4beta1.AnnotateImageRequest> 
      getRequestsList();
  /**
   * <pre>
   * Required. Individual image annotation requests for this batch.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.AnnotateImageRequest requests = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  com.google.cloud.vision.v1p4beta1.AnnotateImageRequest getRequests(int index);
  /**
   * <pre>
   * Required. Individual image annotation requests for this batch.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.AnnotateImageRequest requests = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  int getRequestsCount();
  /**
   * <pre>
   * Required. Individual image annotation requests for this batch.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.AnnotateImageRequest requests = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  java.util.List<? extends com.google.cloud.vision.v1p4beta1.AnnotateImageRequestOrBuilder> 
      getRequestsOrBuilderList();
  /**
   * <pre>
   * Required. Individual image annotation requests for this batch.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.AnnotateImageRequest requests = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  com.google.cloud.vision.v1p4beta1.AnnotateImageRequestOrBuilder getRequestsOrBuilder(
      int index);
}
