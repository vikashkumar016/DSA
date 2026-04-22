class Solution {
    public List<Integer> findLonely(int[] nums) {
      HashMap<Integer,Integer>map= new HashMap<>();
      for(int i=0;i<nums.length;i++){
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
      } 
      ArrayList<Integer>list= new ArrayList<>();
      for(int i=0;i<nums.length;i++){
        if(map.get(nums[i])>1){
            continue;
        }
       int num = nums[i];
        int x1=num+1;
        if(map.containsKey(x1)){
         continue;
        }
        int x2=num-1;
        if(map.containsKey(x2)){
         continue;
        }
        else {
            list.add(nums[i]);
        }
      }
      return list;
    }
}