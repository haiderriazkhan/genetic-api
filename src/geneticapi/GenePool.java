package geneticapi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenePool implements Iterable<Chromosome> {
	private List<Chromosome> chromosomes = new ArrayList<>();
	
	public int size() {
		return chromosomes.size();
	}
	
	public void add(Chromosome chromo) {
		chromosomes.add(chromo);
	}
	
	@Override
	public Iterator<Chromosome> iterator() {
		return chromosomes.iterator();
	}
	
	public List<Chromosome> getAll() {
		return chromosomes;
	}
}
