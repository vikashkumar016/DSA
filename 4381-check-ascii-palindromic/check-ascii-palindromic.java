class Solution {
    public boolean isPalindromic(String s) {
       StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            String binary = Integer.toBinaryString(val);
            sb.append("0".repeat(8 - binary.length()));
            sb.append(binary);
        }

        int i = 0;
        int j = sb.length() - 1;

        while (i < j) {
            if (sb.charAt(i) == sb.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}