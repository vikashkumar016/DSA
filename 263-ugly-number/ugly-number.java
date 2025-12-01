class Solution {
    public boolean isUgly(int n) {
          if (n <= 0) {
            return false; // ugly numbers must be positive
        }

        int[] primes = {2, 3, 5};
        for (int p : primes) {
            while (n % p == 0) {
                n /= p;
            }
        }

        return n == 1; // if we reduced n to 1, it's ugly
    }
}