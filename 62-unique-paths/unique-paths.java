// class Solution {
//     public static int gridWays(int i,int j,int n,int m){
//         if(i==n-1 && j==m-1){
//             return 1;
//         }
//         else if(i==n || j==m) {
//            return 0;
//         }
//         int w1=gridWays(i+1,j,n,m);
//         int w2=gridWays(i,j+1,n,m);

//         return w1+w2;
//             }
//     public int uniquePaths(int m, int n) {
        
//          return gridWays(0, 0, m, n);
//     }
// }

class Solution {
    public int uniquePaths(int m, int n) {
        return (int) combination(m + n - 2, Math.min(m - 1, n - 1));
    }

    // Helper to compute nCr using iterative multiplication
    public long combination(int total, int k) {
        long result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (total - k + i) / i;
        }
        return result;
    }
}
