class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
         int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];

        int row = 0, col = 0;
        int dir = 1; // 1 means up-right, -1 means down-left
        int idx = 0;

        while (idx < m * n) {
            result[idx++] = mat[row][col];

            // Moving up-right
            if (dir == 1) {
                if (col == n - 1) {       // Hit right boundary
                    row++;
                    dir = -1;
                } else if (row == 0) {    // Hit top boundary
                    col++;
                    dir = -1;
                } else {
                    row--;
                    col++;
                }
            }
            // Moving down-left
            else {
                if (row == m - 1) {       // Hit bottom boundary
                    col++;
                    dir = 1;
                } else if (col == 0) {    // Hit left boundary
                    row++;
                    dir = 1;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}