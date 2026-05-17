class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];

        // count students
        for(int s : students) {
            count[s]++;
        }

        // process sandwiches
        for(int sandwich : sandwiches) {

            // nobody wants this sandwich
            if(count[sandwich] == 0) {
                break;
            }

            count[sandwich]--;
        }

        return count[0] + count[1];
    }
}