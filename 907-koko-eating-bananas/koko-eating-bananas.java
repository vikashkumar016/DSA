class Solution {

    public boolean canEatAll(int[] piles, int mid, int h) {

       long actualHours = 0;

    for (int x : piles) {

        actualHours += x / mid;

        if (x % mid != 0) {
            actualHours++;
        }

        // early stopping
        if (actualHours > h) {
            return false;
        }
    }

    return true;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;

        int r = 0;

        // find maximum pile
        for (int x : piles) {
            r = Math.max(r, x);
        }

        int ans = r;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (canEatAll(piles, mid, h)) {

                ans = mid;

                r = mid - 1;
            }

            else {

                l = mid + 1;
            }
        }

        return ans;
    }
}