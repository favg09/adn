package com.magneto.adn.repository;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdnRepositoryTest {

	@Autowired
	private AdnRepository repo;
	
	@Ignore
	public void testGetStats() {
		
		Assertions.assertEquals(1,repo.countByHuman(0));
		Assertions.assertEquals(1,repo.countByHuman(1));

	}
}
