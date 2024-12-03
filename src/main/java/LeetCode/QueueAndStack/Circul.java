package LeetCode.QueueAndStack;

public class Circul {
    private int front,rear;

    private int length;

    private int[] res;
    public Circul(int k){
        length = k;
        front = rear = -1;
        res = new int[length];
    }

    public boolean insert(int i){
        if (isEmpty()){
            front = 0;
        } else if (isFull()) {
            return false;
        }
        rear++;
        rear = rear % length;
        res[rear] = i;
        return true;
    }

    public boolean remove(){
        if (isEmpty()){
            return false;
        }
        front = (front + 1) % length;
        return true;
    }

    public boolean isEmpty(){
        return front == rear && front == 0;
    }

    public boolean isFull(){
        if (rear > front){
            return rear - front > 0;
        }else {
            return front -rear - 1 > 0;
        }
    }
}
