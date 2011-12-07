/*
 * Copyright 2011 JBoss, by Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.errai.marshalling.server.marshallers;

import org.jboss.errai.marshalling.client.api.MarshallingSession;
import org.jboss.errai.marshalling.client.api.annotations.ServerMarshaller;
import org.jboss.errai.marshalling.client.marshallers.AbstractCharSequenceMarshaller;
import org.jboss.errai.marshalling.server.util.ServerMarshallUtil;

/**
 * @author Mike Brock <cbrock@redhat.com>
 */
@ServerMarshaller
public class ServerStringMarshaller extends AbstractCharSequenceMarshaller<Object, String> {
  @Override
  public Class<String> getTypeHandled() {
    return String.class;
  }

  @Override
  public String demarshall(Object o, MarshallingSession ctx) {
    return String.valueOf(o);
  }

  @Override
  public boolean handles(Object o) {
    return ServerMarshallUtil.handles(o, getTypeHandled());
  }
}