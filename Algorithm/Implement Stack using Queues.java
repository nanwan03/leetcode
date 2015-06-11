class MyStack {
	Queue<Integer> queue1 = new LinkedList<Integer>();
	Queue<Integer> queue2 = new LinkedList<Integer>();
	List<Queue<Integer>> list = new ArrayList<Queue<Integer>>();
	MyStack() {
		list.add(queue1);
		list.add(queue2);
	}
	// Push element x onto stack.
	public void push(int x) {
	    if (!list.get(0).isEmpty()) {
	    	list.get(0).offer(x);
	    } else {
	    	list.get(1).offer(x);
	    }
	}

	// Removes the element on top of the stack.
	public void pop() {
	    int cur = list.get(0).isEmpty() ? 1 : 0;
	    int alter = 1 - cur;
	    while (list.get(cur).size() > 1) {
	    	list.get(alter).add(list.get(cur).poll());
	    }
	    list.get(cur).poll();
	}

	// Get the top element.
	public int top() {
	    int ret = 0;
	    int cur = list.get(0).isEmpty() ? 1 : 0;
	    int alter = 1 - cur;
	    while (list.get(cur).size() > 1) {
	    	list.get(alter).add(list.get(cur).poll());
	    }
	    ret = list.get(cur).poll();
	    list.get(alter).offer(ret);
	    return ret;
	}

	// Return whether the stack is empty.
	public boolean empty() {
	    return queue1.isEmpty() && queue2.isEmpty();
	}
}