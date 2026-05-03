class Solution {
    public String makeGood(String s) {
       StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() &&
    Character.toLowerCase(stack.peek()) == Character.toLowerCase(s.charAt(i)) &&
    stack.peek() != s.charAt(i)) {
    stack.pop();
        } else {
      stack.push(s.charAt(i));
     } 
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();
        return sb.toString();
    }
}