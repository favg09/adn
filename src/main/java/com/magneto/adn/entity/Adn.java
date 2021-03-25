package com.magneto.adn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String adnsec;
	private int human;

	public Adn(String adnsec, int human) {
		this.adnsec = adnsec;
		this.human = human;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdnsec() {
		return adnsec;
	}

	public void setAdnsec(String adnsec) {
		this.adnsec = adnsec;
	}

	public int getHuman() {
		return human;
	}

	public void setHuman(int human) {
		this.human = human;
	}



}
