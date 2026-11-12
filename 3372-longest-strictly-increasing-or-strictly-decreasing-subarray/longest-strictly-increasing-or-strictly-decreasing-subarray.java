class Solution {
    public int longestMonotonicSubarray(int[] nums) {
         int len = 1;
        int count = 1;
        int countDec = 1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1]) {
               count++;
               countDec=1;
             
            }
            else if (nums[i] < nums[i - 1]) {
                countDec++;
                count=1;
              
            }
            else {
                count=1;
                countDec=1;
            }
            len=Math.max(len,count);
             len=Math.max(len,countDec);
            
        }
        return len;
    }
}