class Solution {
    public int compress(char[] chars) {
    //   int write = 0;   // position to write
    //     int count = 1;   // count of current char

    //     for (int i = 1; i <= chars.length; i++) {
    //         if (i < chars.length && chars[i] == chars[i - 1]) {
    //             count++;
    //         } else {
    //             // write the character
    //             chars[write++] = chars[i - 1];

    //             // write the count if > 1
    //             if (count > 1) {
    //                 for (char c : String.valueOf(count).toCharArray()) {
    //                     chars[write++] = c;
    //                 }
    //             }

    //             count = 1; // reset for next group
    //         }
    //     }
    //     return write;
        StringBuilder sb = new StringBuilder();
        int count=1;

        for(int i=1;i<=chars.length;i++){
            if(i<chars.length && chars[i]==chars[i-1]){
           count++;
            }
            else {
                sb.append(chars[i-1]);
                if(count>1){
                    sb.append(count);
                }
                count=1;
            }
        }
         // copy back to original array
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}