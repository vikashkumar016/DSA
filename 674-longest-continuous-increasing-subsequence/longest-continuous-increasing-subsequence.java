class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int inc=1;
        int ans=1;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if( i+1<n){
                if(nums[i+1]>nums[i] ){
                inc++;
                }
                else {
                      ans=Math.max(ans,inc);
                inc=1;
                }
            }
            else {
         ans=Math.max(ans,inc);
                inc=1;
            }
           ans=Math.max(ans,inc);
        }
       
        return ans;
    }
}