class Solution {
    public String shiftingLetters(String s, int[][] shifts) {

        char[] arr = s.toCharArray();
        int n = s.length();

        int[] diff = new int[n + 1];

        // range updates
        for (int i = 0; i < shifts.length; i++) {

            int start = shifts[i][0];
            int end = shifts[i][1];
            int shift = shifts[i][2];

            if (shift == 1) {

                diff[start] += 1;
                diff[end + 1] -= 1;

            } else {

                diff[start] -= 1;
                diff[end + 1] += 1;
            }
        }

        // prefix sum
        for (int i = 1; i < n; i++) {

            diff[i] += diff[i - 1];
        }

        // apply shifts
        for (int i = 0; i < n; i++) {

            int newShift = diff[i] % 26;

            arr[i] = (char) (
                    (arr[i] - 'a' + newShift + 26) % 26 + 'a'
            );
        }

        return new String(arr);
    }
}