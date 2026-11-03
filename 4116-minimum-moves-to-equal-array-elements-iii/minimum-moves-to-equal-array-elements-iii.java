class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int count=0;
        for(int num:nums){
            count+=Math.abs(num-max);
        }
        return count;
    }
}