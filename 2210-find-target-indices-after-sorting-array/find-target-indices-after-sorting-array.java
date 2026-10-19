class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
       int smaller=0;
       int equal=0;
       ArrayList<Integer>list= new ArrayList<>();
       for(int i=0;i<nums.length;i++){
        if(nums[i]<target){
            smaller++;
        }
        else if(nums[i]==target) {
         equal++;
        }
       }
       for(int i=smaller;i<smaller+equal;i++){
        list.add(i);
       }
        return list;
    }
}