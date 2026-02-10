class Solution {
    public int romanToInt(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = value(s.charAt(i));
            // Check if there is a next character and if its value is greater than the current
            if (i + 1 < s.length() && value(s.charAt(i + 1)) > curr) {
                // If the next character is greater, subtract the current value
                total -= curr;
            } else {
                // Otherwise, add the current value
                total += curr;
            }
        }
        return total;
    }

    public int value(char c) {
        if (c == 'I') {
            return 1;
        }
        if (c == 'V') {
            return 5;
        }
        if (c == 'X') {
            return 10;
        }
        if (c == 'L') {
            return 50;
        }
        if (c == 'C') {
            return 100;
        }
        if (c == 'D') {
            return 500;
        }
        if (c == 'M') {
            return 1000;
        }
        return 0; // Return 0 or throw an error for invalid characters
    }
}