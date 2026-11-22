class Solution {
    public boolean checkString(String s) {
        int firstB = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                firstB = i;
                break;
            }
        }

        for (int i = firstB; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                return false;
            }
        }

        return true;
    }
}