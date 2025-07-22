class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        // int maxScore = 0;
        
        // // Generate all possible subarrays
        // for (int i = 0; i < nums.length; i++) {
        //     HashSet<Integer> seen = new HashSet<>();
        //     int currentSum = 0;
            
        //     for (int j = i; j < nums.length; j++) {
        //         // If the element is already in the set, break out of the loop
        //         if (seen.contains(nums[j])) {
        //             break;
        //         }
                
        //         // Add the current element to the set and update the sum
        //         seen.add(nums[j]);
        //         currentSum += nums[j];
                
        //         // Update the maximum sum
        //         maxScore = Math.max(maxScore, currentSum);
        //     }
        // }
        
        // return maxScore;
          int maxScore = 0;
        int currentSum = 0;
        int start = 0; // left pointer of the sliding window
        HashSet<Integer> seen = new HashSet<>();
        
        // Iterate through the array with the right pointer
        for (int end = 0; end < nums.length; end++) {
            // If we encounter a duplicate, shrink the window from the left
            while (seen.contains(nums[end])) {
                // Remove the element at the start of the window and move the start pointer right
                seen.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
            
            // Add the current element to the window
            seen.add(nums[end]);
            currentSum += nums[end];
            
            // Update the maximum sum encountered
            maxScore = Math.max(maxScore, currentSum);
        }
        
        return maxScore;
    }
}