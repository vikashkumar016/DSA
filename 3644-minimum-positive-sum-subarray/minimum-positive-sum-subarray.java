class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int sum=Integer.MAX_VALUE;
        int max=Math.max(l,r);
        int min=Math.min(r,l);

        for(int i=0;i<nums.size();i++){
            int curr=0;
        for(int j=i;j<nums.size();j++){
            curr+=nums.get(j);
              int count = j - i + 1;
            if((count >= min && count <= max) && curr>0){
                    sum=Math.min(curr,sum);
            }
           
        }
        }
        if(sum==Integer.MAX_VALUE ){
            sum=-1;
        }
        return sum;
    }
}