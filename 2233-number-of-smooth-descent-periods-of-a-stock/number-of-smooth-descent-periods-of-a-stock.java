class Solution {
    public long getDescentPeriods(int[] prices) {
        //   int n = prices.length;
        // long count = 0;

        // for (int i = 0; i < n; i++) {
        //     count++; // single day period

        //     for (int j = i + 1; j < n; j++) {
        //         if (prices[j - 1] - prices[j] == 1) {
        //             count++;   // valid smooth descent
        //         } else {
        //             break;     // break when rule fails
        //         }
        //     }
        // }
        // return count;
         long ans = 0;
        long len = 1;  // current smooth descent length

        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i - 1] - prices[i] == 1) {
                len++;          // extend descent
            } else {
                len = 1;        // reset descent
            }
            ans += len;         // add periods ending at i
        }

        return ans;
    }
}