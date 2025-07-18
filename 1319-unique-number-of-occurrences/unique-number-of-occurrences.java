class Solution {
    public boolean uniqueOccurrences(int[] arr) {
         Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequency of each number
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert frequencies to a list
        List<Integer> freqList = new ArrayList<>(freqMap.values());

        // Step 3: Brute-force check for duplicates
        for (int i = 0; i < freqList.size(); i++) {
            for (int j = i + 1; j < freqList.size(); j++) {
                if (freqList.get(i).equals(freqList.get(j))) {
                    return false;
                }
            }
        }

        return true;
    }
}