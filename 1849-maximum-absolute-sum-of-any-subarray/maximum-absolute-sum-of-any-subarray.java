class Solution {
    public int maxAbsoluteSum(int[] nums) {
      int currMin =0;
      int currMax=0;
         int maxSum = 0;
        int minSum = 0;
      for(int num:nums){
        currMax=Math.max(num,currMax+num);
        maxSum=Math.max(currMax,maxSum);

        currMin=Math.min(num,currMin+num);
        minSum= Math.min(currMin,minSum);

      }
              return Math.max(Math.abs(maxSum), Math.abs(minSum));

    }
}