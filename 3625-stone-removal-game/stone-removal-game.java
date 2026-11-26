class Solution {
    public boolean canAliceWin(int n) {
     int remove = 10;
        int count = 0;

        while (n >= remove) {
            n -= remove;
            count++;
            remove--;
        }

        return count % 2 != 0;
    }
}