class Solution {
    // Helper function to check if a number is numerically balanced
    private boolean isBeautiful(int num) {
        String s = Integer.toString(num);
        int[] freq = new int[10];
        
        // Count frequency of each digit
        for (char c : s.toCharArray()) {
            freq[c - '0']++;
        }
        
        // Check if each digit occurs exactly digit times
        for (char c : s.toCharArray()) {
            int digit = c - '0';
            if (freq[digit] != digit) {
                return false;
            }
        }
        
        return true;
    }
    
    // Main function to find next numerically balanced number
    public int nextBeautifulNumber(int n) {
        int num = n + 1;
        while (true) {
            if (isBeautiful(num)) {
                return num; // Return first numerically balanced number greater than n
            }
            num++;
        }
    }
}
