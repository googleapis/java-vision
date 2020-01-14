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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.vision.v1p3beta1.AsyncBatchAnnotateFilesRequest;
import com.google.cloud.vision.v1p3beta1.AsyncBatchAnnotateFilesResponse;
import com.google.cloud.vision.v1p3beta1.BatchAnnotateImagesRequest;
import com.google.cloud.vision.v1p3beta1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1p3beta1.OperationMetadata;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Cloud Vision API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcImageAnnotatorStub extends ImageAnnotatorStub {

  private static final MethodDescriptor<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesMethodDescriptor =
          MethodDescriptor.<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p3beta1.ImageAnnotator/BatchAnnotateImages")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchAnnotateImagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchAnnotateImagesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<AsyncBatchAnnotateFilesRequest, Operation>
      asyncBatchAnnotateFilesMethodDescriptor =
          MethodDescriptor.<AsyncBatchAnnotateFilesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vision.v1p3beta1.ImageAnnotator/AsyncBatchAnnotateFiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AsyncBatchAnnotateFilesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;

  private final UnaryCallable<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesCallable;
  private final UnaryCallable<AsyncBatchAnnotateFilesRequest, Operation>
      asyncBatchAnnotateFilesCallable;
  private final OperationCallable<
          AsyncBatchAnnotateFilesRequest, AsyncBatchAnnotateFilesResponse, OperationMetadata>
      asyncBatchAnnotateFilesOperationCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcImageAnnotatorStub create(ImageAnnotatorStubSettings settings)
      throws IOException {
    return new GrpcImageAnnotatorStub(settings, ClientContext.create(settings));
  }

  public static final GrpcImageAnnotatorStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcImageAnnotatorStub(
        ImageAnnotatorStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcImageAnnotatorStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcImageAnnotatorStub(
        ImageAnnotatorStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcImageAnnotatorStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcImageAnnotatorStub(ImageAnnotatorStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcImageAnnotatorCallableFactory());
  }

  /**
   * Constructs an instance of GrpcImageAnnotatorStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcImageAnnotatorStub(
      ImageAnnotatorStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
        batchAnnotateImagesTransportSettings =
            GrpcCallSettings.<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>newBuilder()
                .setMethodDescriptor(batchAnnotateImagesMethodDescriptor)
                .build();
    GrpcCallSettings<AsyncBatchAnnotateFilesRequest, Operation>
        asyncBatchAnnotateFilesTransportSettings =
            GrpcCallSettings.<AsyncBatchAnnotateFilesRequest, Operation>newBuilder()
                .setMethodDescriptor(asyncBatchAnnotateFilesMethodDescriptor)
                .build();

    this.batchAnnotateImagesCallable =
        callableFactory.createUnaryCallable(
            batchAnnotateImagesTransportSettings,
            settings.batchAnnotateImagesSettings(),
            clientContext);
    this.asyncBatchAnnotateFilesCallable =
        callableFactory.createUnaryCallable(
            asyncBatchAnnotateFilesTransportSettings,
            settings.asyncBatchAnnotateFilesSettings(),
            clientContext);
    this.asyncBatchAnnotateFilesOperationCallable =
        callableFactory.createOperationCallable(
            asyncBatchAnnotateFilesTransportSettings,
            settings.asyncBatchAnnotateFilesOperationSettings(),
            clientContext,
            this.operationsStub);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesCallable() {
    return batchAnnotateImagesCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<
          AsyncBatchAnnotateFilesRequest, AsyncBatchAnnotateFilesResponse, OperationMetadata>
      asyncBatchAnnotateFilesOperationCallable() {
    return asyncBatchAnnotateFilesOperationCallable;
  }

  public UnaryCallable<AsyncBatchAnnotateFilesRequest, Operation>
      asyncBatchAnnotateFilesCallable() {
    return asyncBatchAnnotateFilesCallable;
  }

  @Override
  public final void close() {
    shutdown();
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
