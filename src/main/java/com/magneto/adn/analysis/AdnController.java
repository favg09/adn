package com.magneto.adn.analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.magneto.adn.entity.Adn;
import com.magneto.adn.error.NotMutantException;
import com.magneto.adn.repository.AdnRepository;

@RestController
@RequestMapping("/mutant")
public class AdnController {
	
	@Autowired
	private AdnRepository repo;

	@SuppressWarnings("unchecked")
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void checkADNs(@RequestBody String dna) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
	    TypeReference<HashMap<String,Object>> typeRef = new TypeReference<HashMap<String,Object>>() {};
	    HashMap<String,Object> map = mapper.readValue(dna, typeRef);
	    
		ArrayList<String> dnaList =  (ArrayList<String>) map.get("dna");
	    String[] dnaArray = new String[dnaList.size()];
	    dnaArray = dnaList.toArray(dnaArray);
	    StringBuffer sb = new StringBuffer();
	    for (String s : dnaList){
	    	sb.append(s + "-") ;
	    }
	    
	    if(isMutant(dnaArray)) {
	    	//save into DB
	    	Adn adn = new Adn(sb.toString(), 0);
	    	repo.save(adn);
	    	throw new NotMutantException();
	    }
	    else {
	    	//save into DB
	    	Adn adn = new Adn(sb.toString(), 1);
	    	repo.save(adn);
	    }
	    	
	}
	
	
	public boolean isMutant(String[] dna) {

		if(findDna(dna))
			return true;
		
		//busqueda vertical
		String[]dnaCol = transpose(dna);
		if(findDna(dnaCol))
			return true;
		
		//busqueda diagonal
/*		String[]dnaDig = transpose2(dna);
		if(findDna(dnaDig))
			return true; */
		
		return false;
	}


	private boolean findDna(String[] dna) {
		ArrayList<String> baseList = new ArrayList<String>(Arrays.asList("AAAA", "TTTT", "GGGG", "CCCC"));	

		//busqueda horizontal
		for (String base : baseList) {
			if(Arrays.stream(dna).anyMatch(s -> s.contains(base)))
				return true;
		}
		
		return false;
	}
		
	public String[] transpose(String[] matrix) {
		ArrayList<String> arr = new ArrayList<String>();
		for (int i = 0; i < matrix.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < matrix.length; j++) {
				sb.append(matrix[j].charAt(i)); 			
			}
			arr.add(sb.toString());
		}
        return arr.toArray(new String[0]); 
    }

	
	public String[] transpose2(String[] matrix) {
		ArrayList<String> arr = new ArrayList<String>();
		for (int i = 0; i < matrix.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < matrix.length; j++) {
				sb.append(matrix[j].charAt(j)); 			
			}
			arr.add(sb.toString());
		}
        return arr.toArray(new String[0]); 
    }

}