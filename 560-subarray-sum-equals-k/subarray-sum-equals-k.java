class Solution {
    public int subarraySum(int[] nums, int k) {
    int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;   // reset sum for each new start

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];   // add current element

                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}