package vp;

import java.util.Calendar;

public class Random {
	// parametros para geracao
	private long p = 2147483648L;
	private long m = 843314861;
	private long a = 453816693;
	
	private long xi = 1023; // essa eh a semente
	
	
	public Random(int k) {
		xi = k;
	}
	
	public Random() {
		xi = Calendar.getInstance().getTimeInMillis() % 100000000;
	}
	
	public double getRand() {
		// calcula o proximo valor xi
		xi = (a + (m * xi)) % p;
		double d = xi; // promove p/ double
		return d / p; // entre 0 e 1
	}
	
	
	public int getIntRand(int max) {
		// gera valor entre 0 e 1 e multiplica
		double rand = getRand() * max;
		return (int) rand;
		
	}
	
	public int getIntRand(int min, int max) {
		if(max <= min)
			throw new IllegalArgumentException("Parâmetros inválidos");
		return min + getIntRand(max - min);
		
	}
	
	public int getIntRand() {
		return getIntRand(Integer.MAX_VALUE);
		
	}

	public void setSemente(int k) {
		xi = k;
	}
	
@Override
	
	public String toString() {
		return xi + "";
	}

}
