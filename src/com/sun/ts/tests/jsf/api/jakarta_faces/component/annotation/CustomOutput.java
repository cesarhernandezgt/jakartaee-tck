/*
 * Copyright (c) 2009, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * $Id$
 */

package com.sun.ts.tests.jsf.api.jakarta_faces.component.annotation;

import jakarta.faces.application.ResourceDependencies;
import jakarta.faces.application.ResourceDependency;
import jakarta.faces.component.UIOutput;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.PostAddToViewEvent;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.event.ComponentSystemEventListener;
import jakarta.faces.event.ListenerFor;

@ListenerFor(systemEventClass = PostAddToViewEvent.class, sourceClass = CustomOutput.class)
@ResourceDependency(name = "#{'hello.js'}", library = "test", target = "#{'body'}")
@ResourceDependency(name = "black-n-blue.css", library = "#{'test'}", target = "body")
@ResourceDependency(name = "black-n-red.css", library = "", target = "")
public class CustomOutput extends UIOutput
    implements ComponentSystemEventListener {

  private boolean processEventInvoked;

  private ComponentSystemEvent event;

  public void processEvent(ComponentSystemEvent event)
      throws AbortProcessingException {
    processEventInvoked = true;
    this.event = event;
  }

  public void reset() {
    processEventInvoked = false;
    event = null;
  }

  public boolean isProcessEventInvoked() {
    return processEventInvoked;
  }

  public ComponentSystemEvent getEvent() {
    return event;
  }
}
