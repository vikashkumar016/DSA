class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
     int[] result = new int[nums1.length];
      Stack<Integer>stack = new Stack<>();
      HashMap<Integer,Integer>map= new HashMap<>();
      for(int num:nums2){
        while(!stack.isEmpty() && num>stack.peek()){
            map.put(stack.pop(),num);
        }
        stack.push(num);
      } 
      for(int i=0;i<nums1.length;i++){
        result[i]=map.getOrDefault(nums1[i],-1);
      }
      return result;
    }
}