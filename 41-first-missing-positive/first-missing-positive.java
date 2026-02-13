class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer>set = new HashSet<>();
        int n= nums.length;
        for(int num:nums){
            set.add(num);
        }
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return n+1;
    }
}