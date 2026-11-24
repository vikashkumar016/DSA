class Solution {
       public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int findGCD(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            if(num>max){
                max=num;
            }
            if(min>num){
                min=num;
            }
        }
       return gcd(max,min);
    }
}