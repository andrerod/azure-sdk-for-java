/**
 * Copyright Microsoft Corporation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microsoft.windowsazure.management;

import com.microsoft.windowsazure.CertificateCloudCredentials;
import com.microsoft.windowsazure.KeyStoreCredential;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;

import com.microsoft.windowsazure.services.core.Builder;
import com.microsoft.windowsazure.services.core.Builder.Alteration;
import com.microsoft.windowsazure.services.core.Builder.Registry;
import com.microsoft.windowsazure.services.core.Configuration;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.filter.LoggingFilter;

public abstract class ManagementIntegrationTestBase {

    protected ManagementClient _managementClient;

    @BeforeClass
    public static void initializeSystem() {
        System.setProperty("http.keepAlive", "false");
    }

    @Before
    public void initialize() throws Exception {
        createService();
    }

    private void createService() throws Exception {
        // reinitialize configuration from known state
        Configuration config = createConfiguration();

        // add LoggingFilter to any pipeline that is created
        Registry builder = (Registry) config.getBuilder();
        builder.alter(ManagementClient.class, Client.class, new Alteration<Client>() {
            @Override
            public Client alter(String profile, Client client, Builder builder, Map<String, Object> properties) {
                client.addFilter(new LoggingFilter());
                return client;
            }
        });

        // applied as default configuration 
        Configuration.setInstance(config);
        _managementClient = ManagementService.create(config);
    }

    protected static Configuration createConfiguration() throws Exception {
        Configuration config = Configuration.load();

        config.setProperty(ManagementConfiguration.SUBSCRIPTION_CLOUD_CREDENTIALS,
                new CertificateCloudCredentials(System.getenv(ManagementConfiguration.SUBSCRIPTION_ID),
                new KeyStoreCredential(
                        System.getenv(ManagementConfiguration.KEYSTORE_PATH),
                        System.getenv(ManagementConfiguration.KEYSTORE_PASSWORD))));
        
        return config;
    }
}
