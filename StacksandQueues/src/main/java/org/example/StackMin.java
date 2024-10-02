package org.example;

import java.util.ArrayList;
import java.util.List;

public class StackMin {
    public List<Integer> stack;
    public int sizeOfStack;
    public int min;

    public StackMin() {
        this.stack = new ArrayList<>();
        this.sizeOfStack = 0;
        this.min = Integer.MAX_VALUE;
    }

    public void push(int value) {
        this.stack.add(value);
        this.sizeOfStack++;
        this.min = Math.min(this.min, value);
    }

    public int pop() {
        int popped = this.stack.remove(this.stack.size() - 1);
        this.sizeOfStack--;
        return popped;
    }

    public int getMin() {
        return this.min;
    }
}
