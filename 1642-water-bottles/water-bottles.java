class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrinks = numBottles;  // Start by drinking all full bottles
        int emptyBottles = numBottles; // Initially, all full bottles become empty after drinking
        
        // While we can exchange empty bottles for full ones
        while (emptyBottles >= numExchange) {
            // Exchange empty bottles for new full bottles
            int newFullBottles = emptyBottles / numExchange;
            totalDrinks += newFullBottles;
            
            // Update the number of empty bottles
            emptyBottles = emptyBottles % numExchange + newFullBottles;
        }
        
        return totalDrinks;
    }
}