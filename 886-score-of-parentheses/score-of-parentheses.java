class Solution {
    public int scoreOfParentheses(String s) {
     Stack<Integer> stack = new Stack<>();

        // outermost level score
        stack.push(0);

        for (char ch : s.toCharArray()) {

            // new group starts
            if (ch == '(') {

                stack.push(0);

            } else {

                // current group's score
                int top = stack.pop();

                int score;

                // means "()"
                if (top == 0) {
                    score = 1;
                }

                // means "(A)"
                else {
                    score = 2 * top;
                }

                // add to parent group
                stack.push(stack.pop() + score);
            }
        }

        return stack.pop();
       
    }
}