package examples.maxfunction;

import geneticapi.Chromosome;
import geneticapi.Offspring;


public class FunctionChromosome implements Chromosome {
	private static final double MIN = 0;
	private static final double MAX = 8;
	
	final double xVal;
	private final double score;
	
	public FunctionChromosome(double x) {
		xVal = x;
		score = Math.max(xVal * Math.cos(xVal) * Math.sin(xVal), 0);
	}
	
	@Override
	public double getScore() {
		return score;
	}

	@Override
	public Offspring crossOver(Chromosome other) {
		double delta1 = Math.random() - 0.5;
		double delta2 = Math.random() - 0.5;
		return new Offspring(
				new FunctionChromosome(xVal + delta1), 
				new FunctionChromosome(((FunctionChromosome) other).xVal + delta2)
		);
	}

	@Override
	public boolean isValid() {
		return MIN <= xVal && xVal <= MAX;
	}

	@Override
	public Chromosome mutate() {
		double prob = 0.01;
		if (Math.random() <= prob)
			return new FunctionChromosome(Math.random() * 10);
		else return this;
	}

}
