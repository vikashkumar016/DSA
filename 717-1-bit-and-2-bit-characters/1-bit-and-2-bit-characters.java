class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0; // Initialize i to 0
        while (i < n - 1) { // We need to stop before the last element
            if (bits[i] == 0) {
                i++; // Move to the next element if it's a 1-bit character
            } else {
                i += 2; // Skip two elements if it's a 2-bit character (starts with 1)
            }
        }
        return i == n - 1; // Check if we are at the last element
    }
}