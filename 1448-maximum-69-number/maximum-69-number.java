class Solution {
    public int maximum69Number (int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        // Iterate through the digits and change the first '6' to '9'
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';  // Change the first '6' to '9'
                break;  // Only change one digit, so exit the loop
            }
        }
        
        // Convert the modified array back to an integer and return it
        return Integer.parseInt(new String(digits));
    }
}