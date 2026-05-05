class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb= new StringBuilder();
        Stack<Integer>stack= new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(Character.isLetter(ch)) {
            sb.append(ch);
             }
            else if(ch=='('){
                stack.push(sb.length());
                sb.append(ch);
            }
            else {
                if(stack.isEmpty()){
                    continue;
                }
                else {
                 stack.pop();
                 sb.append(ch);
                }
            }
        }
          while(!stack.isEmpty()) {
        int index = stack.pop();
        sb.deleteCharAt(index);
       }
       return sb.toString();
    }
}