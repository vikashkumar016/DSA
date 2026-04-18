class Solution {
    public boolean isHappy(int n) {
     while (n != 1) {
            int sum = 0;

            // Step: calculate sum of squares of digits
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }

            // update n for next iteration
            n = sum;

            // cycle detection (important)
            if (n == 4) {
                return false;
            }
        }

        return true;
    }
}