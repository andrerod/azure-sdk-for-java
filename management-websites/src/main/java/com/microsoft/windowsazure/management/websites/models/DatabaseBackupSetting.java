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

package com.microsoft.windowsazure.management.websites.models;

/**
* A specific backup.
*/
public class DatabaseBackupSetting {
    private String connectionString;
    
    /**
    * Optional. Contains a connection string to a database which is being
    * backed up/restored. If the restore should happen to a new database, the
    * database name inside is the new one.
    * @return The ConnectionString value.
    */
    public String getConnectionString() {
        return this.connectionString;
    }
    
    /**
    * Optional. Contains a connection string to a database which is being
    * backed up/restored. If the restore should happen to a new database, the
    * database name inside is the new one.
    * @param connectionStringValue The ConnectionString value.
    */
    public void setConnectionString(final String connectionStringValue) {
        this.connectionString = connectionStringValue;
    }
    
    private String connectionStringName;
    
    /**
    * Optional.  Contains a connection string name that is linked to the
    * SiteConfig.ConnectionStrings.This is used during restore with overwrite
    * connection strings options.
    * @return The ConnectionStringName value.
    */
    public String getConnectionStringName() {
        return this.connectionStringName;
    }
    
    /**
    * Optional.  Contains a connection string name that is linked to the
    * SiteConfig.ConnectionStrings.This is used during restore with overwrite
    * connection strings options.
    * @param connectionStringNameValue The ConnectionStringName value.
    */
    public void setConnectionStringName(final String connectionStringNameValue) {
        this.connectionStringName = connectionStringNameValue;
    }
    
    private String databaseType;
    
    /**
    * Optional. The database type (either SqlAzure or MySql)
    * @return The DatabaseType value.
    */
    public String getDatabaseType() {
        return this.databaseType;
    }
    
    /**
    * Optional. The database type (either SqlAzure or MySql)
    * @param databaseTypeValue The DatabaseType value.
    */
    public void setDatabaseType(final String databaseTypeValue) {
        this.databaseType = databaseTypeValue;
    }
    
    private String name;
    
    /**
    * Optional. Always contains the original database name (it is used as a key
    * for association with a dump in the backup package) - even if it is a
    * restore to a new and different database.
    * @return The Name value.
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * Optional. Always contains the original database name (it is used as a key
    * for association with a dump in the backup package) - even if it is a
    * restore to a new and different database.
    * @param nameValue The Name value.
    */
    public void setName(final String nameValue) {
        this.name = nameValue;
    }
}
