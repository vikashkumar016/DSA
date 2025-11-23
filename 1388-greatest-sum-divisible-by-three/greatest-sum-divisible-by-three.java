class Solution {
    public int maxSumDivThree(int[] nums) {
       int sum = 0;

        // These store numbers based on remainder
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        // Step 1: Calculate sum and categorize numbers
        for (int num : nums) {
            sum += num;

            if (num % 3 == 1) {
                r1.add(num);
            } else if (num % 3 == 2) {
                r2.add(num);
            }
        }

        // Step 2: Sort remainders to remove smallest values
        Collections.sort(r1);
        Collections.sort(r2);

        // Step 3: If sum already divisible by 3, return it
        if (sum % 3 == 0) {
            return sum;
        }

        int result = 0;

        // Step 4: If remainder is 1
        if (sum % 3 == 1) {
            int removeOneR1 = r1.size() >= 1 ? r1.get(0) : Integer.MAX_VALUE;
            int removeTwoR2 = r2.size() >= 2 ? (r2.get(0) + r2.get(1)) : Integer.MAX_VALUE;

            int remove = Math.min(removeOneR1, removeTwoR2);
            result = sum - remove;
        }
        // Step 5: If remainder is 2
        else { // sum % 3 == 2
            int removeOneR2 = r2.size() >= 1 ? r2.get(0) : Integer.MAX_VALUE;
            int removeTwoR1 = r1.size() >= 2 ? (r1.get(0) + r1.get(1)) : Integer.MAX_VALUE;

            int remove = Math.min(removeOneR2, removeTwoR1);
            result = sum - remove;
        }

        // If we couldn't remove correctly (rare case)
        return result < 0 ? 0 : result;
    }
}