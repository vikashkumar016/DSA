class Solution {
    public int maxSubArray(int[] nums) {
        // int n = nums.length;
        // int max = Integer.MIN_VALUE;  // handles negative numbers

        // for (int i = 0; i < n; i++) {
        //     int sum = 0; // reset sum for each starting index
        //     for (int j = i; j < n; j++) {
        //         sum += nums[j];
        //         max = Math.max(max, sum); // update max inside inner loop
        //     }
        // }

        // return max;
         int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}