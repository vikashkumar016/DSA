class Solution {
         public void  reverse(int[] nums,int left, int right){
         while(left<right){
            int temp = nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
         }
    }
    public void rotate(int[] nums, int k) {
        
        int n =nums.length;
        k=k%n;
        reverse(nums,0,n-1); // reverse whole array 
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        // int n=nums.length;
        // k=k%n;
        // int temp[]= new int[n];
        // for(int i=0;i<k;i++){
        // temp[i]=nums[n-k+i];
        // }
        // for(int i=0;i<n-k;i++){
        //     temp[k+i]=nums[i];
        // }
        // for(int i=0;i<n;i++){
        //     nums[i]=temp[i];
        // 

    }
   
}