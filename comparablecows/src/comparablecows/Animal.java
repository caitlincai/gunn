package comparablecows;

import java.util.Arrays;

public class Animal implements Comparable<Animal>{
	int weight;
	String name;
	
	public Animal(int weight, String name) {
		this.weight = weight;
		this.name = name;
	}
	
	public void eat(int i) {
		weight +=i ;
	}
	public String getName() {
		return name;
	}
	public int getWeight() {
		return weight;
	}
	
	public static void main(String[] args) {
	    Animal[] animals = { new Horse(2000, "Hulk"),
	                         new Wombat(),
	                         new Wombat(1600, "Bessie"),
	                         new Cow(1700, "Moohead"),
	                         new Wombat(),
	                         new Wildebeest(1900, "Big Time Jones") };

	    
	    printArray(animals);
	    for (Animal a : animals) {
	        a.eat(200);
	    }
	    Arrays.sort(animals);
	    printArray(animals);
	}

	private static void printArray(Animal[] animals) {
		for(int i = 0; i < animals.length; i++) {
			System.out.print(animals[i].getName() + ": " + animals[i].getWeight() + ", ");
		}
		System.out.println();
	}

	@Override
	public int compareTo(Animal o) {
		return weight - o.getWeight();
	}
}
