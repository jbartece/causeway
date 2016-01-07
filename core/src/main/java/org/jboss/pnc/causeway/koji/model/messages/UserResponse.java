/**
 * Copyright (C) 2015 Red Hat, Inc. (jdcasey@commonjava.org)
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
package org.jboss.pnc.causeway.koji.model.messages;

import org.commonjava.rwx.binding.anno.DataIndex;
import org.commonjava.rwx.binding.anno.IndexRefs;
import org.commonjava.rwx.binding.anno.Response;
import org.jboss.pnc.causeway.koji.model.KojiUserInfo;

/**
 * Created by jdcasey on 12/3/15.
 */
@Response
public class UserResponse
{
    @DataIndex( 0 )
    private KojiUserInfo userInfo;

    @IndexRefs( { 0 } )
    public UserResponse( KojiUserInfo userInfo )
    {
        this.userInfo = userInfo;
    }

    public KojiUserInfo getUserInfo()
    {
        return userInfo;
    }
}
