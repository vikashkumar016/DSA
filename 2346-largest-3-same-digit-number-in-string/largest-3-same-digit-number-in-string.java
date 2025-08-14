class Solution {
    public String largestGoodInteger(String num) {
         String maxGoodInteger = "";
        
        // Iterate through the string, checking substrings of length 3
        for (int i = 0; i < num.length() - 2; i++) {
            // Get the current 3-character substring
            String sub = num.substring(i, i + 3);
            
            // Check if all characters in the substring are the same
            if (sub.charAt(0) == sub.charAt(1) && sub.charAt(1) == sub.charAt(2)) {
                // Update the maxGoodInteger if we find a larger one
                if (sub.compareTo(maxGoodInteger) > 0) {
                    maxGoodInteger = sub;
                }
            }
        }
        
        return maxGoodInteger;

    }
}