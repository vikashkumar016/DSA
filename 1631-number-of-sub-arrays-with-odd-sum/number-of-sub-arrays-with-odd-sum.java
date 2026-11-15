class Solution {
    public int numOfSubarrays(int[] arr) {

        int mod = 1000000007;
        int count = 0;

        int prefixSum = 0;
        int evenCount = 1;
        int oddCount = 0;

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            if (prefixSum % 2!=0) {

                // Update count using which variable?
                count=(count+evenCount)%mod;
                oddCount++;

                // Increase which frequency?

            } else {

                // Update count using which variable?
                count=(count+oddCount)%mod;
                evenCount++;

                // Increase which frequency?

            }
        }

        return count;
    }
}