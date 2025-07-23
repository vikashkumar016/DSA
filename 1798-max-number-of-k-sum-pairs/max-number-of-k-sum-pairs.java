class Solution {
    public int maxOperations(int[] nums, int k) {
        int li=0;
        int ri=nums.length-1;
        Arrays.sort(nums); //nlogn
        int ans=0;
        while(li<ri){
            if(nums[li]+nums[ri]<k){
                li++;
            }
            else if(nums[li]+nums[ri] >k){
                ri--;
            }
            else {
           li++;
           ri--;
           ans++;
            }
        }
        return ans;


    }
}