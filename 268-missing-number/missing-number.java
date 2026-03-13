class Solution {
    public int missingNumber(int[] nums) {

    int n=nums.length;
    
    for(int num=0;num<=n;num++){
        boolean found=false;
        for(int i=0;i<n;i++){
            if(nums[i]==num){
                found=true;
                break;
            }
        }
        if(!found){
            return num;
        }
    }
    return -1;

}
}