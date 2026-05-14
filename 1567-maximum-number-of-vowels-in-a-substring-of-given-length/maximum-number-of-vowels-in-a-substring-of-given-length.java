class Solution {
    public int maxVowels(String s, int k) {
    int count=0;
    int max=0;
     for(int i=0;i<k;i++){
     char ch=s.charAt(i);
     if(ch == 'a' || ch == 'e' || ch == 'i' ||
               ch == 'o' || ch == 'u') {

                count++;
            }
     }        
     max=count;
     int left=0;
     for(int right=k;right<s.length();right++){

        // remove left char
           char leftChar= s.charAt(left);

         if(leftChar == 'a' || leftChar == 'e' || leftChar == 'i' ||
               leftChar == 'o' || leftChar == 'u') {

                count--;
            }
              // add right character
            char rightChar = s.charAt(right);

            if(rightChar == 'a' || rightChar == 'e' || rightChar == 'i' ||
               rightChar == 'o' || rightChar == 'u') {

                count++;
            }
            max=Math.max(count,max);
            left++;

     }
     return max;
    }
}