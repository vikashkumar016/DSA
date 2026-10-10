class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
      int maxDiff = 0;
        long k = (long) k1 + k2;

        for (int i = 0; i < nums1.length; i++) {
            maxDiff = Math.max(maxDiff,
                    Math.abs(nums1[i] - nums2[i]));
        }

        int[] count = new int[maxDiff + 1];

        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            count[diff]++;
        }

        // Reduce the largest differences first
        for (int d = maxDiff; d > 0 && k > 0; d--) {
            long moves = Math.min(k, count[d]);

            count[d] -= (int) moves;
            count[d - 1] += (int) moves;
            k -= moves;
        }

        // Calculate sum of squared differences
        long result = 0;

        for (int d = 1; d < count.length; d++) {
            result += (long) d * d * count[d];
        }

        return result;
}
}