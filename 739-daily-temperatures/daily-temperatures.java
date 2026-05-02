class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int greater=temp[0];
        int [] ans = new int[temp.length];
        Stack<Integer>stack= new Stack<>();
        for(int i=0;i<temp.length;i++){
         while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
           int prevIndex = stack.pop();
         ans[prevIndex] = i - prevIndex;
        }
        stack.push(i);
        }
        
        return ans;
    }
}