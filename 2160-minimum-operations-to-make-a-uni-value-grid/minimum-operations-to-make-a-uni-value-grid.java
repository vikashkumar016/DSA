class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        int[] arr= new int[n*m];
        int idx=0;
        for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
        arr[idx++] = grid[i][j];
    }
   }
   Arrays.sort(arr);
   int mid=arr.length/2;
   int lastRem=arr[0]%x;
    for(int i=1;i<arr.length;i++){
        if(arr[i]%x!=lastRem){
            return -1;
        }
    }
    int count=0;
    int midE=arr[mid];
    for(int i=0;i<arr.length;i++){
        count+=Math.abs(midE-arr[i])/x;
    }
    return count;
    }
}