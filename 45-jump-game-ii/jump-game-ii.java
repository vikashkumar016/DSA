class Solution {
    public int jump(int[] nums) {
        int jump=0;
        int count=0;
        int n=nums.length;
        int end=0;
         for(int i = 0; i < nums.length - 1; i++) {
            
            jump = Math.max(jump, nums[i] + i);
            
            if(i == end) {
                if(jump == end) {
                    return -1; // cannot move further
                }
                count++;
                end = jump;
            }
        }
        
        return count;
    }
}