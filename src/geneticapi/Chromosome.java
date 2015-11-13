package geneticapi;

public interface Chromosome {
	public double getScore();
	
	public Offspring crossOver(Chromosome other);
	
	public boolean isValid();
	
	public Chromosome mutate();
}
