/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.reef.javabridge;

import org.apache.reef.annotations.audience.Interop;
import org.apache.reef.annotations.audience.Private;
import org.apache.reef.driver.evaluator.CompletedEvaluator;
import org.apache.reef.io.naming.Identifiable;

/**
 * The Java-CLR bridge object for {@link org.apache.reef.driver.evaluator.CompletedEvaluator}.
 */
@Private
@Interop(
    CppFiles = { "Clr2JavaImpl.h", "CompletedEvaluatorClr2Java.cpp" },
    CsFiles = { "ICompletedEvaluatorClr2Java.cs", "CompletedEvaluator.cs" })
public final class CompletedEvaluatorBridge extends NativeBridge implements Identifiable {

  private final CompletedEvaluator jcompletedEvaluator;

  private final String evaluatorId;

  public CompletedEvaluatorBridge(final CompletedEvaluator completedEvaluator) {
    jcompletedEvaluator = completedEvaluator;
    evaluatorId = completedEvaluator.getId();
  }

  @Override
  public String getId() {
    return evaluatorId;
  }

  @Override
  public void close() {
  }
}
