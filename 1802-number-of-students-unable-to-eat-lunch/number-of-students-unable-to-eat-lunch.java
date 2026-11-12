class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer>stack= new Stack<>();
        Queue<Integer>queue= new LinkedList<>();
        for(int i=0;i<students.length;i++){
            queue.offer(students[i]);
        }
        for(int i = sandwiches.length - 1; i >= 0; i--){
     stack.push(sandwiches[i]);
    }
        int rotation=0;
        while(!stack.isEmpty() && !queue.isEmpty()){
            int num=queue.poll();
            if(stack.peek()==num){
                stack.pop();
                rotation=0;
            }
            else {
                queue.offer(num);
                rotation++;
                if(rotation==queue.size()){
                break;
            }

            }
            
        }
        return queue.size();
    }
}