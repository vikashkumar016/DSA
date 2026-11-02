class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
     long max=0;
        if(nums.length<2){
            return 0;
        }
        for(int i=1;i<nums.length;i++){
          long a=nums[i-1];
          long b=nums[i];
           if(b-a>max){
            max=b-a;
           }
        }
        return (int)max;
    }
}