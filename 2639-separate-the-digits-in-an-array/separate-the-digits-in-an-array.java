class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer>arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
             ArrayList<Integer> temp = new ArrayList<>();
            while(num>0){
                int last=num%10;
                temp.add(last);
                num=num/10;
            }
            for(int j=temp.size()-1;j>=0;j--){
                arr.add(temp.get(j));
            }
        }
    int[] ans= new int[arr.size()];
    for(int i=0;i<arr.size();i++){
        ans[i]=arr.get(i);
    }
    return ans;
    }
}