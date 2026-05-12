class Solution {
    public int longestOnes(int[] nums, int k) {
     int ans=0;
     int i=0;
     int j=-1; //j+1 to i-1 window
     int coziw=0;
     while(i<nums.length){
        //acquire
       if(nums[i]==0){
     coziw++;
     i++;
       }
       else {
        i++;
       }
        //if invalid releawsed until you are valid again
       while(coziw>k){
        j++;
        if(nums[j]==0){
            coziw--;
        }
        else {

        }
       }
       int sow=i-1-j;
       ans = Math.max(ans,sow);
     }
         return ans;
    }
}