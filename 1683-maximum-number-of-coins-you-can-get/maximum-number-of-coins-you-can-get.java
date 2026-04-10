class Solution {
    public int maxCoins(int[] piles) {
       Arrays.sort(piles);
        
        int n = piles.length;
        int sum = 0;
        int index = n - 2;  // start from second largest
        
        for (int i = 0; i < n / 3; i++) {
            sum += piles[index];  // add your pick
            index -= 2;           // move to next valid pick
        }
        
        return sum;
    }
}