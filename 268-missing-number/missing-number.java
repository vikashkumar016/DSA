class Solution {
    public int missingNumber(int[] nums) {
    //    int sum =0;
    //    int n= nums.length;
    //    for(int i=0;i<n;i++){
    //     sum+=nums[i];
    //    }
    //    int expectSum=0;
    // int n=nums.length;
    
    // for(int num=0;num<=n;num++){
    //     boolean found=false;
    //     for(int i=0;i<n;i++){
    //         if(nums[i]==num){
    //             found=true;
    //             break;
    //         }
    //     }
    //     if(!found){
    //         return num;
    //     }
    // }
    // return -1;
    int sum=0;
    for(int i=0;i<nums.length;i++){
        sum+=nums[i];
    }
    int n=nums.length;
    int expSum=n*(n+1)/2;
    return expSum-sum;

}
}