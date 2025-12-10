class Solution {
    public int hammingWeight(int n) {
     int count=0;
        while(n!=0){
           count+= (n & 1); // last bit check
           n>>>=1; //shift right or remove
        }
        return count;
    }
}