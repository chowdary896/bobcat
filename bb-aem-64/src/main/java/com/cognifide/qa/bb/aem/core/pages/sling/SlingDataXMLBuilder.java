/*-
 * #%L
 * Bobcat
 * %%
 * Copyright (C) 2018 Cognifide Ltd.
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
package com.cognifide.qa.bb.aem.core.pages.sling;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/**
 * Builder for Sling data. Loads an XML with test data and uses {@link PageXMLParserHandler} to parse it.
 */
public final class SlingDataXMLBuilder {

  private static final Logger LOG = LoggerFactory.getLogger(SlingDataXMLBuilder.class);

  /**
   * Prepares list of nodes information
   *
   * @param fileName xml filename (should be in test resources)
   * @return List of nodes to be created
   */
  public static List<BasicNameValuePair> buildFromFile(String fileName) {
    List<BasicNameValuePair> toReturn = new ArrayList<>();
    try (InputStream fileInputStream = SlingDataXMLBuilder.class.getClassLoader()
        .getResourceAsStream(fileName)) {
      PageXMLParserHandler xmlParserHandler = new PageXMLParserHandler();
      if (fileInputStream != null) {
        SAXParserFactory.newInstance().newSAXParser().parse(fileInputStream,
            xmlParserHandler);
      }
      toReturn = xmlParserHandler.getParserResults();
    } catch (IOException e) {
      LOG.error("Can't load page data file: " + fileName, e);
    } catch (SAXException | ParserConfigurationException e) {
      LOG.error("Problem with creating xml parser", e);
    }
    return toReturn;
  }

  private SlingDataXMLBuilder() {
    //util
  }
}
