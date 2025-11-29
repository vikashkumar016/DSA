class Solution {
    public int minOperations(int[] nums, int k) {
        
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

        }
        int opr=0;
      while (sum!=0){
        if(sum % k==0){
            return opr;
        }
        else {
            opr++;
            sum--;
        }
      }
      return opr;
    }
}