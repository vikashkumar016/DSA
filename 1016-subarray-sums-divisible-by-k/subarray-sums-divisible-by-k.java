class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // important

        for (int i = 0; i < prefix.length; i++) {

            int rem = prefix[i] % k;
            if (rem < 0) rem += k;

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}