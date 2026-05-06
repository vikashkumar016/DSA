class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for(int i=0;i<bookings.length;i++){
            int start=bookings[i][0];
            int end=bookings[i][1];
             int seats = bookings[i][2];
            for(int j=start;j<=end;j++){
                ans[j-1]+=seats;
            }
        }
        return ans;
    }
}