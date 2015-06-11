class Stack {
    private Queue<Integer> queue = new ArrayDeque<>();
    private Integer topElement = null; 
    
    // Push element x onto stack.
    public void push(int x) {
        topElement = x;
        queue.offer(x);
    }
    
    // Removes the element on top of the stack.
    public void pop() {
        for (int i = 0, size = queue.size() - 1; i < size; i++) {
            queue.offer(queue.poll());
        }
    
        queue.poll();
    }
    
    // Get the top element.
    public int top() {
        return topElement;
    }
    
    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}