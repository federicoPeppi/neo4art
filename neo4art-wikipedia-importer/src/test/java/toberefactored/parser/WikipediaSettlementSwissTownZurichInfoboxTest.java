package toberefactored.parser;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Test;
import org.neo4art.domain.Settlement;

import toberefactored.parser.WikipediaSettlementSwissTownInfoboxParser;

public class WikipediaSettlementSwissTownZurichInfoboxTest {

	private static String INFOBOX ="{{Infobox Swiss town\n"+
				"| subject_name = Zürich\n"+
				"| lat_d=47\n"+
				"|lat_m=22\n"+
				"|lat_NS=N\n"+
				"|long_d=8\n"+
				"|long_m=33\n"+
				"|long_EW=E\n"+
				"}}";
		
		
	@Test
	public void shoudParseArtwork() throws MalformedURLException{
		Settlement settlement = WikipediaSettlementSwissTownInfoboxParser.parse(INFOBOX);
		
		Assert.assertEquals("Zürich",settlement.getName());
		Assert.assertEquals("47.0",""+settlement.getCoordinates().getLatD());
		Assert.assertEquals("22.0",""+settlement.getCoordinates().getLatM());
		Assert.assertEquals("N",""+settlement.getCoordinates().getLatNS());
		Assert.assertEquals("8.0",""+settlement.getCoordinates().getLongD());
		Assert.assertEquals("33.0",""+settlement.getCoordinates().getLongM());
		Assert.assertEquals("E",""+settlement.getCoordinates().getLongEW());

	}
	
}
