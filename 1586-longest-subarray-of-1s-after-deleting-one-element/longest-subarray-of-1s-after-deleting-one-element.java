class Solution {
    public int longestSubarray(int[] nums) {
        ArrayList<Integer>list= new ArrayList<>();
        int count=0;
        int countZero=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }
            
            else if(nums[i]==0) {
                countZero++;
               list.add(count);
               count=0;
               if(i+1<n &&nums[i+1]==0){
                list.add(0);
               }
            }
            
        }
       if(count!=0){
         list.add(count);
       }
        System.out.println(list);
        int max=0;
        for(int i=0;i<list.size()-1;i++){
            if((list.get(i)+list.get(i+1))>max){
                max=list.get(i)+list.get(i+1);
            }
        }
       if(list.size()==1){
        if(countZero==1){
            return list.get(0);
        }
       return  list.get(0)-1;
       }
        if(countZero==0){
            return max-1;
        }
        

        return max;
    }
}