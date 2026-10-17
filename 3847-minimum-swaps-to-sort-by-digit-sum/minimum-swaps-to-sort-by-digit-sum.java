import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // Step 1: Calculate digit sums
        int[] digit = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            while (num > 0) {
                digit[i] += num % 10;
                num /= 10;
            }
        }

        // Step 2: Store number, digit sum, original index
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = digit[i];
            arr[i][2] = i;
        }

        // Step 3: Sort by digit sum, then by number
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // Step 4: Count swaps using cycle detection
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {

            // Already visited or already in correct position
            if (visited[i] || arr[i][2] == i) {
                continue;
            }

            int cycleLength = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;

                // Move to the element's original index
                j = arr[j][2];

                cycleLength++;
            }

            if (cycleLength > 1) {
                swaps += cycleLength - 1;
            }
        }

        return swaps;
    }
}