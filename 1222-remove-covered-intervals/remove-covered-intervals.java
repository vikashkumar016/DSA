class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int count=0;
        for (int i = 0; i < intervals.length; i++) {

    int start1 = intervals[i][0];
    int end1 = intervals[i][1];
    boolean covered = false;
    for (int j = 0; j < intervals.length; j++) {

        if (i == j)
            continue;

        int start2 = intervals[j][0];
        int end2 = intervals[j][1];

        if (start2 <= start1 && end1 <= end2) {
               covered = true;
            break;
        }
    }
      if (covered){
        count++;
}
} 
     return intervals.length-count;
    }
}