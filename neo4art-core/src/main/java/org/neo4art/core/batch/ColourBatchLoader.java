/**
 * Copyright 2015 the original author or authors.
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

package org.neo4art.core.batch;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.neo4art.core.service.ColourDefaultService;
import org.neo4art.core.service.ColourService;
import org.neo4art.domain.Colour;

import deprecated.Neo4ArtBatchInserterSingleton;

/**
 * @author Lorenzo Speranzoni
 * @since 3 May 2015
 */
public class ColourBatchLoader
{
  private static Log logger = LogFactory.getLog(ColourBatchLoader.class);

  public static void main(String[] args)
  {
    try
    {
      ColourService colourService = new ColourDefaultService();

      List<Colour> colours = colourService.getColours();

      colourService.saveColours(colours);
    }
    catch (Exception e)
    {
      e.printStackTrace();

      logger.error("Error saving list of colours into neo4j: " + e.getMessage());
    }
    finally
    {
      Neo4ArtBatchInserterSingleton.shutdownBatchInserterInstance();
    }
  }
}
