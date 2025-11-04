class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
      int n = nums.length;
        int[] ans = new int[n - k + 1];
        
        for (int i = 0; i + k <= n; i++) {
            // Step 1: frequency map for subarray
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // Step 2: sort elements by (freq desc, value desc)
            List<Integer> elements = new ArrayList<>(freq.keySet());
            elements.sort((a, b) -> {
                int fa = freq.get(a), fb = freq.get(b);
                if (fa != fb) return fb - fa; // higher freq first
                return b - a; // tie → larger number first
            });

            // Step 3: pick top x elements
            Set<Integer> keep = new HashSet<>();
            for (int j = 0; j < Math.min(x, elements.size()); j++) {
                keep.add(elements.get(j));
            }

            // Step 4: compute sum of subarray keeping only chosen elements
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                if (keep.contains(nums[j])) sum += nums[j];
            }

            ans[i] = sum;
        }

        return ans;  
    }
}