package thebrilliantnumberproblem;

import java.util.ArrayList;

public class Primes {
    ArrayList<Integer> primes = new ArrayList<Integer>();
	
	public Primes(int n) {
		addPrimes(2, n);
	}
	
	public void addPrimes(int start, int n) {
		int i = n;
		while (i > 0) {
			if (Main.isPrime(start)) {
				primes.add(start);
				start++;
				i--;
			}
			else {
				start++;
			}
		}
	}
	
	public ArrayList<Integer> getPrimes() { return primes; }
	
	public boolean isPrime(int n) {
		if (primes.get(0) > n) {
			for (int i = 2; i < n; i++) {
				if (isPrime(i)) {
					primes.add(i);
				}
			}
		}
		
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
