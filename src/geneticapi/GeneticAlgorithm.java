package geneticapi;

public class GeneticAlgorithm {
	private GenePool pool;	
	private final GeneSelector geneSelector;
	private final int numIterations;
	
	public GeneticAlgorithm(GenePool pool, GeneSelector geneSelector, int numIterations) {
		this.pool = pool;
		this.geneSelector = geneSelector;
		this.numIterations = numIterations;
	}
	
	public Chromosome run() {
		Chromosome best = pool.iterator().next();
		
		for (int n = 0; n < numIterations; n++) {
			GenePool nextGen = new GenePool();
			
			for (int i = 0; i < pool.size(); ) {
				Chromosome mom = geneSelector.selectGene(pool);
				Chromosome dad = geneSelector.selectGene(pool);
				Offspring offspring = mom.crossOver(dad);
				Chromosome c1 = offspring.first.mutate(), c2 = offspring.second.mutate();

				if (c1.isValid()) {
					if (c1.getScore() > best.getScore()) 
						best = c1;
					nextGen.add(c1);
					i++;
				}
				if (c2.isValid()) {
					if (c2.getScore() > best.getScore()) 
						best = c2;
					nextGen.add(c2);
					i++;
				}
			}
			
			pool = nextGen;
		}
		
		return best;
	}
}
