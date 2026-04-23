class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            if(max<candies[i]){
                max=candies[i];
            }
        }
        ArrayList<Boolean>list= new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies >=max){
                list.add(true);
            }
            else {
                list.add(false);
            }
        }
        return list;
    }
}