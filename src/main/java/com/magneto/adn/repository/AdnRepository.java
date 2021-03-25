package com.magneto.adn.repository;

import org.springframework.data.repository.CrudRepository;

import com.magneto.adn.entity.Adn;

public interface AdnRepository extends CrudRepository<Adn, Long> {
	long countByHuman(int num);
}
