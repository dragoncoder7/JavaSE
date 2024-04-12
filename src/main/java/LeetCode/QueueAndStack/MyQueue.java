package LeetCode.QueueAndStack;

import java.util.ArrayList;
import java.util.List;

/**
 * 队列   先进先出
 */
class MyQueue {
    private List<Integer> data;

    private int p_start;

    public MyQueue(){
        data = new ArrayList<>();
        p_start = 0;
    }

    boolean insertQueue(int x){
        data.add(x);
        return true;
    }

    /**
     * 删除掉当前的第一个队列元素
     * @return 成功删除返回true
     *         队列为空返回false
     *         但是有个问题 这个并没有删除掉其中的元素 只是改变了指针的位置
     *         如果数量大的话
     *         那么内存会一直增加 直到内存溢出
     */
    boolean deleteQueue(){
        if(isEmpty()){
            return false;
        }
        p_start++;
        return true;
    }

    /**
     * @return  返回当前队列中的第一个元素
     */
    public int Front() {
        return data.get(p_start);
    }


    /**
     * 判断当前队列是否为空
     * @return 当不为空 返回true
     * 当为空 返回false
     */
    public boolean isEmpty() {
        return p_start >= data.size();
    }

    public class Main{

    }


}
