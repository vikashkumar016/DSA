class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
       for (int i = 0; i + 2 * k - 1 < nums.size(); i++) {
            // Check if the first subarray is strictly increasing
            if (isStrictlyIncreasing(nums, i, k)) {
                // Check if the second subarray is strictly increasing
                if (isStrictlyIncreasing(nums, i + k, k)) {
                    return true; // Both subarrays are strictly increasing, return true
                }
            }
        }

        return false; // No adjacent strictly increasing subarrays found

    }
    private boolean isStrictlyIncreasing(List<Integer> nums, int start, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false; // If it's not strictly increasing, return false
            }
        }
        return true; // Subarray is strictly increasing
    }

}