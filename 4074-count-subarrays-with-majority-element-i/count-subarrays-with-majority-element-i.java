class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count=0;
    
        for(int i=0;i<nums.length;i++){
            int len=0;
            int freq=0;
            for(int j=i;j<nums.length;j++){
                len++;
              if (nums[j] == target) {
            freq++;
        }

        if (2 * freq > len) {
            count++;
        }
            }
        }
        return count;
    }
}