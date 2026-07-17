class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder concat = new StringBuilder();
        int i = 0, j = 0;
        
        while (i < word1.length() && j < word2.length()) {
            concat.append(word1.charAt(i));
            concat.append(word2.charAt(j));
            i++;
            j++;
        }
        
        while (i < word1.length()) {
            concat.append(word1.charAt(i++));
        }
        
        while (j < word2.length()) {
            concat.append(word2.charAt(j++));
        }
        
        return concat.toString();
    }
}
