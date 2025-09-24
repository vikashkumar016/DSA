class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
     // If numerator is 0, return "0"
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Handle negative signs
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Work with absolute values to simplify the division
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part of the fraction
        result.append(num / den);
        
        // If there's no remainder, return the integer part as result
        long remainder = num % den;
        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");  // Add the decimal point

        // Map to store remainders and their corresponding positions in the result
        Map<Long, Integer> map = new HashMap<>();

        // Perform long division to get the decimal part
        while (remainder != 0) {
            // If the remainder repeats, insert parentheses around the repeating part
            if (map.containsKey(remainder)) {
                result.insert(map.get(remainder), "(");
                result.append(")");
                return result.toString();
            }

            // Store the remainder and its corresponding position in the result
            map.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / den);
            remainder = remainder % den;
        }

        return result.toString();
        
    }
}