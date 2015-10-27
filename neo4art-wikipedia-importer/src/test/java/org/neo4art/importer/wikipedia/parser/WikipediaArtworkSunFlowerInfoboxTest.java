package org.neo4art.importer.wikipedia.parser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.neo4art.domain.Artwork;
import org.neo4art.importer.wikipedia.parser.WikipediaArtworkInfoboxParser;

public class WikipediaArtworkSunFlowerInfoboxTest {
  
	private static String INFOBOX =
	 	"{{Infobox Artwork\n"+
	  "| image_file       = Vincent Willem van Gogh 127.jpg\n"+
	  "| image_size       = 225px\n"+
	  "| title            = Sunflowers\n"+
	  "| other_language_1 = Original title, in French\n"+
	  "| other_title_1    = Tournesols\n"+
	  "| artist           = Vincent van Gogh\n"+
	  "| year             = 1888\n"+
	  "| type             = Oil on canvas\n"+
	  "| height_metric    = 92.1\n"+
	  "| width_metric     = 73\n"+
	  "| height_imperial  = 36.2\n"+
	  "| width_imperial   = 28.7\n"+
	  "| metric_unit      = cm\n"+
	  "| imperial_unit    = in\n"+
	  "| museum           = [[National Gallery (London)|National Gallery]]\n"+
	  "| city             = London\n" +
	  "}}";
	
	@Test
	public void shoudParseVanGoghSunflowersArtwork() throws MalformedURLException{
    
    Calendar year1888 = Calendar.getInstance();
    year1888.set(1888, Calendar.JANUARY, 1, 0, 0, 0);
    year1888.set(Calendar.MILLISECOND, 0);
    
    Artwork artwork = WikipediaArtworkInfoboxParser.parse(INFOBOX);
    
    Assert.assertEquals("Sunflowers", artwork.getTitle());
    Assert.assertEquals("Vincent van Gogh", artwork.getArtist().getName());
    Assert.assertEquals("London", artwork.getCity().getName());
    Assert.assertEquals(new URL("https://en.wikipedia.org/wiki/File:Vincent_Willem_van_Gogh_127.jpg"), artwork.getUrl());
    Assert.assertEquals("National Gallery (London)", artwork.getMuseum().getName());
    Assert.assertEquals("Oil on canvas", artwork.getType());
    Assert.assertEquals(year1888.getTimeInMillis(), artwork.getYear().getTime());
  }
}
