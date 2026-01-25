class Solution {
    public int maxProfit(int[] prices) {

      int maxProfit=0;
      int bestBuy=Integer.MAX_VALUE;
      if(prices.length <2){
        return 0;
      }

      for(int i=0;i<prices.length;i++){
           if(prices[i]<bestBuy){
            bestBuy=prices[i];
           }
           else {
            int profit=prices[i]-bestBuy;
            maxProfit=Math.max(profit,maxProfit);
           }
      }
      return maxProfit;
}
}