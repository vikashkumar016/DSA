class Solution {
    public long subArrayRanges(int[] nums) {
        long ans=0;
           
        for(int i=0;i<nums.length;i++){
             int min=Integer.MAX_VALUE;
             int max=Integer.MIN_VALUE;
             for(int j=i;j<nums.length;j++){
             min=Math.min(nums[j],min);
             max=Math.max(max,nums[j]);
            int range=max-min;
            ans+=range;
             }
        }
        return ans;
    }
}