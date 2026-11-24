
class Solution {

    public long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public int maxLength(int[] nums) {

        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            long product = 1;
            long g = 0;
            long l = 1;

            for (int j = i; j < n; j++) {

                product *= nums[j];
                g = gcd(g, nums[j]);
                l = lcm(l, nums[j]);

                if (product == l * g) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}
