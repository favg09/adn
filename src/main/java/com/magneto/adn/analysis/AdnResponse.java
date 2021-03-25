package com.magneto.adn.analysis;

import java.text.DecimalFormat;

public class AdnResponse {
	
	private double count_mutant_dna;
	private double count_human_dna;
	
	public AdnResponse(double count_mutant_dna, double count_human_dna) {
		this.count_mutant_dna = count_mutant_dna;
		this.count_human_dna = count_human_dna;
	}
	public double getCount_mutant_dna() {
		return count_mutant_dna;
	}
	public void setCount_mutant_dna(double count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}
	public double getCount_human_dna() {
		return count_human_dna;
	}
	public void setCount_human_dna(double count_human_dna) {
		this.count_human_dna = count_human_dna;
	}
	public double getRatio() {
		DecimalFormat df2 = new DecimalFormat("#.#");
		if(count_human_dna != 0) {
			return Double.valueOf(df2.format(count_mutant_dna / count_human_dna));
		}
		else
			return 1.0;
	}

}
