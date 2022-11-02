// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/vision/v1p1beta1/geometry.proto

package com.google.cloud.vision.v1p1beta1;

public interface PositionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1p1beta1.Position)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * X coordinate.
   * </pre>
   *
   * <code>float x = 1;</code>
   * @return The x.
   */
  float getX();

  /**
   * <pre>
   * Y coordinate.
   * </pre>
   *
   * <code>float y = 2;</code>
   * @return The y.
   */
  float getY();

  /**
   * <pre>
   * Z coordinate (or depth).
   * </pre>
   *
   * <code>float z = 3;</code>
   * @return The z.
   */
  float getZ();
}
