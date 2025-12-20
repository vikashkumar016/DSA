class Solution {
    public int minDeletionSize(String[] strs) {
         int count = 0;
        int rows = strs.length;
        int cols = strs[0].length();

        // Loop through each column
        for (int j = 0; j < cols; j++) {
            // Check if this column is sorted
            for (int i = 1; i < rows; i++) {
                if (strs[i].charAt(j) < strs[i - 1].charAt(j)) {
                    count++;      // column is not sorted
                    break;        // stop checking this column
                }
            }
        }

        return count;
    }
}