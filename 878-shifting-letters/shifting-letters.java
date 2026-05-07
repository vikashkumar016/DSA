class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder sb = new StringBuilder();
        long[] suffix= new long[shifts.length];
       suffix[shifts.length - 1] = shifts[shifts.length - 1];
        for(int i=shifts.length-2;i>=0;i--){
            suffix[i] = shifts[i] + suffix[i + 1];
        }
        for(int i=0;i<suffix.length;i++){
            long shift = suffix[i] % 26;
             char ch = s.charAt(i);
             int newChar = (ch - 'a' + (int)shift) % 26;
              sb.append((char)(newChar + 'a'));

        }
        return sb.toString();
    }
}