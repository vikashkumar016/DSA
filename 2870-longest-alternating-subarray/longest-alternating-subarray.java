class Solution {
    public int alternatingSubarray(int[] nums) {
        int max = -1;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i + 1] == nums[i] + 1) {

                int count = 2;

                for (int j = i + 2; j < nums.length; j++) {

                    int expected;

                    if ((j - i) % 2 == 0) {
                        expected = nums[i];
                    } else {
                        expected = nums[i] + 1;
                    }

                    if (nums[j] == expected) {
                        count++;
                    } else {
                        break;
                    }
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}