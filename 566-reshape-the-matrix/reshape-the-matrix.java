class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] matrix= new int[r][c];
        if(m*n !=r*c){
        return mat;
        }
       for(int i=0;i<m*n;i++){
         matrix[i / c][i % c]=mat[i / n][i % n];
       }
       return matrix;
    }
}