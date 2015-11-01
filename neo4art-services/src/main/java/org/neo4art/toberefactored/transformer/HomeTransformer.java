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
package org.neo4art.toberefactored.transformer;

import org.neo4art.domain.Artwork;
import org.neo4art.toberefactored.builder.mock.BuildBackgroundArtworkMock;
import org.neo4art.toberefactored.domain.BackgroundArtwork;

/**
 * @author Enrico De Benetti
 * @since 02 Mag 2015
 *
 */
public class HomeTransformer {

	public static BackgroundArtwork buildBackgroundArtwork(){
	
	 BackgroundArtwork backgroundArtwork = new BackgroundArtwork();	
	 BuildBackgroundArtworkMock backgroundArtworkMock = new BuildBackgroundArtworkMock();	
	 Artwork artwork = backgroundArtworkMock.getArtwork();
	 
	 backgroundArtwork.setLink(artwork.getUrl()!= null ? artwork.getUrl().toString() : "");
	 backgroundArtwork.setTitle(artwork.getTitle());
	 
	 return backgroundArtwork;	
	}	
	
	
}
