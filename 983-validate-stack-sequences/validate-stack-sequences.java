class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0; // acts as stack pointer
        int j = 0; // pointer for popped

        for (int x : pushed) {
            pushed[i++] = x; // push

            while (i > 0 && pushed[i - 1] == popped[j]) {
                i--; // pop
                j++;
            }
        }

        return i == 0;
    }
}