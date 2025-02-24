package comparablecows;

import java.util.Arrays;

public class Cow extends Animal{
	
	public Cow(int weight, String name) {
		super(weight, name);
	}
	
	public static void printArray(Cow[] cows) {
		for(int i = 0; i < cows.length; i++) {
			System.out.print(cows[i].name + ", ");
		}
	}
	
//	public static void main(String[] args) {
//	    Cow[] cows = { new Cow(2000, "Hulk"),
//	                   new Cow(),
//	                   new Cow(1600, "Bessie"),
//	                   new Cow(1700, "Moohead"),
//	                   new Cow(),
//	                   new Cow(1900, "Big Time Jones") };
//
//	    printArray(cows);
//	    Arrays.sort(cows);
//	    System.out.println();
//	    printArray(cows);
//	}
	
	public int getWeight() {
		return weight;
	}


//	@Override
//	public int compareTo(Cow o) {
//		return weight - o.getWeight();
//	}

}
