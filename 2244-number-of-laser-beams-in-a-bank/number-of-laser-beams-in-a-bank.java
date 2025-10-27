class Solution {
    public int numberOfBeams(String[] bank) {
         int totalBeams = 0;  // stores total laser beams
        int prev = 0;         // number of devices in previous non-empty row

        // loop through each row of the bank
        for (String row : bank) {
            int count = 0;

            // count the number of '1's (devices) in this row
            for (char c : row.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }

            // if this row has at least one device
            if (count > 0) {
                // add beams formed with previous non-empty row
                totalBeams += prev * count;

                // update prev to current row's device count
                prev = count;
            }
            // if count == 0, just skip, prev stays the same
        }

        return totalBeams;
    }
}