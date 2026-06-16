class Solution {
      private void backtrack(int index, int[] nums,
                           List<Integer> curr,
                           Set<List<Integer>> set) {

        if (index == nums.length) {
            set.add(new ArrayList<>(curr));
            return;
        }

        // Pick
        curr.add(nums[index]);
        backtrack(index + 1, nums, curr, set);

        // Not pick
        curr.remove(curr.size() - 1);
        backtrack(index + 1, nums, curr, set);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();
        backtrack(0, nums, new ArrayList<>(), set);

        return new ArrayList<>(set);
    }
}