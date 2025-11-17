class Solution {
    public boolean kLengthApart(int[] nums, int k) {
     int  count =0;
    //  int max=0;
    //  for(int i=0;i<nums.length;i++){
    //     if(nums[i]==0 || count >=k){
    //         count++;

    //     }
    //     else {
    //         return false;
    //     }
    //  }
    //  return true;
     int prev = -1; // previous index of 1
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prev != -1 && i - prev - 1 < k) {
                    return false;
                }
                prev = i; // update previous 1 index
            }
        } 
        return true;
    }
}