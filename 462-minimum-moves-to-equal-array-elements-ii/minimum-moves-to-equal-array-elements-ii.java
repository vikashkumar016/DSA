class Solution {
    public int minMoves2(int[] nums) {
     long minMoves = Long.MAX_VALUE;

        for (int target : nums) {

            long moves = 0;

            for (int num : nums) {
                moves += Math.abs((long)num - target);
            }

            minMoves = Math.min(minMoves, moves);
        }

        return (int) minMoves;
    }
}