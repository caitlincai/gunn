import java.util.ArrayList;

public class Heap {
    public static int[] trickle(int[] array, int lastPosition) {
        for (int i = lastPosition; i >= 0; i--) {
            int current = i;
            while (hasLeft(array, current, lastPosition) == true) {
                if (hasRight(array, current, lastPosition)) {
                    if (array[getLeft(current)] > array[current]
                            && array[getLeft(current)] >= array[getRight(current)]) {
                        swap(array, current, getLeft(current));
                        current = getLeft(current);
                    } else if (array[getRight(current)] > array[current]
                            && array[getRight(current)] > array[getLeft(current)]) {
                        swap(array, current, getRight(current));
                        current = getRight(current);
                    } else if (array[getLeft(current)] < array[current] && array[getRight(current)] < array[current]) {
                        break;
                    }
                } else if (array[getLeft(current)] > array[current]) {
                    swap(array, current, getLeft(current));
                    current = getLeft(current);
                } else {
                    break;
                }

            }
        }
        return array;
    }

    public static int[] buildHeap(int[] array) {
        return trickle(array, array.length - 1);
    }

    public static int[] sortHeap(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            trickle(array, i);
            swap(array, 0, i);
        }
        return array;
    }
}
