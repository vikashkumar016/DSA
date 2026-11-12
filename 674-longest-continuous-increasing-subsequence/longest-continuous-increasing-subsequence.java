class Solution {
    public int findLengthOfLCIS(int[] nums) {
               int inc = 1;
        int ans = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1]) {
                inc++;
            } else {
                inc = 1;
            }

            ans = Math.max(ans, inc);
        }

        return ans;

    }
}