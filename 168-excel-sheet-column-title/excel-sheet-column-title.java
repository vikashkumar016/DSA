class Solution {
    public String convertToTitle(int columnNumber) {
         StringBuilder result = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--;  // Adjust for 1-based indexing (A=1, B=2, ..., Z=26)
            result.append((char) (columnNumber % 26 + 'A'));  // Get the corresponding letter
            columnNumber /= 26;  // Move to the next "digit"
        }
        
        return result.reverse().toString();  // Reverse the result since we built it from least significant to most
    }
}