class Solution {
    public int minMoves(int[] nums) {
       long min=Long.MAX_VALUE;
       for(int i=0;i<nums.length;i++){
        if(nums[i]<min){
            min=nums[i];
        }
       }
       int count=0;
       for(int i=0;i<nums.length;i++){
          long num=nums[i];
          if(num==min){
          continue;
          }
          while(num!=min){
           count+=num-min;
           break;
          }
       }
       return count;
    }
}