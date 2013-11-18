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

import com.microsoft.windowsazure.SubscriptionCloudCredentials;
import com.microsoft.windowsazure.common.CloudException;
import com.microsoft.windowsazure.common.ServiceClient;
import com.microsoft.windowsazure.management.AffinityGroupOperations;
import com.microsoft.windowsazure.management.LocationOperations;
import com.microsoft.windowsazure.management.ManagementCertificateOperations;
import com.microsoft.windowsazure.management.ManagementClient;
import com.microsoft.windowsazure.management.SubscriptionOperations;
import com.microsoft.windowsazure.management.models.OperationStatus;
import com.microsoft.windowsazure.management.models.OperationStatusResponse;
import com.microsoft.windowsazure.management.models.OperationStatusResponse.ErrorDetails;
import java.lang.NullPointerException;
import java.net.URI;
import java.util.concurrent.Future;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
* The Service Management API provides programmatic access to much of the
* functionality available through the Management Portal. The Service
* Management API is a REST API. All API operations are performed over SSL and
* mutually authenticated using X.509 v3 certificates.  (see
* http://msdn.microsoft.com/en-us/library/windowsazure/ee460799.aspx for more
* information)
*/
public class ManagementClient extends ServiceClient<ManagementClient>
{
    private URI _baseUri;
    
    /**
    * The URI used as the base for all Service Management requests.
    */
    public URI getBaseUri() { return this._baseUri; }
    
    private SubscriptionCloudCredentials _credentials;
    
    /**
    * When you create a Windows Azure subscription, it is uniquely identified
    * by a subscription ID. The subscription ID forms part of the URI for
    * every call that you make to the Service Management API.  The Windows
    * Azure Service ManagementAPI use mutual authentication of management
    * certificates over SSL to ensure that a request made to the service is
    * secure.  No anonymous requests are allowed.
    */
    public SubscriptionCloudCredentials getCredentials() { return this._credentials; }
    
    private AffinityGroupOperations _affinityGroups;
    
    /**
    * Operations for managing affinity groups beneath your subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460798.aspx for
    * more information)
    */
    public AffinityGroupOperations getAffinityGroups() { return this._affinityGroups; }
    
    private LocationOperations _locations;
    
    /**
    * The Service Management API includes operations for listing the available
    * data center locations for a hosted service in your subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg441299.aspx for
    * more information)
    */
    public LocationOperations getLocations() { return this._locations; }
    
    private ManagementCertificateOperations _managementCertificates;
    
    /**
    * You can use management certificates, which are also known as subscription
    * certificates, to authenticate clients attempting to connect to resources
    * associated with your Windows Azure subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/jj154124.aspx for
    * more information)
    */
    public ManagementCertificateOperations getManagementCertificates() { return this._managementCertificates; }
    
    private SubscriptionOperations _subscriptions;
    
    /**
    * Operation for listing subscription operations and details.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg715315.aspx for
    * more information)
    */
    public SubscriptionOperations getSubscriptions() { return this._subscriptions; }
    
    /**
    * Initializes a new instance of the ManagementClient class.
    *
    */
    private ManagementClient()
        : base()
    {
        this._affinityGroups = new AffinityGroupOperations(this);
        this._locations = new LocationOperations(this);
        this._managementCertificates = new ManagementCertificateOperations(this);
        this._subscriptions = new SubscriptionOperations(this);
    }
    
    /**
    * Initializes a new instance of the ManagementClient class.
    *
    * @param credentials When you create a Windows Azure subscription, it is
    * uniquely identified by a subscription ID. The subscription ID forms part
    * of the URI for every call that you make to the Service Management API.
    * The Windows Azure Service ManagementAPI use mutual authentication of
    * management certificates over SSL to ensure that a request made to the
    * service is secure.  No anonymous requests are allowed.
    * @param baseUri The URI used as the base for all Service Management
    * requests.
    */
    public ManagementClient(SubscriptionCloudCredentials credentials, URI baseUri)
        : this()
    {
        if (credentials == null)
        {
            throw new NullPointerException("credentials");
        }
        if (baseUri == null)
        {
            throw new NullPointerException("baseUri");
        }
        this._credentials = credentials;
        this._baseUri = baseUri;
        
    }
    
    /**
    * Initializes a new instance of the ManagementClient class.
    *
    * @param credentials When you create a Windows Azure subscription, it is
    * uniquely identified by a subscription ID. The subscription ID forms part
    * of the URI for every call that you make to the Service Management API.
    * The Windows Azure Service ManagementAPI use mutual authentication of
    * management certificates over SSL to ensure that a request made to the
    * service is secure.  No anonymous requests are allowed.
    */
    public ManagementClient(SubscriptionCloudCredentials credentials)
        : this()
    {
        if (credentials == null)
        {
            throw new NullPointerException("credentials");
        }
        this._credentials = credentials;
        this._baseUri = new URI("https://management.core.windows.net");
        
    }
    
    /**
    * The Get Operation Status operation returns the status of thespecified
    * operation. After calling an asynchronous operation, you can call Get
    * Operation Status to determine whether the operation has succeeded,
    * failed, or is still in progress.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460783.aspx for
    * more information)
    *
    * @param requestId The request ID for the request you wish to track. The
    * request ID is returned in the x-ms-request-id response header for every
    * request.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request.  If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request, and also includes error information regarding the
    * failure.
    */
    public OperationStatusResponse GetOperationStatus(String requestId)
    {
        return this.GetOperationStatusAsync(requestId).getResult();
    }
    
    /**
    * The Get Operation Status operation returns the status of thespecified
    * operation. After calling an asynchronous operation, you can call Get
    * Operation Status to determine whether the operation has succeeded,
    * failed, or is still in progress.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460783.aspx for
    * more information)
    *
    * @param requestId The request ID for the request you wish to track. The
    * request ID is returned in the x-ms-request-id response header for every
    * request.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request.  If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request, and also includes error information regarding the
    * failure.
    */
    public Future<OperationStatusResponse> GetOperationStatusAsync(String requestId)
    {
        // Validate
        if (requestId == null)
        {
            throw new NullPointerException("requestId");
        }
        
        // Tracing
        
        // Construct URL
        String url = this.getBaseUri() + "/" + this.getCredentials().getSubscriptionId() + "/operations/" + requestId;
        
        // Create HTTP transport objects
        CloseableHttpAsyncClient httpClient = HttpAsyncClients.createDefault();
        try
        {
            httpClient.start();
            HttpGet httpRequest = new HttpGet(url);
            
            // Set Headers
            httpRequest.setRequestProperty("x-ms-version", "2013-03-01");
            
            // Set Credentials
            
            // Send Request
            HttpResponse httpResponse = null;
            Future<HttpResponse> httpRequestFuture = httpClient.execute(httpRequest);
            httpResponse = httpRequestFuture.get();
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != 200)
            {
                CloudException ex = CloudException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity().getContent());
                throw ex;
            }
            
            // Create Result
            OperationStatusResponse result = new OperationStatusResponse();
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").getlength() > 0)
            {
                result.setRequestId(httpResponse.getHeaders("x-ms-request-id")[0]);
            }
            
            // Deserialize Response
            String responseContent = httpResponse.getEntity().getContent();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(responseContent);
            
            NodeList elements = responseDoc.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Operation");
            Element operationElement = elements.getLength() > 0 ? (Element)elements.item(0) : null;
            if (operationElement != null)
            {
                NodeList elements2 = operationElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "ID");
                Element idElement = elements2.getLength() > 0 ? (Element)elements2.item(0) : null;
                if (idElement != null)
                {
                    String idInstance;
                    idInstance = idElement.getNodeValue();
                    result.setId(idInstance);
                }
                
                NodeList elements3 = operationElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Status");
                Element statusElement = elements3.getLength() > 0 ? (Element)elements3.item(0) : null;
                if (statusElement != null)
                {
                    OperationStatus statusInstance;
                    statusInstance = OperationStatus.valueOf(statusElement.getNodeValue());
                    result.setStatus(statusInstance);
                }
                
                NodeList elements4 = operationElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "HttpStatusCode");
                Element httpStatusCodeElement = elements4.getLength() > 0 ? (Element)elements4.item(0) : null;
                if (httpStatusCodeElement != null)
                {
                    HttpStatus httpStatusCodeInstance;
                    httpStatusCodeInstance = HttpStatus.valueOf(httpStatusCodeElement.getNodeValue());
                    result.setHttpStatusCode(httpStatusCodeInstance);
                }
                
                NodeList elements5 = operationElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Error");
                Element errorElement = elements5.getLength() > 0 ? (Element)elements5.item(0) : null;
                if (errorElement != null)
                {
                    OperationStatusResponse.ErrorDetails errorInstance = new OperationStatusResponse.ErrorDetails();
                    result.setError(errorInstance);
                    
                    NodeList elements6 = errorElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Code");
                    Element codeElement = elements6.getLength() > 0 ? (Element)elements6.item(0) : null;
                    if (codeElement != null)
                    {
                        String codeInstance;
                        codeInstance = codeElement.getNodeValue();
                        errorInstance.setCode(codeInstance);
                    }
                    
                    NodeList elements7 = errorElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Message");
                    Element messageElement = elements7.getLength() > 0 ? (Element)elements7.item(0) : null;
                    if (messageElement != null)
                    {
                        String messageInstance;
                        messageInstance = messageElement.getNodeValue();
                        errorInstance.setMessage(messageInstance);
                    }
                }
            }
            
            return result;
        }
        finally
        {
            if (httpClient != null)
            {
                httpClient.close();
            }
        }
    }
}
