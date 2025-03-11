public class Heap {
    static int[] a1 = {3, 6, 2, 10, 7, 5, 9, 4, 1, 8};
    public static void main(String[] args) {
        System.out.println(a1[0]);
        buildHeap(a1);
        // print(buildHeap(a1));
    }
    public static int getParent(int index) {
        return (index-1)/2;
    }
    public static int getLeft(int index) {
        return 2*index + 1;
    }
    public static int getRight(int index) {
        return 2*index + 2;
    }
    public static boolean hasLeft(int[] array, int index) {
        return getLeft(index) < array.length;
    }
    public static boolean hasRight(int[] array, int index) {
        return getRight(index) < array.length;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static int[] trickle(int[] array) {
        for (int i = array.length-1; i >= 0; i--) {
            int current = i;
            while (hasLeft(array, current) == true) { 
                if (hasRight(array, current)) {
                    if (array[getLeft(current)] > array[current] && array[getLeft(current)] > array[getRight(current)]) {
                        swap(array, current, getLeft(current));
                        current = getLeft(current);
                    }
                    else if (array[getRight(current)] > array[current] && array[getRight(current)] > array[getLeft(current)] && hasRight(array, current)) {
                        swap(array, current, getRight(current));
                        current = getRight(current);
                    }
                    else if (array[getLeft(current)] == array[getRight(current)]) {
                        swap(array, getRight(current), getLeft(current));
                    }
                    else if (array[getLeft(current)] < array[current] && array[getRight(current)] < array[current]) {
                        break;
                    }
                }
                else if (array[getLeft(current)] > array[current]) {
                    swap(array, current, getLeft(current));
                    current = getLeft(current);
                }
                else {
                    break;
                }

            }
        }
        return array;
    }
    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }

    public static int[] buildHeap(int[] array) {
        print(array);
        return trickle(array);
    }
}
