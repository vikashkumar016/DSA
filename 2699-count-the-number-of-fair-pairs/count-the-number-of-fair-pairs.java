class Solution {
    private long countLessThanOrEqual(int[] nums,int target){
        Arrays.sort(nums);
        long count=0;
        int i=0;
        int j=nums.length-1;
        while(i<j){
            int sum=nums[i]+nums[j];
            if(sum<=target){
                count+=j-i;
                i++;
            }
            else {
                j--;
            }
        }
        return count;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
       long a=countLessThanOrEqual(nums,upper);
       long b=countLessThanOrEqual(nums,lower-1);
       return a-b;        
    }
}