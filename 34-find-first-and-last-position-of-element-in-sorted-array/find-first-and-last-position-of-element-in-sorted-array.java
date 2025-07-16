class Solution {
    public int[] searchRange(int[] nums, int target) {
        // int start=-1;
        // int end=-1;

        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==target){
        //         if(start==-1){
        //             start=i;
        //         }
        //         end=i;
        //     }
        // }
        // return new int [] {start,end};
        int left = 0;
        int right = nums.length - 1;

        int start = -1;
        int end = -1;

        // Find first occurrence from left
        while (left <= right) {
            if (nums[left] == target && start == -1) {
                start = left;
            }
            if (nums[right] == target && end == -1) {
                end = right;
            }

            if (start != -1 && end != -1) {
                break; // both found
            }

            if (start == -1) left++;
            if (end == -1) right--;
        }

        return new int[] {start, end};
    }
}