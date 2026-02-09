class Solution {
    public int[] plusOne(int[] digits) {
        // int num=0;
         int n=digits.length;
        // for(int i=0;i<n;i++){
        //     num=num*10+digits[i];
        // }
        // num=num+1;
        // String s=Long.toString(num);
        // int result[]= new int[s.length()];
        // for(int i=0;i<s.length();i++){
        //     result[i]=s.charAt(i)-'0';
        // }
        // return result;
        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
     // all digits are 9
     int[] result= new int[n+1];
     result[0]=1;
     return result;
    }
}