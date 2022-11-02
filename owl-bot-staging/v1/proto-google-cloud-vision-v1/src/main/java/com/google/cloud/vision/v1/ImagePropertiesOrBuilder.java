// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/vision/v1/image_annotator.proto

package com.google.cloud.vision.v1;

public interface ImagePropertiesOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1.ImageProperties)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * If present, dominant colors completed successfully.
   * </pre>
   *
   * <code>.google.cloud.vision.v1.DominantColorsAnnotation dominant_colors = 1;</code>
   * @return Whether the dominantColors field is set.
   */
  boolean hasDominantColors();
  /**
   * <pre>
   * If present, dominant colors completed successfully.
   * </pre>
   *
   * <code>.google.cloud.vision.v1.DominantColorsAnnotation dominant_colors = 1;</code>
   * @return The dominantColors.
   */
  com.google.cloud.vision.v1.DominantColorsAnnotation getDominantColors();
  /**
   * <pre>
   * If present, dominant colors completed successfully.
   * </pre>
   *
   * <code>.google.cloud.vision.v1.DominantColorsAnnotation dominant_colors = 1;</code>
   */
  com.google.cloud.vision.v1.DominantColorsAnnotationOrBuilder getDominantColorsOrBuilder();
}
