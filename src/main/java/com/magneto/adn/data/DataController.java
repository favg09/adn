package com.magneto.adn.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magneto.adn.analysis.AdnResponse;
import com.magneto.adn.repository.AdnRepository;

@RestController
@RequestMapping("/stats")
public class DataController {

	@Autowired
	private AdnRepository repo;
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public AdnResponse getStats() {
		
		AdnResponse adnResp = new AdnResponse(repo.countByHuman(0), repo.countByHuman(1));
		return adnResp;
	}
	
}