class Solution {
    public boolean isAnagram(String s, String t) {
        // HashMap<Character,Integer>map = new HashMap<>(); 
        //  for(int i=0;i<s.length();i++){
        //     char ch=s.charAt(i);
        //     map.put(ch,map.getOrDefault(ch, 0)+1);
        //  }
        //  for(int i=0;i<t.length();i++){
        //     char ch=t.charAt(i);
        //     if(map.get(ch)!=null){
        //         if(map.get(ch)==1){
        //             map.remove(ch);
        //         }
        //         else {
        //              map.put(ch,map.get(ch)-1);
        //         }
        //     }
        //     else {
        //         return false;
        //     }
        //  }
        //  return map.isEmpty();
        int[] freq=new  int[26];
        if(s.length()!=t.length()){
            return false;
        }    
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
         for(int i=0;i<t.length();i++){
            freq[t.charAt(i)-'a']--;
            if(freq[t.charAt(i)-'a']<0){
                return false;
            }
         }
     return true;
    }
}