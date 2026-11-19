class Solution {
    public int minimumDifference(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        Arrays.sort(nums);
        int n=nums.length;
        if(n<2){
            return 0;
        }
       for (int i = k - 1; i < n; i++) {
    int left = i - k + 1;

    min = Math.min(nums[i] - nums[left], min);
 }
       return min;
    }
}