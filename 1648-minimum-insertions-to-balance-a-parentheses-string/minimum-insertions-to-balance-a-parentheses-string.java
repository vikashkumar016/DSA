class Solution {
    public int minInsertions(String s) {
      int result = 0;
        int count = 0;
        int n = s.length();
        int i = 0;

        while (i < n) {
            char ch = s.charAt(i);

            if (ch == '(') {
                count++;
                i++;
            } else {
                // Check whether the next character is ')'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i += 2;
                } else {
                    // Insert the missing ')'
                    result++;
                    i++;
                }

                // Match this closing pair with an opening '('
                if (count > 0) {
                    count--;
                } else {
                    // Insert the missing '('
                    result++;
                }
            }
        }

        return result + count * 2;
    }
}