/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.seatunnel.transform.common;

import org.apache.seatunnel.api.table.catalog.CatalogTable;
import org.apache.seatunnel.api.table.type.SeaTunnelRow;
import org.apache.seatunnel.api.transform.SeaTunnelMultiRowTransform;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class AbstractCatalogMultiRowTransform
        extends AbstractSeaTunnelTransform<SeaTunnelRow, List<SeaTunnelRow>>
        implements SeaTunnelMultiRowTransform<SeaTunnelRow> {

    public AbstractCatalogMultiRowTransform(@NonNull CatalogTable inputCatalogTable) {
        super(inputCatalogTable);
    }

    public AbstractCatalogMultiRowTransform(
            @NonNull CatalogTable inputCatalogTable, ErrorHandleWay rowErrorHandleWay) {
        super(inputCatalogTable, rowErrorHandleWay);
    }

    @Override
    public List<SeaTunnelRow> flatMap(SeaTunnelRow row) {
        return transform(row);
    }
}
