class Solution {
    public int reverseDegree(String s) {
        int count=0;
        int[] degree= new int[26];
        for(int i=0;i<degree.length;i++){
            degree[i]=26-i;
        }
        for(int i=0;i<s.length();i++){
            int ind=s.charAt(i)-'a';
            count+=degree[ind]*(i+1);
        }
        return count;
    }
}