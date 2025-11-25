class Solution {
    public int smallestRepunitDivByK(int k) {
         // If k is divisible by 2 or 5, impossible
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        int remainder = 1 % k; // first number: "1"
        int length = 1;

        // Use a set to detect cycles
        HashSet<Integer> seen = new HashSet<>();

        while (remainder != 0) {

            // if we see the same remainder again, we are in a cycle → no solution
            if (seen.contains(remainder)) {
                return -1;
            }

            seen.add(remainder);

            // Formula: new_remainder = (old_remainder * 10 + 1) % k
            remainder = (remainder * 10 + 1) % k;
            length++;
        }

        return length;
    }
}