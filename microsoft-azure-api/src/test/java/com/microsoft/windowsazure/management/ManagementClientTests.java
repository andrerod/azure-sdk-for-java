/*
 * Copyright 2013 andrerod.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.microsoft.windowsazure.management;

import org.junit.Test;

public class ManagementClientTests extends ManagementIntegrationTestBase { 
    @Test
    public void getAffinityGroups() throws Exception {
        _managementClient.getAffinityGroups().list();
        
        /*
        // Arrange
        String expectedAffinityGroupName = "testCreateAffinityGroupSuccess";
        String expectedLabel = Base64.encode("testCreateAffinityGroupSuccess".getBytes("UTF-8"));
        String expectedLocation = "West US";
        CreateAffinityGroupOptions createAffinityGroupOptions = new CreateAffinityGroupOptions(
                expectedAffinityGroupName, expectedLabel, expectedLocation);

        // Act
        CreateAffinityGroupResult createAffinityGroupResult = service.createAffinityGroup(createAffinityGroupOptions);

        AffinityGroupInfo affinityGroupInfo = service.getAffinityGroup(expectedAffinityGroupName).getValue();

        // Assert
        assertNotNull(createAffinityGroupResult.getLocation());
        assertNotNull(createAffinityGroupResult.getRegion());
        assertNotNull(createAffinityGroupResult.getServer());
        assertNotNull(createAffinityGroupResult.getDate());
        assertEquals(expectedAffinityGroupName, affinityGroupInfo.getName());
        assertEquals(expectedLabel, affinityGroupInfo.getLabel());
        assertEquals(expectedLocation, affinityGroupInfo.getLocation());
*/
    }

}
