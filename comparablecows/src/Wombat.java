

public class Wombat extends Animal {
	private static int weight = 1800;
	private static String name = "Anonymous Wombat";
	
	public Wombat() {
		super(weight, name);
	}
	public Wombat(int weight, String name) {
		super(weight, name);
	}
	@Override
	public void eat(int i) {
		System.out.println("Wombats don't gain weight when they eat!");
	}
}
