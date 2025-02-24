package thebrilliantnumberproblem;

import java.util.ArrayList;

public class Main {
	
	public static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isBrilliant(int n) {
		for (int i = 2; i < n; i++) {
			if (isPrime(i) && n % i == 0) {
				int factor = n / i;
				if (isPrime(factor) && sameNumberOfDigits(i, factor)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean sameNumberOfDigits(int one, int two) {
		return numDigits(one) == numDigits(two);
	}
	public static int numDigits(int n) {
		return ("" + n).length();
	}
		
	
	public static void main(String args[]) {
		Primes p = new Primes(50);
		System.out.println(p.getPrimes());
//		System.out.println(sameNumberOfDigits(100, 2400));
//		System.out.println(isPrime(16));
//		System.out.println(isBrilliant(10));
//		System.out.println(isBrilliant(14));
//		System.out.println(isBrilliant(15));
//		System.out.println(isBrilliant(21));
//		System.out.println(isBrilliant(77));
		Brilliant b = new Brilliant(20);
	}
}
