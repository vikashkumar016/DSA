class Solution {
    public int totalMoney(int n) {
       int weeks = n / 7;
        int days = n % 7;
        int total = 0;

        // Sum for full weeks
        // Each week adds 28 + (week-1)*7
        total += (28 * weeks) + (7 * weeks * (weeks - 1)) / 2;

        // Remaining days in the last week
        int start = weeks + 1; // starting amount for the next Monday
        for (int i = 0; i < days; i++) {
            total += start + i;
        }

        return total;
    }
}