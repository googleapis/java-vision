// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/vision/v1p3beta1/image_annotator.proto

package com.google.cloud.vision.v1p3beta1;

public interface GcsSourceOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1p3beta1.GcsSource)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Google Cloud Storage URI for the input file. This must only be a
   * Google Cloud Storage object. Wildcards are not currently supported.
   * </pre>
   *
   * <code>string uri = 1;</code>
   * @return The uri.
   */
  java.lang.String getUri();
  /**
   * <pre>
   * Google Cloud Storage URI for the input file. This must only be a
   * Google Cloud Storage object. Wildcards are not currently supported.
   * </pre>
   *
   * <code>string uri = 1;</code>
   * @return The bytes for uri.
   */
  com.google.protobuf.ByteString
      getUriBytes();
}
