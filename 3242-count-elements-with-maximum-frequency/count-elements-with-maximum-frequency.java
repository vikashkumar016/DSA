class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Find the maximum frequency
        int maxFrequency = 0;
        for (int freq : frequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, freq);
        }
        
        // Step 3: Sum the frequencies that have the maximum frequency
        int totalFrequency = 0;
        for (int freq : frequencyMap.values()) {
            if (freq == maxFrequency) {
                totalFrequency += freq;
            }
        }
        
        return totalFrequency;
    }
}