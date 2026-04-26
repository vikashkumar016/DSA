class Solution {
    private int getDistance(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        // Sort all points based on distance
        Arrays.sort(points, (a, b) -> Integer.compare(getDistance(a), getDistance(b)));

        // Take first k points
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            result[i] = points[i];
        }

        return result;
    }
}