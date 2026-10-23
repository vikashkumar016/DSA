class Solution {
    public String[] findWords(String[] words) {
        String row1="qwertyuiop";
        String row2="asdfghjkl";
        String row3="zxcvbnm";
        ArrayList<String>list= new ArrayList<>();
        HashMap<Character,Integer>map= new HashMap<>();
        for(int i=0;i<row1.length();i++){
            map.put(row1.charAt(i),1);
        }
        for(int i=0;i<row2.length();i++){
            map.put(row2.charAt(i),2);
        }
        for(int i=0;i<row3.length();i++){
            map.put(row3.charAt(i),3);
        }
        for(int i=0;i<words.length;i++){
            String str=words[i].toLowerCase();
             int row=map.get(str.charAt(0));
             boolean valid=true;
            for(int j=0;j<str.length();j++){
                if(map.get(str.charAt(j))!=row){
                  valid=false;
                  break;
                }
            }
            if(valid){
                list.add(words[i]);
            }
        }
        String[] newStr=new String[list.size()];
        for(int i=0;i<newStr.length;i++){
            newStr[i]=list.get(i);
        }
        return newStr;
    }
}