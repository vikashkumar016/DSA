class Solution {
    public boolean detectCapitalUse(String word) {
         // Case 1: all uppercase
        int i = 0;
        boolean allUpper = true;

        while (i < word.length()) {
            if (!Character.isUpperCase(word.charAt(i))) {
                allUpper = false;
                break;
            }
            i++;
        }

        if (allUpper) return true;

        // Case 2: all lowercase
        i = 0;
        boolean allLower = true;

        while (i < word.length()) {
            if (!Character.isLowerCase(word.charAt(i))) {
                allLower = false;
                break;
            }
            i++;
        }

        if (allLower) return true;

        // Case 3: first uppercase, rest lowercase
        if (Character.isUpperCase(word.charAt(0))) {
            i = 1;

            while (i < word.length()) {
                if (!Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
                i++;
            }

            return true;
        }

        return false;
    }
}