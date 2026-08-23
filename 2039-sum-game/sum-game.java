class Solution {
    public boolean sumGame(String num) {
                int n = num.length();

        int leftSum = 0;
        int rightSum = 0;

        int leftQuestion = 0;
        int rightQuestion = 0;

        for (int i = 0; i < n; i++) {

            if (i < n / 2) {
                if (num.charAt(i) == '?') {
                    leftQuestion++;
                } else {
                    leftSum += num.charAt(i) - '0';
                }
            } else {
                if (num.charAt(i) == '?') {
                    rightQuestion++;
                } else {
                    rightSum += num.charAt(i) - '0';
                }
            }
        }

        if ((leftQuestion + rightQuestion) % 2 == 1) {
            return true;
        }

        int sumDifference = leftSum - rightSum;
        int questionDifference = rightQuestion - leftQuestion;

        return 2 * sumDifference != 9 * questionDifference;

    }
}