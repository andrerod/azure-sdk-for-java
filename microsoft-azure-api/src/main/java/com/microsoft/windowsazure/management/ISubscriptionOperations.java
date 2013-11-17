// 
// Copyright (c) Microsoft.  All rights reserved.
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//   http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// 
// See the License for the specific language governing permissions and
// limitations under the License.
// 

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management;

import com.microsoft.windowsazure.OperationResponse;
import com.microsoft.windowsazure.common.CloudException;
import com.microsoft.windowsazure.management.models.SubscriptionGetResponse;
import com.microsoft.windowsazure.management.models.SubscriptionListOperationsParameters;
import com.microsoft.windowsazure.management.models.SubscriptionListOperationsResponse;
import java.io.IOException;
import java.lang.InterruptedException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.concurrent.ExecutionException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
* Operation for listing subscription operations and details.  (see
* http://msdn.microsoft.com/en-us/library/windowsazure/gg715315.aspx for more
* information)
*/
public interface ISubscriptionOperations
{
    /**
    * The Get Subscription operation returns account and resource allocation
    * information on the specified subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh403995.aspx for
    * more information)
    *
    * @return The Get Subscription operation response.
    */
    SubscriptionGetResponse get() throws InterruptedException, ExecutionException, CloudException, ParserConfigurationException, SAXException, IOException, URISyntaxException, ParseException;
    
    /**
    * The Get Subscription operation returns account and resource allocation
    * information on the specified subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh403995.aspx for
    * more information)
    *
    * @return The Get Subscription operation response.
    */
    SubscriptionGetResponse getAsync() throws InterruptedException, ExecutionException, CloudException, ParserConfigurationException, SAXException, IOException, URISyntaxException;
    
    /**
    * The List Subscription Operations operation returns a list of create,
    * update, and delete operations that were performed on a subscription
    * during the specified timeframe.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg715318.aspx for
    * more information)
    *
    * @param parameters Parameters supplied to the List Subscription Operations
    * operation.
    * @return The List Subscription Operations operation response.
    */
    SubscriptionListOperationsResponse listOperations(SubscriptionListOperationsParameters parameters) throws InterruptedException, ExecutionException, CloudException, ParserConfigurationException, SAXException, IOException, ParseException;
    
    /**
    * The List Subscription Operations operation returns a list of create,
    * update, and delete operations that were performed on a subscription
    * during the specified timeframe.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg715318.aspx for
    * more information)
    *
    * @param parameters Parameters supplied to the List Subscription Operations
    * operation.
    * @return The List Subscription Operations operation response.
    */
    SubscriptionListOperationsResponse listOperationsAsync(SubscriptionListOperationsParameters parameters) throws InterruptedException, ExecutionException, CloudException, ParserConfigurationException, SAXException, IOException, ParseException;
    
    /**
    * Register a resource with your subscription.
    *
    * @param resourceName Name of the resource to register.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    OperationResponse registerResource(String resourceName) throws InterruptedException, ExecutionException, CloudException, IOException;
    
    /**
    * Register a resource with your subscription.
    *
    * @param resourceName Name of the resource to register.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    OperationResponse registerResourceAsync(String resourceName) throws InterruptedException, ExecutionException, CloudException, IOException;
    
    /**
    * Unregister a resource with your subscription.
    *
    * @param resourceName Name of the resource to unregister.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    OperationResponse unregisterResource(String resourceName) throws InterruptedException, ExecutionException, CloudException, IOException;
    
    /**
    * Unregister a resource with your subscription.
    *
    * @param resourceName Name of the resource to unregister.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    OperationResponse unregisterResourceAsync(String resourceName) throws InterruptedException, ExecutionException, CloudException, IOException;
}
