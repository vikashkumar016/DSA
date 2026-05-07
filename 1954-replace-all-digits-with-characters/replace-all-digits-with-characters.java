class Solution {
    public String replaceDigits(String s) {
      String ans = "";

        for (int i = 0; i < s.length(); i++) {

            // even index -> letter
            if (i % 2 == 0) {
                ans += s.charAt(i);
            }

            // odd index -> digit
            else {

                char prev = s.charAt(i - 1);

                int shift = s.charAt(i) - '0';

                char newChar = (char)(prev + shift);

                ans += newChar;
            }
        }

        return ans;
    }
}