public class Main {
  /*
   * I suggest that you use this code to understand the
   * mechanics of how each sort works.  To keep it simple,
   * try tracing each sort by hand on each of the following
   * arrays:
   *
   * { 3, 6, 1, 5, 2, 4 }
   * { 6, 5, 4, 3, 2, 1 }
   *
   * Try to keep track of the number of comparisons done
   * between elements in the array and the number of times
   * elements are swapped.  (Treat temp = a, a = b, b = temp
   * as one swap for simplicity.)
   *
   * For heapsort and mergesort, you may wish to try a
   * somewhat larger set of data, say:
   *
   * { 7, 12, 9, 2, 3, 11, 1, 8, 6, 10, 5, 4 }
   *
   * I have intentionally left no documentation.
   * I'd like you to be able to explain to me what happens
   * when this code executes in terms of how the state of
   * the array is altered as it goes from being unsorted to sorted.
   * Also be able to explain the order of growth as the number
   * of elements, n, gets larger.  It's easy enough to simply
   * state that bubble sort is O(n2), but I want to hear
   * your rationale for why.
   */
  private static int[] a1 = {10, 9, 8, 7, 6};
  private static int[] a2 = {5, 3, 7, 4, 8, 5};
  private static int[] a3 = {2, 9, 0, 4, 5, 7, 8};
  private static int[] a4 = {3, 6, 2, 10, 7, 5, 9, 4, 1, 8};
  private static int[] array1 = {3, 6, 1, 5, 2, 4};
  private static int[] array2 = {7, 12, 9, 2, 3, 11, 1, 8, 6, 10, 13, 5, 4};

  public static void main(String[] args) {
    insertionSort(a1);
    selectionSort(a2);
    bubbleSort(a3);
    quicksort(a4);
    mergesort(array1);
    heapsort(array2);
  }

  // BUBBLE SORT

  static void bubbleSort(int[] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a.length - i - 1; j++) { // the end should be sorted hence the - i
        if (a[j] > a[j + 1]) {
          swap(a, j, j + 1);
        }
      }
    }
    printArray(a);
  }

  // INSERTION SORT

  static void insertionSort(int[] a) {
    for (int i = 0; i < a.length; i++) {
      insert(a, i);
    }
    printArray(a);
  }

  static void insert(int[] a, int i) {
    int j;
    // find index j where a[i] should be inserted 
    for (j = 0; a[i] > a[j] && j < i; j++) {
    }
    int temp = a[i];
    for (int k = i; k > j; k--) {
      // shift everything after index j to the right by 1
      a[k] = a[k - 1];
    }
    a[j] = temp;
  }

  // SELECTION SORT

  static void selectionSort(int[] a) {
    int min, minPos;
    for (int i = 0; i < a.length; i++) {
      min = a[i];
      minPos = i;
      // everything before i is sorted
      for (int j = i; j < a.length; j++) { 
        if (a[j] < min) {
          min = a[j];
          minPos = j;
        }
      }
      swap(a, i, minPos);
    }
    printArray(a);
  }

  // QUICK SORT
  static void quicksort(int[] a) {
    quick(a, 0, a.length - 1);
    printArray(a);
  }

  static void quick(int[] a, int left, int right) {
    if (right > left) { 
      // at least 2+ elements in the array
      // if right == left, there is only 1 element in the array, if right < left indexes are messed
      int pivotPos = partition(a, left, right);
      quick(a, left, pivotPos - 1);
      quick(a, pivotPos + 1, right);
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
    swap(a, splitPos, right);
    return splitPos;
  }

  // MERGE SORT
  
  public static void mergesort(int[] arr) {
    ms(arr, 0, arr.length - 1);
    printArray(arr);
  }

  private static void ms(int[] a, int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2;
      ms(a, low, mid);
      ms(a, mid + 1, high);
      merge(a, low, mid, high);
    }
  }

  private static void merge(int[] a, int low, int mid, int high) {
    int[] b = new int[a.length];
    int i, j, k;

    for (i = low; i <= high; i++)
      b[i] = a[i];

    i = low;
    j = mid + 1;
    k = low;
    while (i <= mid && j <= high)
      if (b[i] <= b[j])
        a[k++] = b[i++];
      else
        a[k++] = b[j++];

    while (i <= mid)
      a[k++] = b[i++];
  }
  
  // HEAP SORT

  // Note the use of modular, top-down programming
  // We know that heapsort needs to build a heap and then sort it,
  // so why not write that as code and then fill in the needed methods?
  public static void heapsort(int[] a) {
    buildHeap(a);
    sortHeap(a);
    printArray(a);
  }

  // I let the other methods be private to make a point about public.
  // The only method that should be visible if you want to do heapsort
  // is the heapsort method itself.  Unless you have a reason to let
  // a method like buildheap be visible outside this class, it probably
  // should be private.  That said, the AP graders are expecting public
  // methods and private instance variables; on the actual test, use
  // public everywhere for methods unless instructed otherwise.

  // Trickle hasn't been written, but building the heap is the process
  // of going through the array, right to left, and performing trickle
  // at each place.
  private static void buildHeap(int[] a) {
    for (int i = a.length - 1; i >= 0; i--) {
      trickle(a, i, a.length);
    }
  }

  // Swap the root with the last unsorted position
  // Then trickle the new root to maintain a heap
  private static void sortHeap(int[] a) {
    for (int i = a.length - 1; i >= 0; i--) {
      swap(a, 0, i);
      trickle(a, 0, i);
    }
  }

  // The game plan:
  // * If a node has no children, done
  // * If a node has one child, check to see if a swap is needed
  // * If a node has two children, check to see which is bigger and if a swap is
  // needed
  private static void trickle(int[] a, int i, int lastPosition) {
    // max contains the bigger child datum
    // maxPos contains the place in the array where the bigger child datum is
    // contained
    int max = 0, maxPos = 0;
    if (hasChildren(i, lastPosition)) {
      if (hasOnlyLeftChild(i, lastPosition)) {
        max = a[left(i)];
        maxPos = left(i);
      } else {
        maxPos = (a[left(i)] > a[right(i)]) ? left(i) : right(i);
        max = a[maxPos];
      }
      // Now determine if a swap is warranted
      // Note that lastPosition holds the biggest array index into which
      // a datum can be trickled.  We don't want to trickle into something
      // that is already sorted!
      if (max > a[i]) {
        swap(a, i, maxPos);
        trickle(a, maxPos, lastPosition);
      }
    }
  }

  // A slew of helper functions to get the details done
  // Sometimes it is easier to identify some of these and write them
  // before writing the higher-level stuff.  Deciding what to write
  // first can be an art form.
  private static int left(int x) { return 2 * x + 1; }
  private static int right(int x) { return 2 * x + 2; }
  private static int parent(int x) { return (x - 1) / 2; }

  private static void swap(int[] arr, int i1, int i2) {
    int temp = arr[i1];
    arr[i1] = arr[i2];
    arr[i2] = temp;
  }

  private static boolean hasChildren(int index, int length) {
    // Imagine a binary number.  Shifting all of the 1s to the right
    // by a position is the same thing as dividing by two.  It also
    // behaves as integer arithmetics as if there is a one in the
    // rightmost position, it gets shifted out of existence.
    // No critical reason to do it this way, just wanted to show it.
    // return (index * 2) + 1 < (length >> 1);
    return (index * 2) + 1 < length;
  }

  private static boolean hasOnlyLeftChild(int index, int length) {
    return ((index * 2) + 2 == length);
  }

  // Pretty printing procedure for arrays of integers

  static void printArray(int[] a) {
    System.out.print("{ " + a[0]);
    for (int i = 1; i < a.length; i++) {
      System.out.print(", " + a[i]);
    }
    System.out.println(" }");
  }
}
