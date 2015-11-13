package examples.maxfunction;

import geneticapi.GenePool;
import geneticapi.GeneSelector;
import geneticapi.GeneticAlgorithm;

public class ComputeMax {

	public static void main(String[] args) {
		GeneSelector selector = new RouletteSelector();
		GenePool pool = new GenePool();
		
		// Add some sample points
		for (int i = 0; i < 10; i++) {
			FunctionChromosome c = new FunctionChromosome(Math.random() * 10);
			pool.add(c);
		}
		
		GeneticAlgorithm alg = new GeneticAlgorithm(pool, selector, 800);
		FunctionChromosome best = (FunctionChromosome) alg.run();
		System.out.println(best.xVal);
		System.out.println(best.getScore());
	}

}
