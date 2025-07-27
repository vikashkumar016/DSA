class Solution {
    public int countHillValley(int[] nums) {
    //     int countHill=0;
    //     int left=0;
    //     int valley=0;
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i+1]>nums[left] && nums[i+1]>nums[i+2]){
    //             countHill++;
    //         }
    //         else if(nums[i+1]<nums[left] && nums[i+1]<nums[i+2]){
    //             valley++;
    //         }
    //         left++;
    //     } 
    //    return Math.max(valley,countHill);
     int count = 0;

    for (int i = 1; i < nums.length - 1; i++) {
        // Skip duplicates in between
        if (nums[i] == nums[i - 1]) continue;

        // Move j forward to skip next duplicates
        int j = i + 1;
        while (j < nums.length && nums[j] == nums[i]) {
            j++;
        }

        if (j < nums.length) {
            if ((nums[i] > nums[i - 1] && nums[i] > nums[j]) || 
                (nums[i] < nums[i - 1] && nums[i] < nums[j])) {
                count++;
            }
        }

        i = j - 1;  // Move i forward past duplicates
    }

    return count;
    }
}