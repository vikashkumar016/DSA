class Solution {
    public long maxTotalValue(int[] nums, int k) {
      long count=0;
      int max=Integer.MIN_VALUE;
      int min=Integer.MAX_VALUE;
      for(int i=0;i<nums.length;i++){
        if(nums[i]>max){
         max=nums[i];
        }
       if(nums[i]<min){
        min=nums[i];
       }
      }
      count= (long)(max-min) * k;
      return count;
    }
}