class Solution {
    public int firstUniqChar(String s) {
     int [] ch= new int[26];
     for(int i=0;i<s.length();i++){
        ch[s.charAt(i)-'a']++;
     }
     for(int i=0;i<s.length();i++){
       char c= s.charAt(i);
       if(ch[c-'a']==1){
        return i;
       }
     }
     return -1;
    }
}