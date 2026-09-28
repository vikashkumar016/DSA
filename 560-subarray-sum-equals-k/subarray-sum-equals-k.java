class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int count=0;
        int prefix=0;
        map.put(0,1);
        for(int num:nums){
            prefix+=num;
            int needed=prefix-k;
            if(map.containsKey(needed)){
                count+=map.get(needed);
            }
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }
        return count;
    }
}