class Solution {

    void getAllCombinations(int[] arr, int idx, int target,
                            List<List<Integer>> ans,
                            List<Integer> combin) {

        if (target == 0) {
            ans.add(new ArrayList<>(combin));
            return;
        }

        if (idx == arr.length || target < 0) {
            return;
        }

        // Include current element
        combin.add(arr[idx]);
        getAllCombinations(arr, idx, target - arr[idx], ans, combin);

        // Backtrack
        combin.remove(combin.size() - 1);

        // Exclude current element
        getAllCombinations(arr, idx + 1, target, ans, combin);
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combin = new ArrayList<>();

        getAllCombinations(arr, 0, target, ans, combin);

        return ans;
    }
}