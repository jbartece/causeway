/**
 * Copyright (C) 2015 Red Hat, Inc. (jbrazdil@redhat.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.pnc.causeway.rest;

import org.jboss.pnc.causeway.ctl.PncImportController;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.UUID;


@RequestScoped
public class PncImportResourceEndpoint implements PncImportResource {

    @Inject
    private PncImportController controller;

    @Override
    public Response testResponse( String var )
    {
        return Response.ok( var ).build();
    }

    @Override
    public BrewPushMilestoneResponse importProductMilestone(BrewPushMilestone request)
    {
        String id = UUID.randomUUID().toString();
        
        controller.importMilestone(request.getContent().getMilestoneId(), request.getCallback(), id);
        
        return new BrewPushMilestoneResponse(new Callback(id));
    }


}
