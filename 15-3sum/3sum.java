import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // int n = nums.length;
        // Set<List<Integer>> set = new HashSet<>();
        
        // // Sort the array to handle duplicates easily
        // Arrays.sort(nums);
        
        // for (int i = 0; i < n - 2; i++) {
        //     for (int j = i + 1; j < n - 1; j++) {
        //         for (int k = j + 1; k < n; k++) {
                    
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 set.add(triplet); // Set avoids duplicate triplets
        //             }
        //         }
        //     }
        // }
        
        // return new ArrayList<>(set);
        
         int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        
        Arrays.sort(nums); // helps avoid duplicate triplets
        
        for (int i = 0; i < n - 2; i++) {
            Set<Integer> seen = new HashSet<>();
            
            for (int j = i + 1; j < n; j++) {
                int complement = -nums[i] - nums[j];
                
                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(triplet); // ensure consistent order
                    result.add(triplet);
                }
                
                seen.add(nums[j]);
            }
        }
        
        return new ArrayList<>(result);

    }
}
