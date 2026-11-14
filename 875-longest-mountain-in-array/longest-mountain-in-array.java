class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int up = 0;
        int down = 0;
        int max = 0;

        for (int i = 1; i < n; i++) {

            if (arr[i] > arr[i - 1]) {

                if (down > 0) {
                    down=0;
                    up=0;
                }

                up++;
            }

            else if (arr[i] < arr[i - 1]) {

                if (up > 0) {
                    down++;
                }
            }

            else {
                down=0;
                up=0;
            }

            if (up > 0 && down > 0) {
                max = Math.max(max, up + down + 1);
            }
        }

        return max;
    }
}