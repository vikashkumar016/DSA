class Solution {
    public int maxPower(String s) {
        int len=1;
        int n=s.length();
        int count=1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }
            else {
                count=1;
            }
        len=Math.max(len,count);
        }
        return len;
    }
}