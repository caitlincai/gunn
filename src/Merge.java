import java.util.ArrayList;

public class Merge {
    public static ArrayList<Comparable> mergesort(ArrayList<Comparable> alist) {
		if (alist.size() < 2)
			return alist;
		else {
			return merge(mergesort(left(alist)), mergesort(right(alist)));
		}	
	}

	private static ArrayList<Comparable> merge(ArrayList<Comparable> alist1,
			ArrayList<Comparable> alist2) {
		ArrayList<Comparable> alist = new ArrayList<Comparable>();

		while (alist1.size() > 0 && alist2.size() > 0) {
			if (alist1.get(0).compareTo(alist2.get(0)) < 0) {
				alist.add(alist1.remove(0));
			} else {
				alist.add(alist2.remove(0));
			}
		}
		while (alist1.size() > 0)
			alist.add(alist1.remove(0));
		while (alist2.size() > 0)
			alist.add(alist2.remove(0));
		return alist;
	}

	public static ArrayList<Comparable> left(ArrayList<Comparable> alist) {
		ArrayList<Comparable> tmp = new ArrayList<Comparable>();
		int numElements = (int) Math.ceil(alist.size() / 2.0);

		for (int i = 0; i < numElements; i++) {
			tmp.add(alist.get(i));
		}
		return tmp;
	}

	public static ArrayList<Comparable> right(ArrayList<Comparable> alist) {
		int index = (int) Math.ceil(alist.size() / 2.0);
		int numElements = alist.size() / 2; 

		ArrayList<Comparable> tmp = new ArrayList<Comparable>();

		for (int i = 0; i < numElements; i++) {
			tmp.add(alist.get(index + i));
		}
		return tmp;
	}
}
