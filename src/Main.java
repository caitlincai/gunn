public class Main {
    private static int[] array1 = {10, 9, 8, 7, 6};
    private static int[] array2 = {5, 3, 7, 4, 8, 5};
    private static int[] array3 = {2, 9, 0, 4, 5, 7, 8};
    private static int n;  

    public static void print(int[] array) {
        n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + ", ");

        }
        System.out.println();
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void bubble(int[] array) {
        n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if (array[j+1] < array[j]) {
                    swap(array, j+1, j);
            }
        }
    }
        print(array);    
    }  
    public static void insert(int[] array) {
        n = array.length;
        for (int i = 0; i < n; i++) {
            for(int j = 1; j<n; j++) {
                int x=j-1;
                while (x >= 0) {
                    if(array[j] < array[x]) {
                        swap(array, j, x);
                        x--;
                    }
                    x=-1;
            }
            
        }
    }
            print(array);    
    }
    public static void select(int[] array) {
        n = array.length;
        for (int i = 0; i < n; i++) {
            int min = array[i];
            for (int j = i+1; j < n; j++) {
                if (array[j] < min) {
                    min = array[j];
                    swap(array, i, j);
                }
            }
        }
        print(array);
    }       

    // public static void main(String[] args) throws Exception {
    //     bubble(array1);
    //     insert(array2);
    //     select(array3);
        
    // }
}
