class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Count occurrences of each number
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i]; // FIXED: you had `arr[i]`, should be `nums[i]`
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check which numbers appear more than n/3 times
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3) {
                result.add(entry.getKey()); // FIXED: you were adding the value instead of the key
            }
        }

        return result;
    }
}