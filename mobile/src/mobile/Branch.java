package mobile;

public class Branch {
	private double length;
	private Structure struct;
	
	public Branch(double length, Structure struct) {
		this.length = length;
		this.struct = struct;
	}
	
	public double getLength() {
		return length;
	}
	
	public Structure getStructure() {
		return struct;
	}
	
	public double branchWeight() {
		Structure s = getStructure();
		return s.getWeight();
	}
	
	public double torque() {
		return getLength() * branchWeight();
	}
}