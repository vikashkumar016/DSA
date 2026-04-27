class Solution {

    public boolean same(int[] freq1, int[] freq2) { // fixed parameter types
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
         int k = s1.length();
        int n = s2.length();

        if (k > n) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // build s1 freq and first window
        for (int i = 0; i < k; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if (same(freq1, freq2)) return true;

        for (int i = k; i < n; i++) {

            // add new char
            freq2[s2.charAt(i) - 'a']++;

            // remove old char
            freq2[s2.charAt(i - k) - 'a']--;

            if (same(freq1, freq2)) return true;
        }

        return false;
    }
}