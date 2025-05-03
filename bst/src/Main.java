public class Main {

	public static void main(String[] args) {
		// BST<Integer> bsti = new BST<Integer>(12);
		// bsti.insert(7);
		// bsti.insert(19);
        // System.out.println(bsti.depth());
		System.out.println(Main.create());
	}

	public static int create() {
        Randp randp = new Randp(10000);
        BST<Integer> bsti = new BST<Integer>(randp.nextInt());
        for (int i = 0; i < 9999; i++) {
            bsti.insert(randp.nextInt());
        }
        return bsti.depth();
    }
}
