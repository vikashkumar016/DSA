class Solution {
    public int longestOnes(int[] nums, int k) {

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            int zeroCount = 0;

            for (int j = i; j < nums.length; j++) {

                if (nums[j] == 0) {
                    zeroCount++;
                }

                // valid subarray
                if (zeroCount <= k) {
                    ans = Math.max(ans, j - i + 1);
                } 
                // no need to continue further
                else {
                    break;
                }
            }
        }

        return ans;
    }
}