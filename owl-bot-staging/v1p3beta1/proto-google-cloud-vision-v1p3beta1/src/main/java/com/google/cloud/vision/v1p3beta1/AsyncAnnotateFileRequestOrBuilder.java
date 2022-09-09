// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/vision/v1p3beta1/image_annotator.proto

package com.google.cloud.vision.v1p3beta1;

public interface AsyncAnnotateFileRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1p3beta1.AsyncAnnotateFileRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. Information about the input file.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.InputConfig input_config = 1;</code>
   * @return Whether the inputConfig field is set.
   */
  boolean hasInputConfig();
  /**
   * <pre>
   * Required. Information about the input file.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.InputConfig input_config = 1;</code>
   * @return The inputConfig.
   */
  com.google.cloud.vision.v1p3beta1.InputConfig getInputConfig();
  /**
   * <pre>
   * Required. Information about the input file.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.InputConfig input_config = 1;</code>
   */
  com.google.cloud.vision.v1p3beta1.InputConfigOrBuilder getInputConfigOrBuilder();

  /**
   * <pre>
   * Required. Requested features.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p3beta1.Feature features = 2;</code>
   */
  java.util.List<com.google.cloud.vision.v1p3beta1.Feature> 
      getFeaturesList();
  /**
   * <pre>
   * Required. Requested features.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p3beta1.Feature features = 2;</code>
   */
  com.google.cloud.vision.v1p3beta1.Feature getFeatures(int index);
  /**
   * <pre>
   * Required. Requested features.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p3beta1.Feature features = 2;</code>
   */
  int getFeaturesCount();
  /**
   * <pre>
   * Required. Requested features.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p3beta1.Feature features = 2;</code>
   */
  java.util.List<? extends com.google.cloud.vision.v1p3beta1.FeatureOrBuilder> 
      getFeaturesOrBuilderList();
  /**
   * <pre>
   * Required. Requested features.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p3beta1.Feature features = 2;</code>
   */
  com.google.cloud.vision.v1p3beta1.FeatureOrBuilder getFeaturesOrBuilder(
      int index);

  /**
   * <pre>
   * Additional context that may accompany the image(s) in the file.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.ImageContext image_context = 3;</code>
   * @return Whether the imageContext field is set.
   */
  boolean hasImageContext();
  /**
   * <pre>
   * Additional context that may accompany the image(s) in the file.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.ImageContext image_context = 3;</code>
   * @return The imageContext.
   */
  com.google.cloud.vision.v1p3beta1.ImageContext getImageContext();
  /**
   * <pre>
   * Additional context that may accompany the image(s) in the file.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.ImageContext image_context = 3;</code>
   */
  com.google.cloud.vision.v1p3beta1.ImageContextOrBuilder getImageContextOrBuilder();

  /**
   * <pre>
   * Required. The desired output location and metadata (e.g. format).
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.OutputConfig output_config = 4;</code>
   * @return Whether the outputConfig field is set.
   */
  boolean hasOutputConfig();
  /**
   * <pre>
   * Required. The desired output location and metadata (e.g. format).
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.OutputConfig output_config = 4;</code>
   * @return The outputConfig.
   */
  com.google.cloud.vision.v1p3beta1.OutputConfig getOutputConfig();
  /**
   * <pre>
   * Required. The desired output location and metadata (e.g. format).
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.OutputConfig output_config = 4;</code>
   */
  com.google.cloud.vision.v1p3beta1.OutputConfigOrBuilder getOutputConfigOrBuilder();
}
