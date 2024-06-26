// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.datasource.trinoconnector;

import org.apache.doris.catalog.Column;
import org.apache.doris.datasource.SchemaCacheValue;

import io.trino.spi.connector.ColumnHandle;
import io.trino.spi.connector.ColumnMetadata;
import io.trino.spi.connector.ConnectorTableHandle;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
public class TrinoSchemaCacheValue extends SchemaCacheValue {

    private Optional<ConnectorTableHandle> connectorTableHandle;
    private Map<String, ColumnHandle> columnHandleMap;
    private Map<String, ColumnMetadata> columnMetadataMap;

    public TrinoSchemaCacheValue(List<Column> schema, Optional<ConnectorTableHandle> connectorTableHandle,
            Map<String, ColumnHandle> columnHandleMap, Map<String, ColumnMetadata> columnMetadataMap) {
        super(schema);
        this.connectorTableHandle = connectorTableHandle;
        this.columnHandleMap = columnHandleMap;
        this.columnMetadataMap = columnMetadataMap;
    }
}
