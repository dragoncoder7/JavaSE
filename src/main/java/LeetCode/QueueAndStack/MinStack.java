package LeetCode.QueueAndStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MinStack {
    /*MinStack() 初始化堆栈对象。
    void push(int val) 将元素val推入堆栈。
    void pop() 删除堆栈顶部的元素。
    int top() 获取堆栈顶部的元素。
    int getMin() 获取堆栈中的最小元素。*/
    List<Integer> stack;
    int MinStack;

    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
    }

    public void pop() {
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return isEmpty() ? -1 : stack.get(stack.size() - 1);
    }

    public int getMin() {
        if (isEmpty())
            return -1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < stack.size(); i++) {
            if (stack.get(i) < min) {
                min = stack.get(i);
            }
        }
        return min;
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
