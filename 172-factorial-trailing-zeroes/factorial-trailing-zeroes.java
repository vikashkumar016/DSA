class Solution {
    public int trailingZeroes(int n) {
         int count = 0;
        
        // Count the number of multiples of 5, 25, 125, etc.
        while (n >= 5) {
            n /= 5;  // Divide n by 5 and add to the count
            count += n;  // Add the result to count
        }
        
        return count;
    }
}