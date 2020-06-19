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
package com.google.cloud.vision.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.vision.v1.stub.ImageAnnotatorStub;
import com.google.cloud.vision.v1.stub.ImageAnnotatorStubSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service that performs Google Cloud Vision API detection tasks over client
 * images, such as face, landmark, logo, label, and text detection. The ImageAnnotator service
 * returns detected entities from the images.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
 *   List&lt;AnnotateFileRequest&gt; requests = new ArrayList&lt;&gt;();
 *   BatchAnnotateFilesResponse response = imageAnnotatorClient.batchAnnotateFiles(requests);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the imageAnnotatorClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of ImageAnnotatorSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ImageAnnotatorSettings imageAnnotatorSettings =
 *     ImageAnnotatorSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ImageAnnotatorClient imageAnnotatorClient =
 *     ImageAnnotatorClient.create(imageAnnotatorSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ImageAnnotatorSettings imageAnnotatorSettings =
 *     ImageAnnotatorSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ImageAnnotatorClient imageAnnotatorClient =
 *     ImageAnnotatorClient.create(imageAnnotatorSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
public class ImageAnnotatorClient implements BackgroundResource {
  private final ImageAnnotatorSettings settings;
  private final ImageAnnotatorStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of ImageAnnotatorClient with default settings. */
  public static final ImageAnnotatorClient create() throws IOException {
    return create(ImageAnnotatorSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ImageAnnotatorClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ImageAnnotatorClient create(ImageAnnotatorSettings settings)
      throws IOException {
    return new ImageAnnotatorClient(settings);
  }

  /**
   * Constructs an instance of ImageAnnotatorClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use ImageAnnotatorSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ImageAnnotatorClient create(ImageAnnotatorStub stub) {
    return new ImageAnnotatorClient(stub);
  }

  /**
   * Constructs an instance of ImageAnnotatorClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ImageAnnotatorClient(ImageAnnotatorSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ImageAnnotatorStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ImageAnnotatorClient(ImageAnnotatorStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ImageAnnotatorSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ImageAnnotatorStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Service that performs image detection and annotation for a batch of files. Now only
   * "application/pdf", "image/tiff" and "image/gif" are supported.
   *
   * <p>This service will extract at most 5 (customers can specify which 5 in
   * AnnotateFileRequest.pages) frames (gif) or pages (pdf or tiff) from each file provided and
   * perform detection and annotation for each image extracted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
   *   List&lt;AnnotateFileRequest&gt; requests = new ArrayList&lt;&gt;();
   *   BatchAnnotateFilesResponse response = imageAnnotatorClient.batchAnnotateFiles(requests);
   * }
   * </code></pre>
   *
   * @param requests Required. The list of file annotation requests. Right now we support only one
   *     AnnotateFileRequest in BatchAnnotateFilesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchAnnotateFilesResponse batchAnnotateFiles(List<AnnotateFileRequest> requests) {
    BatchAnnotateFilesRequest request =
        BatchAnnotateFilesRequest.newBuilder().addAllRequests(requests).build();
    return batchAnnotateFiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Service that performs image detection and annotation for a batch of files. Now only
   * "application/pdf", "image/tiff" and "image/gif" are supported.
   *
   * <p>This service will extract at most 5 (customers can specify which 5 in
   * AnnotateFileRequest.pages) frames (gif) or pages (pdf or tiff) from each file provided and
   * perform detection and annotation for each image extracted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
   *   List&lt;AnnotateFileRequest&gt; requests = new ArrayList&lt;&gt;();
   *   BatchAnnotateFilesRequest request = BatchAnnotateFilesRequest.newBuilder()
   *     .addAllRequests(requests)
   *     .build();
   *   BatchAnnotateFilesResponse response = imageAnnotatorClient.batchAnnotateFiles(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchAnnotateFilesResponse batchAnnotateFiles(BatchAnnotateFilesRequest request) {
    return batchAnnotateFilesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Service that performs image detection and annotation for a batch of files. Now only
   * "application/pdf", "image/tiff" and "image/gif" are supported.
   *
   * <p>This service will extract at most 5 (customers can specify which 5 in
   * AnnotateFileRequest.pages) frames (gif) or pages (pdf or tiff) from each file provided and
   * perform detection and annotation for each image extracted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
   *   List&lt;AnnotateFileRequest&gt; requests = new ArrayList&lt;&gt;();
   *   BatchAnnotateFilesRequest request = BatchAnnotateFilesRequest.newBuilder()
   *     .addAllRequests(requests)
   *     .build();
   *   ApiFuture&lt;BatchAnnotateFilesResponse&gt; future = imageAnnotatorClient.batchAnnotateFilesCallable().futureCall(request);
   *   // Do something
   *   BatchAnnotateFilesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>
      batchAnnotateFilesCallable() {
    return stub.batchAnnotateFilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Run asynchronous image detection and annotation for a list of images.
   *
   * <p>Progress and results can be retrieved through the `google.longrunning.Operations` interface.
   * `Operation.metadata` contains `OperationMetadata` (metadata). `Operation.response` contains
   * `AsyncBatchAnnotateImagesResponse` (results).
   *
   * <p>This service will write image annotation outputs to json files in customer GCS bucket, each
   * json file containing BatchAnnotateImagesResponse proto.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
   *   List&lt;AnnotateImageRequest&gt; requests = new ArrayList&lt;&gt;();
   *   OutputConfig outputConfig = OutputConfig.newBuilder().build();
   *   AsyncBatchAnnotateImagesResponse response = imageAnnotatorClient.asyncBatchAnnotateImagesAsync(requests, outputConfig).get();
   * }
   * </code></pre>
   *
   * @param requests Required. Individual image annotation requests for this batch.
   * @param outputConfig Required. The desired output location and metadata (e.g. format).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<AsyncBatchAnnotateImagesResponse, OperationMetadata>
      asyncBatchAnnotateImagesAsync(
          List<AnnotateImageRequest> requests, OutputConfig outputConfig) {
    AsyncBatchAnnotateImagesRequest request =
        AsyncBatchAnnotateImagesRequest.newBuilder()
            .addAllRequests(requests)
            .setOutputConfig(outputConfig)
            .build();
    return asyncBatchAnnotateImagesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Run asynchronous image detection and annotation for a list of images.
   *
   * <p>Progress and results can be retrieved through the `google.longrunning.Operations` interface.
   * `Operation.metadata` contains `OperationMetadata` (metadata). `Operation.response` contains
   * `AsyncBatchAnnotateImagesResponse` (results).
   *
   * <p>This service will write image annotation outputs to json files in customer GCS bucket, each
   * json file containing BatchAnnotateImagesResponse proto.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
   *   List&lt;AnnotateImageRequest&gt; requests = new ArrayList&lt;&gt;();
   *   OutputConfig outputConfig = OutputConfig.newBuilder().build();
   *   AsyncBatchAnnotateImagesRequest request = AsyncBatchAnnotateImagesRequest.newBuilder()
   *     .addAllRequests(requests)
   *     .setOutputConfig(outputConfig)
   *     .build();
   *   AsyncBatchAnnotateImagesResponse response = imageAnnotatorClient.asyncBatchAnnotateImagesAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<AsyncBatchAnnotateImagesResponse, OperationMetadata>
      asyncBatchAnnotateImagesAsync(AsyncBatchAnnotateImagesRequest request) {
    return asyncBatchAnnotateImagesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Run asynchronous image detection and annotation for a list of images.
   *
   * <p>Progress and results can be retrieved through the `google.longrunning.Operations` interface.
   * `Operation.metadata` contains `OperationMetadata` (metadata). `Operation.response` contains
   * `AsyncBatchAnnotateImagesResponse` (results).
   *
   * <p>This service will write image annotation outputs to json files in customer GCS bucket, each
   * json file containing BatchAnnotateImagesResponse proto.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
   *   List&lt;AnnotateImageRequest&gt; requests = new ArrayList&lt;&gt;();
   *   OutputConfig outputConfig = OutputConfig.newBuilder().build();
   *   AsyncBatchAnnotateImagesRequest request = AsyncBatchAnnotateImagesRequest.newBuilder()
   *     .addAllRequests(requests)
   *     .setOutputConfig(outputConfig)
   *     .build();
   *   OperationFuture&lt;AsyncBatchAnnotateImagesResponse, OperationMetadata&gt; future = imageAnnotatorClient.asyncBatchAnnotateImagesOperationCallable().futureCall(request);
   *   // Do something
   *   AsyncBatchAnnotateImagesResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<
          AsyncBatchAnnotateImagesRequest, AsyncBatchAnnotateImagesResponse, OperationMetadata>
      asyncBatchAnnotateImagesOperationCallable() {
    return stub.asyncBatchAnnotateImagesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Run asynchronous image detection and annotation for a list of images.
   *
   * <p>Progress and results can be retrieved through the `google.longrunning.Operations` interface.
   * `Operation.metadata` contains `OperationMetadata` (metadata). `Operation.response` contains
   * `AsyncBatchAnnotateImagesResponse` (results).
   *
   * <p>This service will write image annotation outputs to json files in customer GCS bucket, each
   * json file containing BatchAnnotateImagesResponse proto.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
   *   List&lt;AnnotateImageRequest&gt; requests = new ArrayList&lt;&gt;();
   *   OutputConfig outputConfig = OutputConfig.newBuilder().build();
   *   AsyncBatchAnnotateImagesRequest request = AsyncBatchAnnotateImagesRequest.newBuilder()
   *     .addAllRequests(requests)
   *     .setOutputConfig(outputConfig)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = imageAnnotatorClient.asyncBatchAnnotateImagesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AsyncBatchAnnotateImagesRequest, Operation>
      asyncBatchAnnotateImagesCallable() {
    return stub.asyncBatchAnnotateImagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Run asynchronous image detection and annotation for a list of generic files, such as PDF files,
   * which may contain multiple pages and multiple images per page. Progress and results can be
   * retrieved through the `google.longrunning.Operations` interface. `Operation.metadata` contains
   * `OperationMetadata` (metadata). `Operation.response` contains `AsyncBatchAnnotateFilesResponse`
   * (results).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
   *   List&lt;AsyncAnnotateFileRequest&gt; requests = new ArrayList&lt;&gt;();
   *   AsyncBatchAnnotateFilesResponse response = imageAnnotatorClient.asyncBatchAnnotateFilesAsync(requests).get();
   * }
   * </code></pre>
   *
   * @param requests Required. Individual async file annotation requests for this batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<AsyncBatchAnnotateFilesResponse, OperationMetadata>
      asyncBatchAnnotateFilesAsync(List<AsyncAnnotateFileRequest> requests) {
    AsyncBatchAnnotateFilesRequest request =
        AsyncBatchAnnotateFilesRequest.newBuilder().addAllRequests(requests).build();
    return asyncBatchAnnotateFilesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Run asynchronous image detection and annotation for a list of generic files, such as PDF files,
   * which may contain multiple pages and multiple images per page. Progress and results can be
   * retrieved through the `google.longrunning.Operations` interface. `Operation.metadata` contains
   * `OperationMetadata` (metadata). `Operation.response` contains `AsyncBatchAnnotateFilesResponse`
   * (results).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
   *   List&lt;AsyncAnnotateFileRequest&gt; requests = new ArrayList&lt;&gt;();
   *   AsyncBatchAnnotateFilesRequest request = AsyncBatchAnnotateFilesRequest.newBuilder()
   *     .addAllRequests(requests)
   *     .build();
   *   AsyncBatchAnnotateFilesResponse response = imageAnnotatorClient.asyncBatchAnnotateFilesAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<AsyncBatchAnnotateFilesResponse, OperationMetadata>
      asyncBatchAnnotateFilesAsync(AsyncBatchAnnotateFilesRequest request) {
    return asyncBatchAnnotateFilesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Run asynchronous image detection and annotation for a list of generic files, such as PDF files,
   * which may contain multiple pages and multiple images per page. Progress and results can be
   * retrieved through the `google.longrunning.Operations` interface. `Operation.metadata` contains
   * `OperationMetadata` (metadata). `Operation.response` contains `AsyncBatchAnnotateFilesResponse`
   * (results).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
   *   List&lt;AsyncAnnotateFileRequest&gt; requests = new ArrayList&lt;&gt;();
   *   AsyncBatchAnnotateFilesRequest request = AsyncBatchAnnotateFilesRequest.newBuilder()
   *     .addAllRequests(requests)
   *     .build();
   *   OperationFuture&lt;AsyncBatchAnnotateFilesResponse, OperationMetadata&gt; future = imageAnnotatorClient.asyncBatchAnnotateFilesOperationCallable().futureCall(request);
   *   // Do something
   *   AsyncBatchAnnotateFilesResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<
          AsyncBatchAnnotateFilesRequest, AsyncBatchAnnotateFilesResponse, OperationMetadata>
      asyncBatchAnnotateFilesOperationCallable() {
    return stub.asyncBatchAnnotateFilesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Run asynchronous image detection and annotation for a list of generic files, such as PDF files,
   * which may contain multiple pages and multiple images per page. Progress and results can be
   * retrieved through the `google.longrunning.Operations` interface. `Operation.metadata` contains
   * `OperationMetadata` (metadata). `Operation.response` contains `AsyncBatchAnnotateFilesResponse`
   * (results).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
   *   List&lt;AsyncAnnotateFileRequest&gt; requests = new ArrayList&lt;&gt;();
   *   AsyncBatchAnnotateFilesRequest request = AsyncBatchAnnotateFilesRequest.newBuilder()
   *     .addAllRequests(requests)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = imageAnnotatorClient.asyncBatchAnnotateFilesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AsyncBatchAnnotateFilesRequest, Operation>
      asyncBatchAnnotateFilesCallable() {
    return stub.asyncBatchAnnotateFilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Run image detection and annotation for a batch of images.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
   *   List&lt;AnnotateImageRequest&gt; requests = new ArrayList&lt;&gt;();
   *   BatchAnnotateImagesResponse response = imageAnnotatorClient.batchAnnotateImages(requests);
   * }
   * </code></pre>
   *
   * @param requests Required. Individual image annotation requests for this batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchAnnotateImagesResponse batchAnnotateImages(
      List<AnnotateImageRequest> requests) {
    BatchAnnotateImagesRequest request =
        BatchAnnotateImagesRequest.newBuilder().addAllRequests(requests).build();
    return batchAnnotateImages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Run image detection and annotation for a batch of images.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
   *   List&lt;AnnotateImageRequest&gt; requests = new ArrayList&lt;&gt;();
   *   BatchAnnotateImagesRequest request = BatchAnnotateImagesRequest.newBuilder()
   *     .addAllRequests(requests)
   *     .build();
   *   BatchAnnotateImagesResponse response = imageAnnotatorClient.batchAnnotateImages(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchAnnotateImagesResponse batchAnnotateImages(BatchAnnotateImagesRequest request) {
    return batchAnnotateImagesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Run image detection and annotation for a batch of images.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
   *   List&lt;AnnotateImageRequest&gt; requests = new ArrayList&lt;&gt;();
   *   BatchAnnotateImagesRequest request = BatchAnnotateImagesRequest.newBuilder()
   *     .addAllRequests(requests)
   *     .build();
   *   ApiFuture&lt;BatchAnnotateImagesResponse&gt; future = imageAnnotatorClient.batchAnnotateImagesCallable().futureCall(request);
   *   // Do something
   *   BatchAnnotateImagesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesCallable() {
    return stub.batchAnnotateImagesCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }
}
