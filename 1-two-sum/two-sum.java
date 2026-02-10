class Solution {
    public int[] twoSum(int[] nums, int target) {
      
        // for (int i = 0; i < nums.length; i++) {
           
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             return new int[] {i, j}; 
        //         }
        //     }
        // }
        
        // // If no solution is found, return an empty array or throw an exception
        // throw new IllegalArgumentException("No two sum solution");
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j]==target){
        //             return new int[] {i,j};
        //         }
        //     }

        // }
        //  throw new IllegalArgumentException("No two sum solution");
    HashMap<Integer,Integer>map = new HashMap<>();
    for(int i=0;i<nums.length;i++){
        int needed=target-nums[i];
        if(map.containsKey(needed)){
            return new int[] {map.get(needed),i};
        }
        map.put(nums[i],i);
    }
    return new int[]{};
    }
}
