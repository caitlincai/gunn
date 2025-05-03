

public class Week1 {
	public static int fastexpt(int a, int b, int n) {
		while(n != 0) {
			if (isEven(n)) {
				b = b * b;
				n = n / 2;
			}
			else {
				a = a * b;
				n--;
			}
		}
		return a;
	}
	public static boolean isEven(int n) {
		if (n % 2 == 0) {
			return true;
		}
		return false;
	}
	public static void main(String args[]) {
		System.out.println(fastexpt(1, 2, 10));
	}
}
