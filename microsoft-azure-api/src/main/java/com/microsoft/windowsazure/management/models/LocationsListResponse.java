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

package com.microsoft.windowsazure.management.models;

import com.microsoft.windowsazure.OperationResponse;
import com.microsoft.windowsazure.management.models.LocationsListResponse.Location;
import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Iterator;

/**
* The List Locations operation response.
*/
public class LocationsListResponse extends OperationResponse implements Iterable<LocationsListResponse.Location>
{
    private ArrayList<LocationsListResponse.Location> _locations;
    
    /**
    * The data center locations that are valid for your subscription.
    */
    public ArrayList<LocationsListResponse.Location> getLocations() { return this._locations; }
    
    /**
    * The data center locations that are valid for your subscription.
    */
    public void setLocations(ArrayList<LocationsListResponse.Location> locations) { this._locations = locations; }
    
    /**
    * Initializes a new instance of the LocationsListResponse class.
    *
    */
    public LocationsListResponse()
    {
        this._locations = new ArrayList<LocationsListResponse.Location>();
    }
    
    /**
    * Gets the sequence of Locations.
    *
    */
    public Iterator<LocationsListResponse.Location> iterator()
    {
        return this.getLocations().iterator();
    }
    
    /**
    * A data center location that is valid for your subscription.
    */
    public static class Location
    {
        private ArrayList<String> _availableServices;
        
        /**
        * Indicates the services available at a location.
        */
        public ArrayList<String> getAvailableServices() { return this._availableServices; }
        
        /**
        * Indicates the services available at a location.
        */
        public void setAvailableServices(ArrayList<String> availableServices) { this._availableServices = availableServices; }
        
        private String _displayName;
        
        /**
        * The localized name of data center location.
        */
        public String getDisplayName() { return this._displayName; }
        
        /**
        * The localized name of data center location.
        */
        public void setDisplayName(String displayName) { this._displayName = displayName; }
        
        private String _name;
        
        /**
        * The name of a data center location that is valid for your
        * subscription.
        */
        public String getName() { return this._name; }
        
        /**
        * The name of a data center location that is valid for your
        * subscription.
        */
        public void setName(String name) { this._name = name; }
        
        /**
        * Initializes a new instance of the Location class.
        *
        */
        public Location()
        {
            this._availableServices = new ArrayList<String>();
        }
    }
}
