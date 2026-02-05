class Solution {
    public int[] constructTransformedArray(int[] nums) {
        /*
| Part          | Purpose               |
| ------------- | --------------------- |
| `i + nums[i]` | actual movement       |
| `% n`         | circular wrap         |
| `+ n`         | fixes negative modulo |
| `% n`         | final valid index     |



        */
//         int[] result = new int[nums.length];
//         int n = nums.length;
//          for(int i=0;i<nums.length;i++){
//             if(nums[i]>0){
//                 int idx = (i+nums[i])%n;
//                 result[i]=nums[idx];
//             }
//             else if(nums[i]<0){
//                 int step=Math.abs(nums[i]);
//                 int idx =i-step;
//                 if(idx<0){
//                     idx=(idx%n+n)%n;
//                 }
//                 result[i]=nums[idx];
//             }
//             else {
//                 result[i]=nums[i];
//             }
//          }
//    return result;

//optimised code 
     int[] result = new int[nums.length];
         int n = nums.length;

   for(int i=0;i<n;i++){
    int idx = ((i + nums[i]) % n + n) % n;
    result[i]=nums[idx];
   }
   return result;
    }
}