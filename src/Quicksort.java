public class Quicksort {
    static int[] array = { 3, 6, 1, 5, 2, 4, 7 };
    static int[] array2 = { 6, 5, 4, 3, 2, 1 };
    static int[] array3 = { 7, 12, 9, 2, 3, 11, 1, 8, 6, 10, 5, 4 };

    static void quicksort(int[] a) {
            quick(a, 0, a.length-1);
        }
            
        static void quick(int[] a, int left, int right) {
            double middle = a.length / 2; // 3.5
            for (int i = pivotPos+1; i < a.length; i++) {
                int pivotPos = partition(a, left, right);
                int curPos = pivotPos+1;
                for (int j = pivotPos+1; j < right; j++) {
                    if (a[i] < a[pivotPos]) {
                        swap(a, i, j);
                    }
                }
                swap(a, pivotPos, curPos);
                System.out.println(a[curPos]);
            }
            
            // if (right > left) {
            //     if (pivotPos < middle) {
            //         quick(a, pivotPos, right);
            //     }
            //     else if (pivotPos > middle) { 
            //         quick(a, left, pivotPos);
            //     }
            //     else {
            //         System.out.println(pivotPos);
            //     }
            // }
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
            quicksort(array); // 4
            // quicksort(array2); // 3.5
    }
}