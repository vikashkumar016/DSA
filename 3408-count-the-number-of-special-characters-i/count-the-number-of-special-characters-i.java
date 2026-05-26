class Solution {
    public int numberOfSpecialChars(String word) {
     HashSet<Character> small = new HashSet<>();
        HashSet<Character> capital = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isUpperCase(ch)) {
                capital.add(ch);
            } else {
                small.add(ch);
            }
        }

        int count = 0;

        for (char ch : small) {
            if (capital.contains(Character.toUpperCase(ch))) {
                count++;
            }
        }

        return count;
    }
}