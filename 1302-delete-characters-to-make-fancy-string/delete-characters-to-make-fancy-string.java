class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1; // count of consecutive characters

        for (int i = 0; i < s.length(); i++) {
            // If current char is same as previous
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            // If count is <= 2, append it
            if (count <= 2) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}