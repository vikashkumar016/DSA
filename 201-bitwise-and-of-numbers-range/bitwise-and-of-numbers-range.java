class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        //  int ans = left;

        // for (int i = left + 1; i <= right; i++) {
        //     ans = ans & i;

        //     // small optimization
        //     if (ans == 0) {
        //         break;
        //     }
        // }

        // return ans;
        int shift = 0;

        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        return left << shift;

    }
}