class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case

        for (int num : nums) {

            // Step 1: convert odd to 1
            if (num % 2 == 1) {
                prefixSum += 1;
            }

            // Step 2: check if prefixSum - k exists
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Step 3: store prefixSum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}