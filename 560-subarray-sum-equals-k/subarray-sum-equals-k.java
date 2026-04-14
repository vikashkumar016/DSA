class Solution {
    public int subarraySum(int[] nums, int k) {
    
        int count = 0;
        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(prefix[i]==k){
                count++;
            }
           int need = prefix[i]-k;
           if(map.containsKey(need)){
            count+=map.get(need);
           }
           map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }
        return count;
    }
}


// Main running sum maintain karta hu
// Har step pe check karta hu ki currentSum - k pehle aaya hai ya nahi
// Agar aaya hai toh utni baar subarray milta ha