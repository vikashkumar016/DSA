class Solution {
    public int findKthLargest(int[] nums, int k) {
           ArrayList<Integer> arr = new ArrayList<>();

        // Convert int[] to ArrayList<Integer>
        for (int num : nums) {
            arr.add(num);
        }

        // Sort in descending order
        arr.sort(Comparator.reverseOrder());

        // Return the kth largest element
        return arr.get(k - 1);

    }
}