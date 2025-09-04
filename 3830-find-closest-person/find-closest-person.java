class Solution {
    public int findClosest(int x, int y, int z) {
        // int x1= Math.abs(z-x);
        // int y1=Math.abs(z-y);
        // int min =Math.min(x1,y1);
        // if(x1==min){
        //     return 1;
        // }
        // else if(x1==min && y1==min){
        //     return 0;
        // }
        // return 2;
          int x1 = Math.abs(z - x);
        int y1 = Math.abs(z - y);

        if (x1 == y1) {
            return 0; // both are equally close
        } else if (x1 < y1) {
            return 1; // x is closer
        } else {
            return 2; // y is closer
        }
    }
}