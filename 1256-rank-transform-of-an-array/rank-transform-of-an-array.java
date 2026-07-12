class Solution {
    public int[] arrayRankTransform(int[] arr) {
         int[] nums = arr.clone();   // Copy array

        Arrays.sort(nums);          // Sort copy

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}