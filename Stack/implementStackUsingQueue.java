class MyStack {

    /** Initialize your data structure here. */
     Queue<Integer>queue = new LinkedList<>();
    public MyStack() {
       
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for(int i=1;i<queue.size();i++) {
            int d = queue.remove();
            queue.add(d);
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return queue.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
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