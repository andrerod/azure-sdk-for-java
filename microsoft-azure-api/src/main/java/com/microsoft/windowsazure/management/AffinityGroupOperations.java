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
import com.microsoft.windowsazure.common.IServiceOperations;
import com.microsoft.windowsazure.common.internals.TypeConversion;
import com.microsoft.windowsazure.management.IAffinityGroupOperations;
import com.microsoft.windowsazure.management.ManagementClient;
import com.microsoft.windowsazure.management.models.AffinityGroupCreateParameters;
import com.microsoft.windowsazure.management.models.AffinityGroupGetResponse;
import com.microsoft.windowsazure.management.models.AffinityGroupGetResponse.HostedServiceReference;
import com.microsoft.windowsazure.management.models.AffinityGroupGetResponse.StorageServiceReference;
import com.microsoft.windowsazure.management.models.AffinityGroupListResponse;
import com.microsoft.windowsazure.management.models.AffinityGroupListResponse.AffinityGroup;
import com.microsoft.windowsazure.management.models.AffinityGroupUpdateParameters;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
import java.net.URI;
import java.util.concurrent.Future;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
* Operations for managing affinity groups beneath your subscription.  (see
* http://msdn.microsoft.com/en-us/library/windowsazure/ee460798.aspx for more
* information)
*/
class AffinityGroupOperations extends IServiceOperations<ManagementClient> implements IAffinityGroupOperations
{
    /**
    * Initializes a new instance of the AffinityGroupOperations class.
    *
    * @param client Reference to the service client.
    */
    AffinityGroupOperations(ManagementClient client)
    {
        this._client = client;
    }
    
    private ManagementClient _client;
    
    /**
    * Gets a reference to the
    * microsoft.windowsazure.management.ManagementClient.
    */
    public ManagementClient getClient() { return this._client; }
    
    /**
    * The Create Affinity Group operation creates a new affinity group for the
    * specified subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg715317.aspx for
    * more information)
    *
    * @param parameters Parameters supplied to the Create Affinity Group
    * operation.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    public OperationResponse CreateAsync(AffinityGroupCreateParameters parameters)
    {
        // Validate
        if (parameters == null)
        {
            throw new NullPointerException("parameters");
        }
        if (parameters.getDescription() != null && parameters.getDescription().length() > 1024)
        {
            throw new IllegalArgumentException("parameters.Description");
        }
        if (parameters.getLabel() == null)
        {
            throw new NullPointerException("parameters.Label");
        }
        if (parameters.getLabel().length() > 100)
        {
            throw new IllegalArgumentException("parameters.Label");
        }
        if (parameters.getLocation() == null)
        {
            throw new NullPointerException("parameters.Location");
        }
        if (parameters.getName() == null)
        {
            throw new NullPointerException("parameters.Name");
        }
        
        // Tracing
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/affinitygroups";
        
        // Create HTTP transport objects
        CloseableHttpAsyncClient httpClient = HttpAsyncClients.createDefault();
        try
        {
            httpClient.start();
            HttpPost httpRequest = new HttpPost(url);
            
            // Set Headers
            httpRequest.setRequestProperty("Content-Type", "application/xml");
            httpRequest.setRequestProperty("x-ms-version", "2013-03-01");
            
            // Set Credentials
            
            // Serialize Request
            String requestContent = null;
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document requestDoc = documentBuilder.newDocument();
            
            Element createAffinityGroupElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "CreateAffinityGroup");
            requestDoc.appendChild(createAffinityGroupElement);
            
            Element nameElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "Name");
            nameElement.appendChild(requestDoc.createTextNode(parameters.getName()));
            createAffinityGroupElement.appendChild(nameElement);
            
            Element labelElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "Label");
            labelElement.appendChild(requestDoc.createTextNode(Base64.encodeBase64String(parameters.getLabel())));
            createAffinityGroupElement.appendChild(labelElement);
            
            if (parameters.getDescription() != null)
            {
                Element descriptionElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "Description");
                descriptionElement.appendChild(requestDoc.createTextNode(parameters.getDescription()));
                createAffinityGroupElement.appendChild(descriptionElement);
            }
            
            Element locationElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "Location");
            locationElement.appendChild(requestDoc.createTextNode(parameters.getLocation()));
            createAffinityGroupElement.appendChild(locationElement);
            
            requestContent = null;
            httpRequest.setContent(requestContent);
            httpRequest.getContent().getHeaders().setContentType("application/xml");
            
            // Send Request
            HttpResponse httpResponse = null;
            Future<HttpResponse> httpRequestFuture = httpClient.execute(httpRequest);
            httpResponse = httpRequestFuture.get();
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != 201)
            {
                CloudException ex = CloudException.createFromXml(httpRequest, requestContent, httpResponse, httpResponse.getEntity().getContent());
                throw ex;
            }
            
            // Create Result
            OperationResponse result = new OperationResponse();
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").getlength() > 0)
            {
                result.setRequestId(httpResponse.getHeaders("x-ms-request-id")[0]);
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
    
    /**
    * The Delete Affinity Group operation deletes an affinity group in the
    * specified subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg715314.aspx for
    * more information)
    *
    * @param affinityGroupName The name of your affinity group.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    public OperationResponse DeleteAsync(String affinityGroupName)
    {
        // Validate
        if (affinityGroupName == null)
        {
            throw new NullPointerException("affinityGroupName");
        }
        
        // Tracing
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/affinitygroups/" + affinityGroupName;
        
        // Create HTTP transport objects
        CloseableHttpAsyncClient httpClient = HttpAsyncClients.createDefault();
        try
        {
            httpClient.start();
            HttpDelete httpRequest = new HttpDelete(url);
            
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
            OperationResponse result = new OperationResponse();
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").getlength() > 0)
            {
                result.setRequestId(httpResponse.getHeaders("x-ms-request-id")[0]);
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
    
    /**
    * The Get Affinity Group Properties operation returns the system properties
    * associated with the specified affinity group.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460789.aspx for
    * more information)
    *
    * @param affinityGroupName The name of the desired affinity group as
    * returned by the name element of the List Affinity Groups operation.
    * @return The Get Affinity Group operation response.
    */
    public AffinityGroupGetResponse GetAsync(String affinityGroupName)
    {
        // Validate
        if (affinityGroupName == null)
        {
            throw new NullPointerException("affinityGroupName");
        }
        
        // Tracing
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/affinitygroups/" + affinityGroupName;
        
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
            AffinityGroupGetResponse result = new AffinityGroupGetResponse();
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
            
            NodeList elements = responseDoc.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "AffinityGroup");
            Element affinityGroupElement = elements.getLength() > 0 ? (Element)elements.item(0) : null;
            if (affinityGroupElement != null)
            {
                NodeList elements2 = affinityGroupElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Name");
                Element nameElement = elements2.getLength() > 0 ? (Element)elements2.item(0) : null;
                if (nameElement != null)
                {
                    String nameInstance;
                    nameInstance = nameElement.getNodeValue();
                    result.setName(nameInstance);
                }
                
                NodeList elements3 = affinityGroupElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Label");
                Element labelElement = elements3.getLength() > 0 ? (Element)elements3.item(0) : null;
                if (labelElement != null)
                {
                    String labelInstance;
                    labelInstance = TypeConversion.FromBase64String(labelElement.getNodeValue());
                    result.setLabel(labelInstance);
                }
                
                NodeList elements4 = affinityGroupElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Description");
                Element descriptionElement = elements4.getLength() > 0 ? (Element)elements4.item(0) : null;
                if (descriptionElement != null)
                {
                    String descriptionInstance;
                    descriptionInstance = descriptionElement.getNodeValue();
                    result.setDescription(descriptionInstance);
                }
                
                NodeList elements5 = affinityGroupElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Location");
                Element locationElement = elements5.getLength() > 0 ? (Element)elements5.item(0) : null;
                if (locationElement != null)
                {
                    String locationInstance;
                    locationInstance = locationElement.getNodeValue();
                    result.setLocation(locationInstance);
                }
                
                NodeList elements6 = affinityGroupElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "HostedServices");
                Element hostedServicesSequenceElement = elements6.getLength() > 0 ? (Element)elements6.item(0) : null;
                if (hostedServicesSequenceElement != null)
                {
                    for (Element hostedServicesElement : hostedServicesSequenceElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "HostedService"))
                    {
                        AffinityGroupGetResponse.HostedServiceReference hostedServiceInstance = new AffinityGroupGetResponse.HostedServiceReference();
                        result.getHostedServices().Add(hostedServiceInstance);
                        
                        NodeList elements7 = hostedServicesElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Url");
                        Element urlElement = elements7.getLength() > 0 ? (Element)elements7.item(0) : null;
                        if (urlElement != null)
                        {
                            URI urlInstance;
                            urlInstance = TypeConversion.TryParseUri(urlElement.getNodeValue());
                            hostedServiceInstance.setUri(urlInstance);
                        }
                        
                        NodeList elements8 = hostedServicesElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "ServiceName");
                        Element serviceNameElement = elements8.getLength() > 0 ? (Element)elements8.item(0) : null;
                        if (serviceNameElement != null)
                        {
                            String serviceNameInstance;
                            serviceNameInstance = serviceNameElement.getNodeValue();
                            hostedServiceInstance.setServiceName(serviceNameInstance);
                        }
                    }
                }
                
                NodeList elements9 = affinityGroupElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "StorageServices");
                Element storageServicesSequenceElement = elements9.getLength() > 0 ? (Element)elements9.item(0) : null;
                if (storageServicesSequenceElement != null)
                {
                    for (Element storageServicesElement : storageServicesSequenceElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "StorageService"))
                    {
                        AffinityGroupGetResponse.StorageServiceReference storageServiceInstance = new AffinityGroupGetResponse.StorageServiceReference();
                        result.getStorageServices().Add(storageServiceInstance);
                        
                        NodeList elements10 = storageServicesElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Url");
                        Element urlElement2 = elements10.getLength() > 0 ? (Element)elements10.item(0) : null;
                        if (urlElement2 != null)
                        {
                            URI urlInstance2;
                            urlInstance2 = TypeConversion.TryParseUri(urlElement2.getNodeValue());
                            storageServiceInstance.setUri(urlInstance2);
                        }
                        
                        NodeList elements11 = storageServicesElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "ServiceName");
                        Element serviceNameElement2 = elements11.getLength() > 0 ? (Element)elements11.item(0) : null;
                        if (serviceNameElement2 != null)
                        {
                            String serviceNameInstance2;
                            serviceNameInstance2 = serviceNameElement2.getNodeValue();
                            storageServiceInstance.setServiceName(serviceNameInstance2);
                        }
                    }
                }
                
                NodeList elements12 = affinityGroupElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Capabilities");
                Element capabilitiesSequenceElement = elements12.getLength() > 0 ? (Element)elements12.item(0) : null;
                if (capabilitiesSequenceElement != null)
                {
                    for (Element capabilitiesElement : capabilitiesSequenceElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Capability"))
                    {
                        result.getCapabilities().Add(capabilitiesElement.getNodeValue());
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
    
    /**
    * The List Affinity Groups operation lists the affinity groups associated
    * with the specified subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460797.aspx for
    * more information)
    *
    * @return The List Affinity Groups operation response.
    */
    public AffinityGroupListResponse ListAsync()
    {
        // Validate
        
        // Tracing
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/affinitygroups";
        
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
            AffinityGroupListResponse result = new AffinityGroupListResponse();
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
            
            NodeList elements = responseDoc.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "AffinityGroups");
            Element affinityGroupsSequenceElement = elements.getLength() > 0 ? (Element)elements.item(0) : null;
            if (affinityGroupsSequenceElement != null)
            {
                for (Element affinityGroupsElement : affinityGroupsSequenceElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "AffinityGroup"))
                {
                    AffinityGroupListResponse.AffinityGroup affinityGroupInstance = new AffinityGroupListResponse.AffinityGroup();
                    result.getAffinityGroups().Add(affinityGroupInstance);
                    
                    NodeList elements2 = affinityGroupsElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Name");
                    Element nameElement = elements2.getLength() > 0 ? (Element)elements2.item(0) : null;
                    if (nameElement != null)
                    {
                        String nameInstance;
                        nameInstance = nameElement.getNodeValue();
                        affinityGroupInstance.setName(nameInstance);
                    }
                    
                    NodeList elements3 = affinityGroupsElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Label");
                    Element labelElement = elements3.getLength() > 0 ? (Element)elements3.item(0) : null;
                    if (labelElement != null)
                    {
                        String labelInstance;
                        labelInstance = TypeConversion.FromBase64String(labelElement.getNodeValue());
                        affinityGroupInstance.setLabel(labelInstance);
                    }
                    
                    NodeList elements4 = affinityGroupsElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Description");
                    Element descriptionElement = elements4.getLength() > 0 ? (Element)elements4.item(0) : null;
                    if (descriptionElement != null)
                    {
                        String descriptionInstance;
                        descriptionInstance = descriptionElement.getNodeValue();
                        affinityGroupInstance.setDescription(descriptionInstance);
                    }
                    
                    NodeList elements5 = affinityGroupsElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Location");
                    Element locationElement = elements5.getLength() > 0 ? (Element)elements5.item(0) : null;
                    if (locationElement != null)
                    {
                        String locationInstance;
                        locationInstance = locationElement.getNodeValue();
                        affinityGroupInstance.setLocation(locationInstance);
                    }
                    
                    NodeList elements6 = affinityGroupsElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Capabilities");
                    Element capabilitiesSequenceElement = elements6.getLength() > 0 ? (Element)elements6.item(0) : null;
                    if (capabilitiesSequenceElement != null)
                    {
                        for (Element capabilitiesElement : capabilitiesSequenceElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Capability"))
                        {
                            affinityGroupInstance.getCapabilities().Add(capabilitiesElement.getNodeValue());
                        }
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
    
    /**
    * The Update Affinity Group operation updates the label and/or the
    * description for an affinity group for the specified subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg715316.aspx for
    * more information)
    *
    * @param affinityGroupName The name of your affinity group.
    * @param parameters Parameters supplied to the Update Affinity Group
    * operation.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    public OperationResponse UpdateAsync(String affinityGroupName, AffinityGroupUpdateParameters parameters)
    {
        // Validate
        if (affinityGroupName == null)
        {
            throw new NullPointerException("affinityGroupName");
        }
        if (parameters == null)
        {
            throw new NullPointerException("parameters");
        }
        if (parameters.getDescription() != null && parameters.getDescription().length() > 1024)
        {
            throw new IllegalArgumentException("parameters.Description");
        }
        if (parameters.getLabel() == null)
        {
            throw new NullPointerException("parameters.Label");
        }
        if (parameters.getLabel().length() > 100)
        {
            throw new IllegalArgumentException("parameters.Label");
        }
        
        // Tracing
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/affinitygroups/" + affinityGroupName;
        
        // Create HTTP transport objects
        CloseableHttpAsyncClient httpClient = HttpAsyncClients.createDefault();
        try
        {
            httpClient.start();
            HttpPut httpRequest = new HttpPut(url);
            
            // Set Headers
            httpRequest.setRequestProperty("Content-Type", "application/xml");
            httpRequest.setRequestProperty("x-ms-version", "2013-03-01");
            
            // Set Credentials
            
            // Serialize Request
            String requestContent = null;
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document requestDoc = documentBuilder.newDocument();
            
            Element updateAffinityGroupElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "UpdateAffinityGroup");
            requestDoc.appendChild(updateAffinityGroupElement);
            
            Element labelElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "Label");
            labelElement.appendChild(requestDoc.createTextNode(Base64.encodeBase64String(parameters.getLabel())));
            updateAffinityGroupElement.appendChild(labelElement);
            
            if (parameters.getDescription() != null)
            {
                Element descriptionElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "Description");
                descriptionElement.appendChild(requestDoc.createTextNode(parameters.getDescription()));
                updateAffinityGroupElement.appendChild(descriptionElement);
            }
            
            requestContent = null;
            httpRequest.setContent(requestContent);
            httpRequest.getContent().getHeaders().setContentType("application/xml");
            
            // Send Request
            HttpResponse httpResponse = null;
            Future<HttpResponse> httpRequestFuture = httpClient.execute(httpRequest);
            httpResponse = httpRequestFuture.get();
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != 200)
            {
                CloudException ex = CloudException.createFromXml(httpRequest, requestContent, httpResponse, httpResponse.getEntity().getContent());
                throw ex;
            }
            
            // Create Result
            OperationResponse result = new OperationResponse();
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").getlength() > 0)
            {
                result.setRequestId(httpResponse.getHeaders("x-ms-request-id")[0]);
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
