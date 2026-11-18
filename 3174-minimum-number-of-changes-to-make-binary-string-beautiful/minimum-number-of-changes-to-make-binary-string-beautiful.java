class Solution {
    public int minChanges(String s) {
        int count=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)!=s.charAt(i+1)){
                count++;
                if(i+1+1<s.length()){
                    i++;
                }
            }
            else {
                     i++;
            }
        }
       return count;
    }
}