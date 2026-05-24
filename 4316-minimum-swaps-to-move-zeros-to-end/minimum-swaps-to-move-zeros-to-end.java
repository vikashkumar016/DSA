class Solution {
    public int minimumSwaps(int[] nums) {
     int zero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }
        }
        int n= nums.length;
        int swap=0;
        for(int i=n-zero;i<nums.length;i++){
            if(nums[i]!=0){
                swap++;
            }
        }
        return swap; 
        
    }
}