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
// source: google/cloud/vision/v1/image_annotator.proto

package com.google.cloud.vision.v1;

public interface LatLongRectOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1.LatLongRect)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Min lat/long pair.
   * </pre>
   *
   * <code>.google.type.LatLng min_lat_lng = 1;</code>
   */
  boolean hasMinLatLng();
  /**
   *
   *
   * <pre>
   * Min lat/long pair.
   * </pre>
   *
   * <code>.google.type.LatLng min_lat_lng = 1;</code>
   */
  com.google.type.LatLng getMinLatLng();
  /**
   *
   *
   * <pre>
   * Min lat/long pair.
   * </pre>
   *
   * <code>.google.type.LatLng min_lat_lng = 1;</code>
   */
  com.google.type.LatLngOrBuilder getMinLatLngOrBuilder();

  /**
   *
   *
   * <pre>
   * Max lat/long pair.
   * </pre>
   *
   * <code>.google.type.LatLng max_lat_lng = 2;</code>
   */
  boolean hasMaxLatLng();
  /**
   *
   *
   * <pre>
   * Max lat/long pair.
   * </pre>
   *
   * <code>.google.type.LatLng max_lat_lng = 2;</code>
   */
  com.google.type.LatLng getMaxLatLng();
  /**
   *
   *
   * <pre>
   * Max lat/long pair.
   * </pre>
   *
   * <code>.google.type.LatLng max_lat_lng = 2;</code>
   */
  com.google.type.LatLngOrBuilder getMaxLatLngOrBuilder();
}
