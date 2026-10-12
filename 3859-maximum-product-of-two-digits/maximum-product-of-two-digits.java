class Solution {
    public int maxProduct(int n) {
  int largest = 0;
int secondLargest = 0;
    
        while(n>0){
           int rem=n%10;
           if(rem>largest){
            secondLargest=largest;
            largest=rem;
           }
           else if(secondLargest<rem) {
            secondLargest=rem;
           }
           n=n/10;
        }
        
        return largest*secondLargest;
    }
}