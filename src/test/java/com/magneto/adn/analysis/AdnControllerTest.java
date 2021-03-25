package com.magneto.adn.analysis;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdnControllerTest {

	@Autowired
	AdnController adnCtr;
	
	@Ignore
	public void testIsMutant() {

		String[] dnaHuman = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		Assertions.assertEquals(true, adnCtr.isMutant(dnaHuman));
		
		
	}
}
