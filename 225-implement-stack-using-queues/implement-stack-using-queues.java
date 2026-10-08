class MyStack {
    // Only use a Queue. java.util.Stack is completely removed.
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
        
        // Rotate the queue so the new element comes to the front
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
    }
    
    // Removes the element on top of the stack and returns it.
    public int pop() {
        return queue.poll();
    }
    
    // Get the top element.
    public int top() {
        return queue.peek();
    }
    
    // Returns whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */