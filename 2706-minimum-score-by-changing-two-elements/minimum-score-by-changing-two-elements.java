class Solution {
    public int minimizeSum(int[] nums) {
      int n=nums.length;
      if(n<4){
        return 0;
      }
      Arrays.sort(nums);
      int max=Integer.MAX_VALUE;
       max=Math.min(nums[n-1]-nums[2],max);
          max=Math.min(nums[n-2]-nums[1],max); 
          max=Math.min(nums[n-3]-nums[0],max);

      return max;
    }
}