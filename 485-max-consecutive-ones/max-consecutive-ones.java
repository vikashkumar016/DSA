class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int max=0;
        int n=nums.length;
    //    if(n==1 && nums[0]==1){
    //     return 1;
    //    }
        for(int i= 0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
             
            }
            else {
                count=0;
            }
          max=Math.max(max,count);
        }
       
        return max;
    }
}