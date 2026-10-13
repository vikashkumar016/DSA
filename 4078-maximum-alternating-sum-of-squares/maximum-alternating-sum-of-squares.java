class Solution {
    public long maxAlternatingSum(int[] nums) {
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i]*nums[i];
        }
        Arrays.sort(arr);
         int i=0;
         int j=nums.length-1;
         long max=0;
            while(i<=j){
                if(i==j){
                    long c= arr[j];
                    max+=c;
                    break;
                }
                long a =arr[j];
             max+=a;
             j--;
             long b =arr[i];
            max-=b;
             i++;
            }
    
       return max;
    }
}