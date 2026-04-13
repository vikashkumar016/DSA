class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 0;

        // Check if all chars of b exist in a
        for (char c : b.toCharArray()) {
            if (a.indexOf(c) == -1) {
                return -1;
            }
        }

        StringBuilder repeated = new StringBuilder();

        // FIXED CONDITION
        while (repeated.length() < b.length()) {
            repeated.append(a);
            count++;
        }

        if (repeated.indexOf(b) != -1) {
            return count;
        }

        repeated.append(a);
        count++;

        if (repeated.indexOf(b) != -1) {
            return count;
        }

        return -1;
    }
}