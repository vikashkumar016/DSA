// class Solution {
//     public boolean doesAliceWin(String s) {
//         // int vowelCount = 0;
//         // for (char ch : s.toCharArray()) {
//         //     if (isVowel(ch)) {
//         //         vowelCount++;
//         //     }
//         // }
//         // return vowelCount % 2 == 1; 
        
//             s.chars()
//             .anyMatch(c -> {
//                 return "aeiou".indexOf(c) != -1;
//             });
//     }
    
//     // private static boolean isVowel(char ch) {
//     //     return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
//     // }
// }

class Solution {

    public boolean doesAliceWin(String s) {
        return s
            .chars()
            .anyMatch(c -> {
                return "aeiou".indexOf(c) != -1;
            });
    }
}