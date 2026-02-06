class Solution {
    public boolean rotateString(String s, String goal) {
        if (s == null || goal == null) return false;
        if (s.length() != goal.length()) return false;

        int n = s.length();

        for (int k = 0; k < n; k++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(k));
            sb.append(s.substring(0, k));

            if (sb.toString().equals(goal)) {
                return true;
            }
        }
        return false;
    }
}