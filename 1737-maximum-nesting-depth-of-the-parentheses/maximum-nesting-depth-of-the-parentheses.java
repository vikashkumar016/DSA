class Solution {
    public int maxDepth(String s) {
        int max=0;
        int curr=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                curr++;
                max=Math.max(curr,max);
            }
            else if(ch==')') {
                curr--;
            }
        }
        return max;
    }
}