package idwall.desafio.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import idwall.desafio.Main;

class IdwallFormatterTest {
	
	private final String DEFAULT_STRING = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" +
            "\n" +
            "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
    
	

	@Test
	void testBigWord() {
		String bigWord = "Antinconstitucionalíssimamente";
		
		StringFormatter sf = new IdwallFormatter(25);
		
		assertThrows(Exception.class, () -> {sf.format(bigWord);});
	}
	
	@Test
	void invalidLimitNumber() {
		String[] args = { DEFAULT_STRING , "-3"};
		assertThrows(Exception.class, () -> {Main.main(args);});
	}
	
	@Test
	void defaultValuesTest() throws Exception {
		String expectedReturn = "In the beginning God created the heavens\n" + 
				"and   the   earth.  Now  the  earth  was\n" + 
				"formless  and  empty,  darkness was over\n" + 
				"the  surface of the deep, and the Spirit\n" + 
				"of  God  was  hovering  over the waters.\n" + 
				"\n" + 
				"And  God said, \"Let there be light,\" and\n" + 
				"there  was light. God saw that the light\n" + 
				"was  good,  and  he  separated the light\n" + 
				"from  the darkness. God called the light\n" + 
				"\"day,\"   and   the  darkness  he  called\n" + 
				"\"night.\"  And  there  was  evening,  and\n" + 
				"there  was  morning  -  the  first  day.\n";
				
		StringFormatter sf = new IdwallFormatter(40,true);
		
		try {
			assertTrue(expectedReturn.equals(sf.format(DEFAULT_STRING)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}

}
