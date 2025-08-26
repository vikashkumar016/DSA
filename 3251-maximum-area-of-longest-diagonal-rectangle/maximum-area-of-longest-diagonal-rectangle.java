class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
           double maxDiagonal = 0;
        int maxArea = 0;

        for (int[] dim : dimensions) {
            int length = dim[0];
            int width = dim[1];

            double diagonal = Math.sqrt(length * length + width * width);
            int area = length * width;

            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = area;
            } else if (diagonal == maxDiagonal) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}