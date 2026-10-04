class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer>openStack= new Stack<>();
        Stack<Integer>starStack= new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                openStack.push(i);
            }
             else if(ch=='*'){
                starStack.push(i);
             }
             else if(ch==')'){
                if(!openStack.isEmpty() ){
                   openStack.pop();
                }
                else if(!starStack.isEmpty()){
                    starStack.pop();
                }
                else if(starStack.isEmpty() && openStack.isEmpty()){
                    return false;
                }
             }
        }
        while(!openStack.isEmpty() && !starStack.isEmpty()){
    if(starStack.peek() > openStack.peek()){
       openStack.pop();
        starStack.pop();
    }
    else{
        return false;
    }
}
    return openStack.isEmpty();
    }
}