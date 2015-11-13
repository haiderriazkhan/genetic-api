package examples.maxfunction;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import geneticapi.Chromosome;
import geneticapi.GenePool;
import geneticapi.GeneSelector;

public class RouletteSelector implements GeneSelector {

	@Override
	public Chromosome selectGene(GenePool pool) {
		double total = 0;
		
		for (Chromosome c : pool) {
			total += c.getScore();
		}
		
		List<Chromosome> all = pool.getAll();
		Collections.sort(all, new Comparator<Chromosome>() {

			@Override
			public int compare(Chromosome arg0, Chromosome arg1) {
				if (arg0.getScore() < arg1.getScore()) return -1;
				else if (arg0.getScore() > arg1.getScore()) return 1;
				else return 0;
			}
			
		});
		
		double rand = Math.random() * total;
		double cumulative = 0;
		
		for (Chromosome c : all) {
			cumulative += c.getScore();
			if (cumulative >= rand) return c;
		}
		
		return all.get(all.size() - 1);
	}

}
