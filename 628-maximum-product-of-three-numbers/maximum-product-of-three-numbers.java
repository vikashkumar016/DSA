class Solution {
    public int maximumProduct(int[] nums) {
        
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int num : nums) {

            // max 3 numbers
            if(num > a) {
                c = b;
                b = a;
                a = num;
            } 
            else if(num > b) {
                c = b;
                b = num;
            } 
            else if(num > c) {
                c = num;
            }

            // min 2 numbers
            if(num < min1) {
                min2 = min1;
                min1 = num;
            } 
            else if(num < min2) {
                min2 = num;
            }
        }

        return Math.max(a*b*c, a*min1*min2);
    }
}