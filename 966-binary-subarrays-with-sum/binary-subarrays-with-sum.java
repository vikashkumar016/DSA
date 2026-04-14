class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0;
        int[] prefix= new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        HashMap<Integer,Integer>map= new HashMap<>();
        for(int i=0;i<prefix.length;i++){
            if(prefix[i]==goal){
                count++;
            }
            int need=prefix[i]-goal;
            if(map.containsKey(need)){
                count+=map.get(need);
            }
            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }
        return count;
    }
}