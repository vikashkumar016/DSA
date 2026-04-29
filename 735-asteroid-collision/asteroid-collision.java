class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack = new Stack<>();
         for(int i : asteroids){
            boolean destroy = false;
             while(!stack.isEmpty() && stack.peek()>0 && i<0){
                if(stack.peek()< -i){
                    stack.pop();
                }
                else if(stack.peek()==-i){
                    stack.pop();
                    destroy=true;
                    break;
                }
                else {
                    destroy = true;
                    break;
                }

             }
             
             if(!destroy){
              stack.push(i);
             }
         }
           int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}