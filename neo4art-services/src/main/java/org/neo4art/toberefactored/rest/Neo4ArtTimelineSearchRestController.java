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
package org.neo4art.toberefactored.rest;

import java.util.List;

import org.neo4art.colour.domain.ColourAnalysis;
import org.neo4art.colour.manager.ArtworksColoursAnalyzer;
import org.neo4art.colour.manager.ArtworksDefaultColoursAnalyzer;
import org.neo4art.domain.Artist;
import org.neo4art.sentiment.domain.SentimentAnalysis;
import org.neo4art.sentiment.service.SentimentAnalysisPOSTagPatternService;
import org.neo4art.sentiment.service.SentimentAnalysisService;
import org.neo4art.toberefactored.domain.SentimentEvent;
import org.neo4art.toberefactored.domain.TimelineEvent;
import org.neo4art.toberefactored.transformer.TimeLineTransformer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Enrico De Benetti
 * @since 29 Apr 2015
 *
 */

@Controller
@RequestMapping("/api/timeline")
public class Neo4ArtTimelineSearchRestController
{

  @RequestMapping(value = "/colours-analysis.json", method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody List<TimelineEvent> getColoursAnalysis(Model model, @RequestParam(value = "searchInput", required = true) String searchInput)
  {

    ArtworksColoursAnalyzer artworksDefaultColoursAnalyzer = new ArtworksDefaultColoursAnalyzer();
    Artist artist = new Artist();
    artist.setName(searchInput);
    List<ColourAnalysis> colourAnalysisByArtist = artworksDefaultColoursAnalyzer.getColourAnalysisByArtist(artist);

    return TimeLineTransformer.buildTimeLineEvents(colourAnalysisByArtist);
  }

  @RequestMapping(value = "/sentiments-analysis.json", method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody List<SentimentEvent> getSentimentAnalysis(Model model, @RequestParam(value = "searchInput", required = true) String searchInput)
  {

//    BuildSentimentMock buildSentimentMock = new BuildSentimentMock();
//    List<SentimentAnalysis> sentimentAnalisys = buildSentimentMock.getSentimentAnalisys(searchInput);
    
    SentimentAnalysisService sentimentAnalysisService = new SentimentAnalysisPOSTagPatternService();
    Artist artist = new Artist();
    artist.setName(searchInput);
    List<SentimentAnalysis> sentimentAnalisys = sentimentAnalysisService.makeSentimentAnalisysByArtist(artist);

    return TimeLineTransformer.buildSentimentsEvent(sentimentAnalisys);
  }

}
