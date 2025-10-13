class Solution {
    public List<String> removeAnagrams(String[] words) {
          List<String> result = new ArrayList<>();
        
        // Loop through the words
        for (String word : words) {
            // If the result list is not empty, compare with the last word in the result list
            if (!result.isEmpty() && areAnagrams(result.get(result.size() - 1), word)) {
                // If they are anagrams, skip the current word
                continue;
            }
            // Otherwise, add the word to the result list
            result.add(word);
        }
        
        return result;
    }
      private boolean areAnagrams(String word1, String word2) {
        // Convert both words to char arrays, sort them and compare
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }
}