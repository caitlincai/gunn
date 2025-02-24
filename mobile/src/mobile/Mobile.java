package mobile;

public class Mobile extends Structure {
	private Branch left;
	private Branch right;

	public Mobile(Branch left, Branch right) {
		this.left = left;
		this.right = right;
	}
	
	public Branch getLeft() { return left;}
	public Branch getRight() { return right;}

	public double getWeight() {
		return getLeft().branchWeight() + getRight().branchWeight();
	}
	
	public boolean isBalanced() {
		return (getLeft().torque() == getRight().torque()) &&
				getLeft().getStructure().isBalanced() &&
				getRight().getStructure().isBalanced();
	}
}