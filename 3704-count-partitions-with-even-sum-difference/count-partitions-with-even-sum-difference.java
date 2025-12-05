class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;

        // Step 1: Find total sum
        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }

        // Step 2: Try every partition
        int leftSum = 0;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            int rightSum = totalSum - leftSum;

            // Check if difference is even
            if ((leftSum % 2) == (rightSum % 2)) {
                count++;
            }
        }

        return count;
    }
}