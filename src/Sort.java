public class Sort {
    static int[] array = { 3, 6, 1, 5, 2, 4 };
    static int[] array2 = { 6, 5, 4, 3, 2, 1 };
    static int[] array3 = { 7, 12, 9, 2, 3, 11, 1, 8, 6, 10, 13, 5, 4 };

    static double quicksort(int[] a) {
        int n = a.length;
        if (n % 2 == 1) { // if array length is odd
            return quick(a, 0, n - 1, n / 2); // find middle element
        } else {
            int leftMid = quick(a, 0, n - 1, n / 2 - 1);
            int rightMid = quick(a, 0, n - 1, n / 2);
            return (leftMid + rightMid) / 2.0; // Even length, average of two middle values
        }
    }

    static int quick(int[] a, int left, int right, int k) {
        if (left == right) return a[left]; // Base case

        int pivotPos = partition(a, left, right);
        
        if (pivotPos == k) {
            return a[pivotPos]; // Found the k-th smallest element
        } else if (pivotPos > k) {
            return quick(a, left, pivotPos - 1, k); // Search left side
        } else {
            return quick(a, pivotPos + 1, right, k); // Search right side
        }
    }
    
        
    static int partition(int[] a, int left, int right) {
        int splitPos = left;
        for (int i = left; i < right; i++) {
            if (a[i] < a[right]) {
                swap(a, i, splitPos);
                splitPos++;
            }
        }
        swap(a,splitPos,right);
        return splitPos;
    }
    
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
        
        public static void main(String[] args) {
            System.out.println(quicksort(array)); // 3.5
            System.out.println(quicksort(array2)); // 3.5
            System.out.println(quicksort(array3)); // 7
    }
}