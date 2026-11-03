class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int num:nums){
            max=Math.max(num,max);
        }
        int[] points= new int[max+1];
        int[] dp= new int[max+1];
        for(int num:nums){
            points[num]+=num;
        }
        dp[0]=points[0];
        if(max>=1){
            dp[1]=Math.max(points[0],points[1]);
        }
        for(int i=2;i<=max;i++){
            int take=points[i]+dp[i-2];
            int skip=dp[i-1];
            dp[i]=Math.max(take,skip);
        }
        return dp[max];
    }
}