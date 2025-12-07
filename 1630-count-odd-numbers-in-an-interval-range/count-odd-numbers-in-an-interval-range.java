class Solution {
    public int countOdds(int low, int high) {
         int length = high - low + 1;
        int base = length / 2;

        // If both low and high are odd, add one extra odd number
        if (low % 2 == 1 && high % 2 == 1) {
            base++;
        }

        return base;
    }
}