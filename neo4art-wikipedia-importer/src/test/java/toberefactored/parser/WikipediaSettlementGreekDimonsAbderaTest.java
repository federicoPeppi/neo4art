package toberefactored.parser;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Test;
import org.neo4art.domain.Settlement;

import toberefactored.parser.WikipediaSettlementGreekDimosInfoboxParser;

public class WikipediaSettlementGreekDimonsAbderaTest {

	private static String INFOBOX ="{{Infobox Greek Dimos\n"+
			"|name = Abdera\n"+
			"|lat_deg = 40\n"+
			"|lat_min = 57\n"+
			"|lon_deg = 24\n"+
			"|lon_min = 59\n"+
			"|website = \n"+
			"}}";
	
	@Test
	public void shoudParseSettlement() throws MalformedURLException{
		Settlement settlement = WikipediaSettlementGreekDimosInfoboxParser.parse(INFOBOX);
		
		Assert.assertEquals("Abdera", settlement.getName());
		Assert.assertEquals("40.0",""+settlement.getCoordinates().getLatD());
		Assert.assertEquals("57.0",""+settlement.getCoordinates().getLatM());
		Assert.assertEquals("24.0",""+settlement.getCoordinates().getLongD());
		Assert.assertEquals("59.0",""+settlement.getCoordinates().getLongM());
	}
	
}
