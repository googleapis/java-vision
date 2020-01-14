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
package com.google.cloud.vision.v1p3beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.vision.v1p3beta1.AsyncBatchAnnotateFilesRequest;
import com.google.cloud.vision.v1p3beta1.AsyncBatchAnnotateFilesResponse;
import com.google.cloud.vision.v1p3beta1.BatchAnnotateImagesRequest;
import com.google.cloud.vision.v1p3beta1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1p3beta1.OperationMetadata;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Cloud Vision API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class ImageAnnotatorStub implements BackgroundResource {

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchAnnotateImagesCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<
          AsyncBatchAnnotateFilesRequest, AsyncBatchAnnotateFilesResponse, OperationMetadata>
      asyncBatchAnnotateFilesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: asyncBatchAnnotateFilesOperationCallable()");
  }

  public UnaryCallable<AsyncBatchAnnotateFilesRequest, Operation>
      asyncBatchAnnotateFilesCallable() {
    throw new UnsupportedOperationException("Not implemented: asyncBatchAnnotateFilesCallable()");
  }

  @Override
  public abstract void close();
}
