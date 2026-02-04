class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //  Map<Integer, Integer> map = new HashMap<>();

        // for (int i = 0; i < nums.length; i++) {
        //     if (map.containsKey(nums[i])) {
        //         int lastIndex = map.get(nums[i]);
        //         if (i - lastIndex <= k) {
        //             return true;
        //         }
        //     }
        //     map.put(nums[i], i);
        // }

        // return false;
        if (k == 0) return false;
        
        for (int i = 0; i < nums.length; i++) {
            // Check only the next k elements (from i+1 to i+k)
            for (int j =   i+1; j <= i + k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;  
                }
            }
        }
        
        return false;


    }
}