class MyStack {

    public Queue<Integer> q;

    public MyStack() {
        //initialise the queue
        q = new LinkedList<>();
    }
    
    public void push(int x) {   
        q.offer(x);
        //now we hae to rotate the queue
        for(int i=0; i<q.size()-1 ; i++){
            //notice we did q.size()-1 
            //since we need to make sure the element at last right now does stay in first after the process

            int front_element = q.poll();
            //now we have to put the front to the last --> which is simple in queue just put him normally
            q.offer(front_element);
        }
    }
    
    public int pop() {
        //simple...since in push() we do the main logic already
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
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