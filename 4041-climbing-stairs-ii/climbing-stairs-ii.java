class Solution {
    public int climbStairs(int n, int[] costs) {
     int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            dp[i] = Integer.MAX_VALUE;

            // Jump 1 step
            if (i >= 1) {
                int cost = dp[i - 1] + costs[i - 1] + 1;
                dp[i] = Math.min(dp[i], cost);
            }

            // Jump 2 steps
            if (i >= 2) {
                int cost = dp[i - 2] + costs[i - 1] + 4;
                dp[i] = Math.min(dp[i], cost);
            }

            // Jump 3 steps
            if (i >= 3) {
                int cost = dp[i - 3] + costs[i - 1] + 9;
                dp[i] = Math.min(dp[i], cost);
            }
        }

        return dp[n];
    }
}