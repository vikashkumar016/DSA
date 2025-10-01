class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = 0;
        int remain = 0;
        int store;
        while (numBottles > 0){
            count += numBottles;
            store = numBottles;
            numBottles = (int) ((numBottles + remain) / numExchange);
            remain += store - (numBottles * numExchange);
            System.out.println(store);
            System.out.println(numBottles);
            System.out.println(remain);
        }
    return count;
}
}