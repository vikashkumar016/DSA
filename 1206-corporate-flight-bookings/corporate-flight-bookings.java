class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n]; // Time complexity= O(bookings*n)
        for(int i=0;i<bookings.length;i++){
            int start=bookings[i][0];
            int end=bookings[i][1];
             int seats = bookings[i][2];
            ans[start-1]+=seats;
               if(end<n){
                 ans[end]-=seats;
               }
        }
        for(int i=1;i<ans.length;i++){
            ans[i]=ans[i]+ans[i-1];
        }
        return ans;
    }
}