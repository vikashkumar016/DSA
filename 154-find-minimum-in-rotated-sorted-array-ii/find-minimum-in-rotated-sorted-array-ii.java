class Solution {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        int min=nums[0];
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
        }
     return min;
    }
}