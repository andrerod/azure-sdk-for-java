/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.network;

import com.microsoft.windowsazure.core.OperationResponse;
import com.microsoft.windowsazure.core.OperationStatusResponse;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.network.models.NetworkReservedIPCreateParameters;
import com.microsoft.windowsazure.management.network.models.NetworkReservedIPGetResponse;
import com.microsoft.windowsazure.management.network.models.NetworkReservedIPListResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
* The Network Management API includes operations for managing the reserved IPs
* for your subscription.
*/
public interface ReservedIPOperations {
    /**
    * The Begin Creating Reserved IP operation creates a reserved IP from your
    * the subscription.
    *
    * @param parameters Required. Parameters supplied to the Begin Creating
    * Reserved IP operation.
    * @throws ParserConfigurationException Thrown if there was an error
    * configuring the parser for the response body.
    * @throws SAXException Thrown if there was an error parsing the response
    * body.
    * @throws TransformerException Thrown if there was an error creating the
    * DOM transformer.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request. If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request, and also includes error information regarding the
    * failure.
    */
    OperationStatusResponse beginCreating(NetworkReservedIPCreateParameters parameters) throws ParserConfigurationException, SAXException, TransformerException, IOException, ServiceException;
    
    /**
    * The Begin Creating Reserved IP operation creates a reserved IP from your
    * the subscription.
    *
    * @param parameters Required. Parameters supplied to the Begin Creating
    * Reserved IP operation.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request. If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request, and also includes error information regarding the
    * failure.
    */
    Future<OperationStatusResponse> beginCreatingAsync(NetworkReservedIPCreateParameters parameters);
    
    /**
    * The Begin Deleting Reserved IP operation removes a reserved IP from your
    * the subscription.
    *
    * @param ipName Required. The name of the reserved IP.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    OperationResponse beginDeleting(String ipName) throws IOException, ServiceException, ParserConfigurationException, SAXException;
    
    /**
    * The Begin Deleting Reserved IP operation removes a reserved IP from your
    * the subscription.
    *
    * @param ipName Required. The name of the reserved IP.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    Future<OperationResponse> beginDeletingAsync(String ipName);
    
    /**
    * The Create Reserved IP operation creates a reserved IP from your the
    * subscription.
    *
    * @param parameters Required. Parameters supplied to the Create Reserved IP
    * operation.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @throws InterruptedException Thrown when a thread is waiting, sleeping,
    * or otherwise occupied, and the thread is interrupted, either before or
    * during the activity. Occasionally a method may wish to test whether the
    * current thread has been interrupted, and if so, to immediately throw
    * this exception. The following code can be used to achieve this effect:
    * @throws ExecutionException Thrown when attempting to retrieve the result
    * of a task that aborted by throwing an exception. This exception can be
    * inspected using the Throwable.getCause() method.
    * @throws ServiceException Thrown if the server returned an error for the
    * request.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request. If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request, and also includes error information regarding the
    * failure.
    */
    OperationStatusResponse create(NetworkReservedIPCreateParameters parameters) throws IOException, ServiceException, ParserConfigurationException, SAXException, InterruptedException, ExecutionException;
    
    /**
    * The Create Reserved IP operation creates a reserved IP from your the
    * subscription.
    *
    * @param parameters Required. Parameters supplied to the Create Reserved IP
    * operation.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request. If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request, and also includes error information regarding the
    * failure.
    */
    Future<OperationStatusResponse> createAsync(NetworkReservedIPCreateParameters parameters);
    
    /**
    * The Delete Reserved IP operation removes a reserved IP from your the
    * subscription.
    *
    * @param ipName Required. The name of the reserved IP.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @throws InterruptedException Thrown when a thread is waiting, sleeping,
    * or otherwise occupied, and the thread is interrupted, either before or
    * during the activity. Occasionally a method may wish to test whether the
    * current thread has been interrupted, and if so, to immediately throw
    * this exception. The following code can be used to achieve this effect:
    * @throws ExecutionException Thrown when attempting to retrieve the result
    * of a task that aborted by throwing an exception. This exception can be
    * inspected using the Throwable.getCause() method.
    * @throws ServiceException Thrown if the server returned an error for the
    * request.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request. If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request, and also includes error information regarding the
    * failure.
    */
    OperationStatusResponse delete(String ipName) throws IOException, ServiceException, ParserConfigurationException, SAXException, InterruptedException, ExecutionException;
    
    /**
    * The Delete Reserved IP operation removes a reserved IP from your the
    * subscription.
    *
    * @param ipName Required. The name of the reserved IP.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request. If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request, and also includes error information regarding the
    * failure.
    */
    Future<OperationStatusResponse> deleteAsync(String ipName);
    
    /**
    * The Get Reserved IP operation retrieves the details for the virtual IP
    * reserved for the subscription.
    *
    * @param ipName Required. The name of the reserved IP to retrieve.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return A reserved IP associated with your subscription.
    */
    NetworkReservedIPGetResponse get(String ipName) throws IOException, ServiceException, ParserConfigurationException, SAXException;
    
    /**
    * The Get Reserved IP operation retrieves the details for the virtual IP
    * reserved for the subscription.
    *
    * @param ipName Required. The name of the reserved IP to retrieve.
    * @return A reserved IP associated with your subscription.
    */
    Future<NetworkReservedIPGetResponse> getAsync(String ipName);
    
    /**
    * The List Reserved IP operation retrieves all of the virtual IPs reserved
    * for the subscription.
    *
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return The response structure for the Server List operation.
    */
    NetworkReservedIPListResponse list() throws IOException, ServiceException, ParserConfigurationException, SAXException;
    
    /**
    * The List Reserved IP operation retrieves all of the virtual IPs reserved
    * for the subscription.
    *
    * @return The response structure for the Server List operation.
    */
    Future<NetworkReservedIPListResponse> listAsync();
}
