package demo.Demo;

// 创建一个新的线程

/**
 * @link <a href="https://www.codefather.cn/course/1803988290715377665/section/1803988645842903041">编程导航</a>
 * @linkplain 编程导航
 * @serial Thread
 * @version 10.10.1
 */
public class NewThread implements Runnable{
       Thread t;
       NewThread() {
          // 创建第二个新线程
          t = new Thread(this, "Demo Thread");
          System.out.println("Child thread t: " + t);
          t.start(); // 开始线程
       }

       // 第二个线程入口
       public void run() {
          try {
             for(int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                // 暂停线程
                Thread.sleep(50);
             }
         } catch (InterruptedException e) {
             System.out.println("Child interrupted.");
         }
         System.out.println("Exiting child thread.");
       }
}

class ThreadDemo {
    public static void main(String[] args) {
//        var list = new ArrayList<Integer>();
//        int[] ints = new int[10];
//        Arrays.fill(ints,10);
//        System.arraycopy(ints,1,ints,3,5);
//        list.stream().map(b -> b.compareTo(10));
        new NewThread(); // 创建一个新线程
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");


    }
}
         
