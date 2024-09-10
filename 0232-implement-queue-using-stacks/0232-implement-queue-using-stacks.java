class MyQueue {

    public Stack<Integer> s1;
    public Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        // int flag = 1;//to keep track of which is our principal queue
    }
    
    public void push(int x) {
        s1.push(x);   
    }
    
    public int pop() {
        while(!s1.empty()){
            int ele = s1.pop();
            s2.push(ele);
        }
        int x = -1;
        if(!s2.empty()){
            x = s2.pop();
            while(!s2.empty()){
                s1.push(s2.pop());
            }
            //now we gotta place it 
        }
        return x;
    }
    
    public int peek() {
        while(!s1.empty()){
            int ele = s1.pop();
            s2.push(ele);
        }
        int x = -1;
        if(!s2.empty()){
            x = s2.peek();
            while(!s2.empty()){
                s1.push(s2.pop());
            }
            //now we gotta place it 
        }
        return x;
    }
    
    public boolean empty() {
        return s1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */