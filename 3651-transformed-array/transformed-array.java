class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;
         for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                int idx = (i+nums[i])%n;
                result[i]=nums[idx];
            }
            else if(nums[i]<0){
                int step=Math.abs(nums[i]);
                int idx =i-step;
                if(idx<0){
                    idx=(idx%n+n)%n;
                }
                result[i]=nums[idx];
            }
            else {
                result[i]=nums[i];
            }
         }
   return result;
    }
}