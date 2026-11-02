class Solution {
    public int minMergedInteger(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i+=2){
           int a=nums[i];
           int b=nums[i+1];
           int num=b;
           int count=0;
            while(num>0){
            count++;
            num/=10;
           }
           int merged=a*(int)Math.pow(10,count)+b;
           min=Math.min(min,merged);
                 }
                 return min;
    }
}