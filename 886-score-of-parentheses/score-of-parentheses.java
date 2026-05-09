class Solution {
    public int scoreOfParentheses(String s) {
   Stack<Integer>stack= new Stack<>();
     stack.push(0);
     for(char ch:s.toCharArray()){
      if(ch=='('){
        stack.push(0);
      }
      else {
        int score;
        int top=stack.pop();
        if(top==0){  //found ()
           score=1;
        }
        else {
            score=2*top;
        }
        stack.push(stack.pop()+score);
      }
     }
     return stack.pop();
    }
}