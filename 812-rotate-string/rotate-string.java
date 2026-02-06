class Solution {
    public boolean rotateString(String s, String goal) {
        // if (s == null || goal == null) return false;
        // if (s.length() != goal.length()) return false;

        // int n = s.length();

        // for (int k = 0; k < n; k++) {
        //     StringBuilder sb = new StringBuilder();
        //     sb.append(s.substring(k));
        //     sb.append(s.substring(0, k));

        //     if (sb.toString().equals(goal)) {
        //         return true;
        //     }
        // }
        // return false;
        if (s == null || goal == null) return false;
        if (s.length() != goal.length()) return false;

        int n = s.length();

        // try all possible rotations
        for (int k = 0; k < n; k++) {

            boolean match = true;

            for (int i = 0; i < n; i++) {
                if (s.charAt((i + k) % n) != goal.charAt(i)) {
                    match = false;
                    break;
                }
            }

            if (match) return true;
        }

        return false;
    }
}