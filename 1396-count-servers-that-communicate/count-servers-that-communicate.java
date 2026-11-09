class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                   //Step 1: Count servers in same row
                   int rowCount = 0;
            for(int k = 0; k < m; k++) {
        if(grid[i][k]==1) {
          rowCount++;
         } 
            }
                // Step 2: Count servers in same column
                 int colCount = 0;
       for(int k = 0; k < n; k++) {
      if(grid[k][j]==1) {
         colCount++;
       }
     } 
          if(rowCount > 1 || colCount > 1) {
       count++;
       }
                }
        }
        }
        return count;
    }
}