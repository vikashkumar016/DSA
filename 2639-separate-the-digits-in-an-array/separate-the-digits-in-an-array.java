class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer>arr = new ArrayList<>();
      for(int num:nums){
        String s=String.valueOf(num);
        for(char ch:s.toCharArray()){
            arr.add(ch-'0');
        }
      }
    int[] ans= new int[arr.size()];
    for(int i=0;i<arr.size();i++){
        ans[i]=arr.get(i);
    }
    return ans;
    }
}