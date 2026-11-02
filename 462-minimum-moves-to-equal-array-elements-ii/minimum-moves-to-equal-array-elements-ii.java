class Solution {
    public int minMoves2(int[] nums) {
     int n=nums.length;
     Arrays.sort(nums);
     int mid=n/2;
     long mi=nums[mid];
     int count=0;
     for(int i:nums){
        count+=Math.abs(i-mi);
     }
     return count;
    }
}