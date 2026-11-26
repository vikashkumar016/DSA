class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink=numBottles;
        int empty=drink;
        while(empty>=numExchange){
            int newBottle=empty/numExchange;
            int left=empty%numExchange;
             drink+=newBottle;
             empty=left+newBottle;
        }
        return drink;
    }
}