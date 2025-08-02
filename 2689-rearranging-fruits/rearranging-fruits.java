class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> count = new HashMap<>();
        int n = basket1.length;
        long minFruit = Long.MAX_VALUE;

        // Step 1: Count total occurrences and find the minimum fruit cost
        for (int i = 0; i < n; i++) {
            count.put(basket1[i], count.getOrDefault(basket1[i], 0) + 1);
            count.put(basket2[i], count.getOrDefault(basket2[i], 0) - 1);
            minFruit = Math.min(minFruit, Math.min(basket1[i], basket2[i]));
        }

        List<Integer> excess = new ArrayList<>();

        // Step 2: Collect surplus fruits (only half of excess per fruit)
        for (int fruit : count.keySet()) {
            int c = count.get(fruit);
            if (c % 2 != 0) {
                return -1; // Impossible to balance
            }

            for (int i = 0; i < Math.abs(c) / 2; i++) {
                excess.add(fruit);
            }
        }

        // Step 3: Sort the list of surplus fruits
        Collections.sort(excess);

        long cost = 0;
        int m = excess.size();

        // Step 4: Choose the smaller cost: direct swap or two-step via minFruit
        for (int i = 0; i < m / 2; i++) {
            cost += Math.min(excess.get(i), 2 * minFruit);
        }

        return cost;
    }
}