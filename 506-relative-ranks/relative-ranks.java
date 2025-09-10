class Solution {
    public String[] findRelativeRanks(int[] score) {
         int n = score.length;
        
        // Step 1: Create an array of pairs (score, original index)
        Integer[][] scoreWithIndex = new Integer[n][2];
        for (int i = 0; i < n; i++) {
            scoreWithIndex[i][0] = score[i];
            scoreWithIndex[i][1] = i;
        }

        // Step 2: Sort the array of pairs by score in descending order
        Arrays.sort(scoreWithIndex, (a, b) -> b[0] - a[0]);  // Compare by score, descending
        
        // Step 3: Create a result array to store the ranks
        String[] result = new String[n];

        // Step 4: Assign ranks based on sorted order
        for (int i = 0; i < n; i++) {
            int index = scoreWithIndex[i][1];  // Get the original index of this athlete's score
            
            // Assign rank based on the current position
            if (i == 0) {
                result[index] = "Gold Medal";
            } else if (i == 1) {
                result[index] = "Silver Medal";
            } else if (i == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(i + 1);  // 4th place and onwards
            }
        }

        return result;
    }
}