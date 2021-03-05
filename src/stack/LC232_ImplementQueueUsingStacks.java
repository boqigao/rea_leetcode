package stack;

import java.util.Stack;

public class LC232_ImplementQueueUsingStacks {
}

class MyQueue {

    private Stack<Integer> a;
    private Stack<Integer> b;
    /** Initialize your data structure here. */
    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        a.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    // a 只负责入队列，b只负责出队列，b的栈顶就是队列的头元素
    public int pop() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        return b.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}
