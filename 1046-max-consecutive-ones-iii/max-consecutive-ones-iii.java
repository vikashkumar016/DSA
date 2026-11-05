class Solution {
    public int longestOnes(int[] nums, int k) {
 int countZero = 0;
        int max = 0;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] == 0) {
                countZero++;
            }

            while (countZero > k) {
                if (nums[i] == 0) {
                    countZero--;
                }
                i++;
            }

            max = Math.max(max, j - i + 1);
        }

        return max;
       
    }
}