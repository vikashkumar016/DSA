class Solution {
    public int repeatedNTimes(int[] nums) {
        // HashMap<Integer,Integer>map = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     int count = map.getOrDefault(nums[i],0)+1;
        //     map.put(nums[i],count);
        //    if(count >1){
        //     return nums[i];
        //    }
        // }
        // return -1;

        for(int i=0;i<nums.length;i++){
            int count =0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count >1){
                return nums[i];
            }
        }
        return -1;
    }
}