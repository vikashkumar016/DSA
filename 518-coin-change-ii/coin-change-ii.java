class Solution {
    public int change(int amount, int[] coins) {
       int n=coins.length;
       int[][] dp= new int[n+1][amount+1];
          for(int i=0;i<=n;i++){
            dp[i][0]=1;
          }
            for(int i=1;i<=amount;i++){
            dp[0][i]=0;
          }
          for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int coin=coins[i-1];
                if(coin<=j){ //valid
                    int ans1=dp[i][j-coin]; //incldude
                    int ans2=dp[i-1][j];//exclude
                    dp[i][j]=ans1+ans2;
                }
                else {
                    dp[i][j]=dp[i-1][j];
                }
            }
           
          }
           return dp[n][amount];
    }
}