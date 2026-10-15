class Solution {
    public String getHint(String secret, String guess) {
        int bulls=0;
        int cows=0;
        int[] freq = new int[10];
        for(int i=0;i<guess.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
               bulls++;
            }
            else {
                  int digit = secret.charAt(i) - '0';
                 freq[digit]++;
            }
            
        }
        

   for (int i = 0; i < secret.length(); i++) {
    if (secret.charAt(i) == guess.charAt(i)) {
      continue;
    }
    int digit=guess.charAt(i)-'0';
       if (freq[digit]>0){
        cows++;
        freq[digit]--;
    }
    }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");

        return sb.toString();
    }
}