class Solution {
    public List<String> topKFrequent(String[] words, int k) {
         // Step 1: Count frequency
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2: Put unique words into list
        List<String> list = new ArrayList<>(map.keySet());

        // Step 3: Sort the list
        Collections.sort(list, (a, b) -> {
            // Higher frequency first
            if (map.get(a) != map.get(b)) {
                return map.get(b) - map.get(a);
            }

            // If same frequency -> alphabetical order
            return a.compareTo(b);
        });

        // Step 4: Return first k words
        return list.subList(0, k);
    }
}