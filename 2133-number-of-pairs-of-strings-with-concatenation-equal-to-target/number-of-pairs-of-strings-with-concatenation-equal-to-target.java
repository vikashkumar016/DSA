class Solution {
    public int numOfPairs(String[] nums, String target) {
         int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                String merged = nums[i] + nums[j];

                if (target.equals(merged) && i!=j) {
                    count++;
                }
            }
        }

        return count;
    }
}