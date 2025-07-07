class Solution {
    public int findMin(int[] nums) {
    //     Arrays.sort(nums);
    //     int min=nums[0];
    //     for(int i=0;i<nums.length;i++){
    //         min=Math.min(min,nums[i]);
    //     }
    //  return min;
 
       
        int low = 0 ;
        int high =  nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2 ;
            if(nums[mid]>nums[high]){
                low = mid + 1 ;
            }
            else if(nums[mid]<nums[high]){
                high = mid ;
            }
            else{
                high-- ;
            }
           
        }
        return nums[low]; 
    }
    
}
    