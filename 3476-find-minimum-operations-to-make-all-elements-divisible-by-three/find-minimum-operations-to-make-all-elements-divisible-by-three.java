class Solution {
    public int minimumOperations(int[] nums) {
         int operations = 0;

        for (int n : nums) {
            int r = n % 3;     // remainder when divided by 3
            
            if (r == 1 || r == 2) {
                operations += 1;   // need exactly 1 move
            }
        }
        
        return operations;
    }
}