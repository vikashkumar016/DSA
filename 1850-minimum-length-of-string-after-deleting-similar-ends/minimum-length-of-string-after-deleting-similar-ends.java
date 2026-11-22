class Solution {
    public int minimumLength(String s) {
        int count=0;
        int left=0;
        int right=s.length()-1;
        int n=s.length();
        while(left<right && s.charAt(left)==s.charAt(right)){
            char ch=s.charAt(left);
            while(left<=right && s.charAt(left)==ch){
                left++;
            }
            while(left<=right &&s.charAt(right)==ch){
                right--;
            }
        }
        return right-left+1;
    }
}