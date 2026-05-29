class Solution {
    public int minElement(int[] nums) {
     ArrayList<Integer>list= new ArrayList<>();

      for(int i:nums){
        int num=i;
        int sum=0;
         while(num>0){
            sum+=num%10;
            num/=10;
         }
         list.add(sum);
     }   
    return  Collections.min(list);
    }
}