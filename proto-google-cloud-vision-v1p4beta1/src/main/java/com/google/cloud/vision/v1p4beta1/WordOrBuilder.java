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
// source: google/cloud/vision/v1p4beta1/text_annotation.proto

package com.google.cloud.vision.v1p4beta1;

public interface WordOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1p4beta1.Word)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Additional information detected for the word.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p4beta1.TextAnnotation.TextProperty property = 1;</code>
   */
  boolean hasProperty();
  /**
   *
   *
   * <pre>
   * Additional information detected for the word.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p4beta1.TextAnnotation.TextProperty property = 1;</code>
   */
  com.google.cloud.vision.v1p4beta1.TextAnnotation.TextProperty getProperty();
  /**
   *
   *
   * <pre>
   * Additional information detected for the word.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p4beta1.TextAnnotation.TextProperty property = 1;</code>
   */
  com.google.cloud.vision.v1p4beta1.TextAnnotation.TextPropertyOrBuilder getPropertyOrBuilder();

  /**
   *
   *
   * <pre>
   * The bounding box for the word.
   * The vertices are in the order of top-left, top-right, bottom-right,
   * bottom-left. When a rotation of the bounding box is detected the rotation
   * is represented as around the top-left corner as defined when the text is
   * read in the 'natural' orientation.
   * For example:
   *   * when the text is horizontal it might look like:
   *      0----1
   *      |    |
   *      3----2
   *   * when it's rotated 180 degrees around the top-left corner it becomes:
   *      2----3
   *      |    |
   *      1----0
   *   and the vertex order will still be (0, 1, 2, 3).
   * </pre>
   *
   * <code>.google.cloud.vision.v1p4beta1.BoundingPoly bounding_box = 2;</code>
   */
  boolean hasBoundingBox();
  /**
   *
   *
   * <pre>
   * The bounding box for the word.
   * The vertices are in the order of top-left, top-right, bottom-right,
   * bottom-left. When a rotation of the bounding box is detected the rotation
   * is represented as around the top-left corner as defined when the text is
   * read in the 'natural' orientation.
   * For example:
   *   * when the text is horizontal it might look like:
   *      0----1
   *      |    |
   *      3----2
   *   * when it's rotated 180 degrees around the top-left corner it becomes:
   *      2----3
   *      |    |
   *      1----0
   *   and the vertex order will still be (0, 1, 2, 3).
   * </pre>
   *
   * <code>.google.cloud.vision.v1p4beta1.BoundingPoly bounding_box = 2;</code>
   */
  com.google.cloud.vision.v1p4beta1.BoundingPoly getBoundingBox();
  /**
   *
   *
   * <pre>
   * The bounding box for the word.
   * The vertices are in the order of top-left, top-right, bottom-right,
   * bottom-left. When a rotation of the bounding box is detected the rotation
   * is represented as around the top-left corner as defined when the text is
   * read in the 'natural' orientation.
   * For example:
   *   * when the text is horizontal it might look like:
   *      0----1
   *      |    |
   *      3----2
   *   * when it's rotated 180 degrees around the top-left corner it becomes:
   *      2----3
   *      |    |
   *      1----0
   *   and the vertex order will still be (0, 1, 2, 3).
   * </pre>
   *
   * <code>.google.cloud.vision.v1p4beta1.BoundingPoly bounding_box = 2;</code>
   */
  com.google.cloud.vision.v1p4beta1.BoundingPolyOrBuilder getBoundingBoxOrBuilder();

  /**
   *
   *
   * <pre>
   * List of symbols in the word.
   * The order of the symbols follows the natural reading order.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.Symbol symbols = 3;</code>
   */
  java.util.List<com.google.cloud.vision.v1p4beta1.Symbol> getSymbolsList();
  /**
   *
   *
   * <pre>
   * List of symbols in the word.
   * The order of the symbols follows the natural reading order.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.Symbol symbols = 3;</code>
   */
  com.google.cloud.vision.v1p4beta1.Symbol getSymbols(int index);
  /**
   *
   *
   * <pre>
   * List of symbols in the word.
   * The order of the symbols follows the natural reading order.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.Symbol symbols = 3;</code>
   */
  int getSymbolsCount();
  /**
   *
   *
   * <pre>
   * List of symbols in the word.
   * The order of the symbols follows the natural reading order.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.Symbol symbols = 3;</code>
   */
  java.util.List<? extends com.google.cloud.vision.v1p4beta1.SymbolOrBuilder>
      getSymbolsOrBuilderList();
  /**
   *
   *
   * <pre>
   * List of symbols in the word.
   * The order of the symbols follows the natural reading order.
   * </pre>
   *
   * <code>repeated .google.cloud.vision.v1p4beta1.Symbol symbols = 3;</code>
   */
  com.google.cloud.vision.v1p4beta1.SymbolOrBuilder getSymbolsOrBuilder(int index);

  /**
   *
   *
   * <pre>
   * Confidence of the OCR results for the word. Range [0, 1].
   * </pre>
   *
   * <code>float confidence = 4;</code>
   */
  float getConfidence();
}
