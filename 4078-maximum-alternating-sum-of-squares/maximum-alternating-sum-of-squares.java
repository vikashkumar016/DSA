class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
         int i=0;
         int j=nums.length-1;
         long max=0;
            while(i<=j){
                if(i==j){
                    long c= nums[j];
                    max+=c;
                    break;
                }
                long a =nums[j];
             max+=a;
             j--;
             long b =nums[i];
            max-=b;
             i++;
            }
    
       return max;
    }
}