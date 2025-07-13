class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        //Brute force appraoch
        //  boolean[] used = new boolean[trainers.length]; // to track used trainers
        // int count = 0;

        // for (int i = 0; i < players.length; i++) {
        //     for (int j = 0; j < trainers.length; j++) {
        //         if (!used[j] && players[i] <= trainers[j]) {
        //             used[j] = true; // mark trainer as used
        //             count++; // one match found
        //             break; // move to next player
        //         }
        //     }
        // }

        // return count;
           
           //optimised approach
           
          Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0, count = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                count++; // successful match
                i++;
                j++;
            } else {
                j++; // trainer too weak, try next one
            }
        }

        return count;
    }
}