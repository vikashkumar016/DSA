class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String curr="";
        int num=0;
       for (char ch : s.toCharArray()){
        if (Character.isDigit(ch)) {
           num = num * 10 + (ch - '0');
       }
       else if(ch=='['){
        countStack.push(num);
        stringStack.push(curr);
        num=0;
        curr="";
       }
       else if(Character.isLetter(ch)){
        curr+=ch;
       }
       else {
        int count=countStack.pop();
        String prev=stringStack.pop();
         
         StringBuilder temp= new StringBuilder(prev);
         for(int i=0;i<count;i++){
            temp.append(curr);
         }
         curr=temp.toString();
       }
       }
       return curr;
    }
}