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
import com.microsoft.windowsazure.management.models.AffinityGroupCreateParameters;
import com.microsoft.windowsazure.management.models.AffinityGroupGetResponse;
import com.microsoft.windowsazure.management.models.AffinityGroupListResponse;
import com.microsoft.windowsazure.management.models.AffinityGroupUpdateParameters;

/**
* Operations for managing affinity groups beneath your subscription.  (see
* http://msdn.microsoft.com/en-us/library/windowsazure/ee460798.aspx for more
* information)
*/
public interface IAffinityGroupOperations
{
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
    OperationResponse CreateAsync(AffinityGroupCreateParameters parameters);
    
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
    OperationResponse DeleteAsync(String affinityGroupName);
    
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
    AffinityGroupGetResponse GetAsync(String affinityGroupName);
    
    /**
    * The List Affinity Groups operation lists the affinity groups associated
    * with the specified subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460797.aspx for
    * more information)
    *
    * @return The List Affinity Groups operation response.
    */
    AffinityGroupListResponse ListAsync();
    
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
    OperationResponse UpdateAsync(String affinityGroupName, AffinityGroupUpdateParameters parameters);
}
