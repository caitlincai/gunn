import java.util.ArrayList;

public class BST<T extends Comparable<T>> {
	private T datum;
	private BST<T> left; 
	private BST<T> right;  
    private ArrayList<Integer> depth = new ArrayList<Integer>();

	public BST(T datum) {
		this.datum = datum;
		left = null;
		right = null;
	}

	public T getDatum() {
		return datum;  // returns the datum of a node
	}
	public BST<T> getLeft() {
		return left;   // returns the left subtree
	}
	public BST<T> getRight() {
		return right;  // returns the right subtree
	}
	
	public void setLeft(BST<T> tree) {
		left = tree;
	}

	public void setRight(BST<T> tree) {
		right = tree;
	}

    public void setDatum(T datum) {
		this.datum = datum;
	}
	
	public void insert(T datum) {
        if (datum.compareTo(getDatum()) < 0) {
            if (getLeft() == null) {
                setLeft(new BST<T>(datum));
            } else {
                left.insert(datum);
            }
        }
        if (datum.compareTo(getDatum()) > 0) {
            if (getRight() == null) {
                setRight(new BST<T>(datum));
            } else {
                right.insert(datum);
            }
        }
	}
	
    public int depth() {
        if (getLeft() == null && getRight() == null) {
            return 1;
        }
        if (getLeft() != null && getRight() != null) {
            if (left.depth() > right.depth()) {
                return 1 + left.depth();
            }
            else {
                return 1 + right.depth();
            }
        }
        if (getLeft() != null) {
            return 1 + left.depth();
        }
        if (getRight() != null) {
            return 1 + right.depth();
        }
        return 0;
    }

	public String toString() {
        String s = "" + datum + ", ";
		if (left != null)
			s = left.toString() + s;
		if (right != null)
			s = s + right.toString();
		return s;
	}
}