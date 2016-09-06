/*
 * Copyright 2016 Cognifide Ltd..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cognifide.qa.bb.loadable.hierarchy;

import com.cognifide.qa.bb.loadable.context.LoadableComponentContext;
import java.util.Stack;

public class ConditionStack {

  private final Stack<LoadableComponentContext> stack;

  public ConditionStack(Stack<LoadableComponentContext> stack) {
    this.stack = stack;
  }

  public Stack<LoadableComponentContext> getLoadableContextStack() {
    // please note that this is not Object#clone
    return (Stack<LoadableComponentContext>) stack.clone();
  }
}
