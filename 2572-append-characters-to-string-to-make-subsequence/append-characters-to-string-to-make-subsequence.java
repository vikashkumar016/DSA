class Solution {
    public int appendCharacters(String s, String t) {

        int n=t.length();
        int j=0;
        for(int i=0;i<s.length() && j<t.length();i++){
           if(s.charAt(i)==t.charAt(j)){
            j++;
           }

        }
        return n-j;
    }
}