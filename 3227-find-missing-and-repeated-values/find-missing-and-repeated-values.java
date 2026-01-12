class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
       HashSet<Integer> set = new HashSet<>();
        int a = -1;  // duplicate
        int b;       // missing
        int n = grid.length;
        int actualSum = 0;

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                
                // If add() returns false → duplicate
                if (!set.add(val)) {
                    a = val;  // store duplicate in a
                }

             
                actualSum += val;
            }
        }

        // Expected sum of 1 to n^2
        int expSum = n * n * (n * n + 1) / 2;

        // Missing number formula
        b = expSum + a - actualSum;

        return new int[]{a, b};
    }
}