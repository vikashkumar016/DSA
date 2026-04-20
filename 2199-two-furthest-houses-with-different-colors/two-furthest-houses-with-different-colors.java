class Solution {
    public int maxDistance(int[] colors) {
        int maxDist=0;
        int n=colors.length;
       for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                maxDist = Math.max(maxDist, i); // i - 0 is just i
                break; // Found the furthest possible for the first house
            }
        }   
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                maxDist = Math.max(maxDist, (n - 1) - i);
                break; // Found the furthest possible for the last house
            }
        }
        return maxDist;    
    }
}