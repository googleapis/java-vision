// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/vision/v1p4beta1/image_annotator.proto

package com.google.cloud.vision.v1p4beta1;

public interface BatchAnnotateImagesResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Individual responses to image annotation requests within the batch.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.AnnotateImageResponse responses = 1;</code>
   */
  java.util.List<com.google.cloud.vision.v1p4beta1.AnnotateImageResponse> 
      getResponsesList();
  /**
   * <pre>
   * Individual responses to image annotation requests within the batch.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.AnnotateImageResponse responses = 1;</code>
   */
  com.google.cloud.vision.v1p4beta1.AnnotateImageResponse getResponses(int index);
  /**
   * <pre>
   * Individual responses to image annotation requests within the batch.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.AnnotateImageResponse responses = 1;</code>
   */
  int getResponsesCount();
  /**
   * <pre>
   * Individual responses to image annotation requests within the batch.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.AnnotateImageResponse responses = 1;</code>
   */
  java.util.List<? extends com.google.cloud.vision.v1p4beta1.AnnotateImageResponseOrBuilder> 
      getResponsesOrBuilderList();
  /**
   * <pre>
   * Individual responses to image annotation requests within the batch.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.AnnotateImageResponse responses = 1;</code>
   */
  com.google.cloud.vision.v1p4beta1.AnnotateImageResponseOrBuilder getResponsesOrBuilder(
      int index);
}
