/*-
 * #%L
 * Bobcat Parent
 * %%
 * Copyright (C) 2016 Cognifide Ltd.
 * %%
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
 * #L%
 */
package com.cognifide.qa.bb.logging.entries;



/**
 * This entry marks the end of a subreport
 */
public class SubreportEndEntry extends LogEntry {

  private String name;

  /**
   * Constructs SubreportEndEntry.
   *
   * @param name of the subreport
   */
  public SubreportEndEntry(String name) {
    super();
    this.name = name;
  }

  /**
   * @return Name of the subreport
   */
  public String getName() {
    return name;
  }
}