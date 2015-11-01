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
package org.neo4art.toberefactored.creator;

import org.neo4art.api.search.bean.WikipediaSearchResultRelationship;
import org.neo4art.graphdb.Relationship;

/**
 * @author Enrico De Benetti
 * @since 01 Mag 2015
 *
 */
public class LinkCreator {

    private static LinkCreator instance = null;
	
	private LinkCreator(){
		
	}
	
    public static LinkCreator getInstance(){
		
	 if(instance == null){
			
			instance = new LinkCreator();
	 }
		
	 return instance;
	}
	
    public WikipediaSearchResultRelationship createLink(Relationship relationship){
    	
     WikipediaSearchResultRelationship wikipediaSearchResultRelationship = new WikipediaSearchResultRelationship();
     wikipediaSearchResultRelationship.setSource(relationship.getStartNode().getNodeId());
     wikipediaSearchResultRelationship.setTarget(relationship.getEndNode().getNodeId());
     
     return wikipediaSearchResultRelationship;	
    }
    
}
