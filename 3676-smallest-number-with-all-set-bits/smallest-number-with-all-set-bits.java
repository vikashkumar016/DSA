class Solution {
    public int smallestNumber(int n) {
        // Step 1: If n already has all bits set
        if ((n & (n + 1)) == 0) {
            return n;
        }

        // Step 2: Find the next number with all bits set
        int x = n;
        while (true) {
            x++;
            if ((x & (x + 1)) == 0) {
                return x;
            }
        } 
    }
}