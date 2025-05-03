public class Randp {
    private int[] nums;
    private int numsLeft;

    public Randp(int n) {
        initNums(n);
    }

    // Put the numbers 1..n into the array
    public void initNums(int n) {
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        numsLeft = n;
    }

    public int nextInt() {
        // If there are no numbers left, just return 0
        if (numsLeft == 0) return 0;

        // Get a random index amongst the remaining numbers
        int index = (int) (numsLeft * Math.random());

        // The number of numbers left is decreased and numsLeft now
        // references the last index in the array in which a unique value
        // can be returned
        numsLeft--;

        // Save the return value
        int temp = nums[index];

        // Overwrite the element in position index with the
        // element in the last position containing a number
        // that has yet to be returned
        nums[index] = nums[numsLeft];

        // Return the selected value
        return temp;
    }
}