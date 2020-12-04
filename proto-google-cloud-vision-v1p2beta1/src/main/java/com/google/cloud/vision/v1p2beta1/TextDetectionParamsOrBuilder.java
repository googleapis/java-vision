/*
 * Copyright 2020 Google LLC
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
// source: google/cloud/vision/v1p2beta1/image_annotator.proto

package com.google.cloud.vision.v1p2beta1;

public interface TextDetectionParamsOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1p2beta1.TextDetectionParams)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * By default, Cloud Vision API only includes confidence score for
   * DOCUMENT_TEXT_DETECTION result. Set the flag to true to include confidence
   * score for TEXT_DETECTION as well.
   * </pre>
   *
   * <code>bool enable_text_detection_confidence_score = 9;</code>
   *
   * @return The enableTextDetectionConfidenceScore.
   */
  boolean getEnableTextDetectionConfidenceScore();
}
