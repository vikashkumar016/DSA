class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int idx;
        if(n%2==0){
            idx=((n/2)-1 +n/2)/2;
        }
        else {
            idx=n/2;
        }
        
        long mid=nums[idx];
        int moves=0;
        for(int i:nums){
            moves+=Math.abs(i-mid);
    }
    return moves;
    }
}