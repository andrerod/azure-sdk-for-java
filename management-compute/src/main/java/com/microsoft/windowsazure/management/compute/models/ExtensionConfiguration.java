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

package com.microsoft.windowsazure.management.compute.models;

import com.microsoft.windowsazure.core.LazyArrayList;
import java.util.ArrayList;

/**
* Represents an extension that is added to the cloud service.
*/
public class ExtensionConfiguration {
    private ArrayList<ExtensionConfiguration.Extension> allRoles;
    
    /**
    * Optional. Specifies a list of extensions that are applied to all roles in
    * a deployment.
    * @return The AllRoles value.
    */
    public ArrayList<ExtensionConfiguration.Extension> getAllRoles() {
        return this.allRoles;
    }
    
    /**
    * Optional. Specifies a list of extensions that are applied to all roles in
    * a deployment.
    * @param allRolesValue The AllRoles value.
    */
    public void setAllRoles(final ArrayList<ExtensionConfiguration.Extension> allRolesValue) {
        this.allRoles = allRolesValue;
    }
    
    private ArrayList<ExtensionConfiguration.NamedRole> namedRoles;
    
    /**
    * Optional. Specifies a list of extensions that are applied to specific
    * roles in a deployment.
    * @return The NamedRoles value.
    */
    public ArrayList<ExtensionConfiguration.NamedRole> getNamedRoles() {
        return this.namedRoles;
    }
    
    /**
    * Optional. Specifies a list of extensions that are applied to specific
    * roles in a deployment.
    * @param namedRolesValue The NamedRoles value.
    */
    public void setNamedRoles(final ArrayList<ExtensionConfiguration.NamedRole> namedRolesValue) {
        this.namedRoles = namedRolesValue;
    }
    
    /**
    * Initializes a new instance of the ExtensionConfiguration class.
    *
    */
    public ExtensionConfiguration() {
        this.setAllRoles(new LazyArrayList<ExtensionConfiguration.Extension>());
        this.setNamedRoles(new LazyArrayList<ExtensionConfiguration.NamedRole>());
    }
    
    /**
    * Represents an extension that is to be deployed to a role in a cloud
    * service.
    */
    public static class Extension {
        private String id;
        
        /**
        * Required. The identifier of the extension. The identifier is created
        * when the extension is added to the cloud service. You can find the
        * ID of an extension that was added to a cloud service by using List
        * Extensions.
        * @return The Id value.
        */
        public String getId() {
            return this.id;
        }
        
        /**
        * Required. The identifier of the extension. The identifier is created
        * when the extension is added to the cloud service. You can find the
        * ID of an extension that was added to a cloud service by using List
        * Extensions.
        * @param idValue The Id value.
        */
        public void setId(final String idValue) {
            this.id = idValue;
        }
        
        /**
        * Initializes a new instance of the Extension class.
        *
        */
        public Extension() {
        }
        
        /**
        * Initializes a new instance of the Extension class with required
        * arguments.
        *
        */
        public Extension(String id) {
            if (id == null) {
                throw new NullPointerException("id");
            }
            this.setId(id);
        }
    }
    
    /**
    * Specifies a list of extensions that are applied to specific roles in a
    * deployment.
    */
    public static class NamedRole {
        private ArrayList<ExtensionConfiguration.Extension> extensions;
        
        /**
        * Required. Represents an extension that is to be deployed to a role in
        * a cloud service.
        * @return The Extensions value.
        */
        public ArrayList<ExtensionConfiguration.Extension> getExtensions() {
            return this.extensions;
        }
        
        /**
        * Required. Represents an extension that is to be deployed to a role in
        * a cloud service.
        * @param extensionsValue The Extensions value.
        */
        public void setExtensions(final ArrayList<ExtensionConfiguration.Extension> extensionsValue) {
            this.extensions = extensionsValue;
        }
        
        private String roleName;
        
        /**
        * Required. Specifies the name of the role.
        * @return The RoleName value.
        */
        public String getRoleName() {
            return this.roleName;
        }
        
        /**
        * Required. Specifies the name of the role.
        * @param roleNameValue The RoleName value.
        */
        public void setRoleName(final String roleNameValue) {
            this.roleName = roleNameValue;
        }
        
        /**
        * Initializes a new instance of the NamedRole class.
        *
        */
        public NamedRole() {
            this.setExtensions(new LazyArrayList<ExtensionConfiguration.Extension>());
        }
        
        /**
        * Initializes a new instance of the NamedRole class with required
        * arguments.
        *
        * @param roleName The role name.
        * @param extensions The extensions.
        */
        public NamedRole(String roleName, ArrayList<ExtensionConfiguration.Extension> extensions) {
            this();
            if (roleName == null) {
                throw new NullPointerException("roleName");
            }
            if (extensions == null) {
                throw new NullPointerException("extensions");
            }
            this.setRoleName(roleName);
            this.setExtensions(extensions);
        }
    }
}
