class Solution {
    public int beautySum(String s) {
        int beauty=0;
        
        for(int i=0;i<s.length();i++){
             HashMap<Character,Integer>freq= new HashMap<>();
           for(int j=i;j<s.length();j++){
           
            char ch=s.charAt(j);
          freq.put(ch, freq.getOrDefault(ch, 0) + 1);
           int max = 0;
                int min = Integer.MAX_VALUE;

                for (int value : freq.values()) {
                    max = Math.max(max, value);
                    min = Math.min(min, value);
                }
                  beauty += (max - min);
           }
          
        }
         return beauty;
    }

}