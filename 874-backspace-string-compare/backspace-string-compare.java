class Solution {
    public boolean backspaceCompare(String s, String t) {
         return build(s).equals(build(t));
    }
    private String build(String str){
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch != '#') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        // Convert stack to string
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}