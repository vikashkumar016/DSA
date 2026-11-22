class Solution {
    public String firstPalindrome(String[] words) {
        String ans="";
        for(String str:words ){
        String s=str;
        int i=0;
        int j=s.length()-1;
        boolean isPal=true;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else {
                isPal=false;
                break;
            }
        }
        if(isPal){
       return s;
        }
        }
        return "";
    }
}