package QueueAndStack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Action {
    public static void main(String[] args) {

        /* 基础队列
        int[] arr = new int[10];
        System.out.println(Arrays.toString(arr));
        MyQueue q = new MyQueue();
        q.insertQueue(5);
        q.insertQueue(3);
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
        q.deleteQueue();
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
        q.deleteQueue();
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
        */

        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1); // 返回 true
        circularQueue.enQueue(2); // 返回 true
        circularQueue.enQueue(3); // 返回 true
        circularQueue.enQueue(4); // 返回 false，队列已满
        circularQueue.Rear(); // 返回 3
        circularQueue.isFull(); // 返回 true
        circularQueue.deQueue(); // 返回 true
        circularQueue.enQueue(4); // 返回 true
        circularQueue.Rear(); // 返回 4

        Queue<Integer> q = new LinkedList<>();
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        q.addAll(Arrays.asList(3, 6, 9, 2, 0, 7));
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());
    }
}
