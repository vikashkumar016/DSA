class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        // Try every index that is zero
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) continue;
            
            // Try both directions: -1 for left, +1 for right
            if (simulate(nums, i, 1)) count++;
            if (simulate(nums, i, -1)) count++;
        }
        
        return count;
    }
      private boolean simulate(int[] nums, int start, int direction) {
        int n = nums.length;
        int[] arr = nums.clone(); // clone to avoid modifying original array
        int curr = start;
        int dir = direction;
        
        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += dir;
            } else {
                arr[curr]--;
                dir = -dir; // reverse direction
                curr += dir;
            }
        }
        
        // Check if all elements are zero
        for (int num : arr) {
            if (num != 0) return false;
        }
        return true;
    }
}