package thebrilliantnumberproblem;
import java.util.ArrayList;

public class Brilliant {
	
	public Brilliant(int n) {
		initialize(n);
	}
	
	public void initialize(int n) {
		ArrayList<Integer> brilliantNums = new ArrayList<Integer>();
		
		for (int i = 0; brilliantNums.size() < n; i++) {
			if (Main.isBrilliant(i)) {
				brilliantNums.add(i);
			}
		}
		for (int i = 0; i < brilliantNums.size(); i++) {
			System.out.println(brilliantNums.get(i));
		}
	}
}