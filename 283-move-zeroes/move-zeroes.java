class Solution {
    public void moveZeroes(int[] nums) {
    //   int j = 0; // Pointer to place the next non-zero element
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] != 0) {
    //             // Swap current element with the element at index j 
    //             int temp = nums[i];
    //             nums[i] = nums[j];
    //             nums[j] = temp;
    //             j++;   // Move j to the next index for placing non-zero
    //         }
    //     }

     int j = 0; // position for next non-zero

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // fill remaining positions with zero
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }
}