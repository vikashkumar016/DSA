class Solution {
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
    public String longestPalindrome(String s) {
    String result="";
     for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                
                String sub = s.substring(i, j + 1);

                if (isPalindrome(sub)) {
                    if (sub.length() > result.length()) {
                        result = sub;
                    }
                }
            }
        }

        return result;
    }
}