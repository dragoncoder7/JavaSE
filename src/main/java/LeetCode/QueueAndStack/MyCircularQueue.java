package LeetCode.QueueAndStack;

/*MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1); // 返回 true
        circularQueue.enQueue(2); // 返回 true
        circularQueue.enQueue(3); // 返回 true
        circularQueue.enQueue(4); // 返回 false，队列已满
        circularQueue.Rear(); // 返回 3
        circularQueue.isFull(); // 返回 true
        circularQueue.deQueue(); // 返回 true
        circularQueue.enQueue(4); // 返回 true
        circularQueue.Rear(); // 返回 4

        MyCircularQueue(k): 构造器，设置队列长度为 k 。
        Front: 从队首获取元素。如果队列为空，返回 -1 。
        Rear: 获取队尾元素。如果队列为空，返回 -1 。
        enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
        deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
        isEmpty(): 检查循环队列是否为空。
        isFull(): 检查循环队列是否已满。

        */
class MyCircularQueue {
    private int head;
    private int tail;

    private int[] data;

    public MyCircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
    }

    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }

    public boolean isFull() {
        //我这里是分两种情况去判断了 一种是尾指针在头指针后面 一种是在前面 这两种其实可以统一的
        /*if (tail < head && tail + 1 == head){
            return true;
        }
        return tail == data.length - 1 && head == 0;*/
        return tail + 1 % data.length == head;//直接简单一个判断就返回了
    }

    public boolean enQueue(int value) {
        //需要有一个队列是否已满的判断
        if (isFull()){
            return false;
        }
        if (isEmpty()){
            head = 0;
            //tail = 0;
        }
        tail++;
        tail = tail % data.length;//保证数组不会越界
        data[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        if (head == tail){
            head = -1;
            tail = -1;
            return true;
        }
        head++;
        head = head % data.length;//保证数组不会越界
        return true;
    }

    public int Front() {
        if (head == -1){
            return -1;
        }
        return data[head];
    }

    public int Rear() {
        if (tail == -1){
            return -1;
        }
        return data[tail];
    }


}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
