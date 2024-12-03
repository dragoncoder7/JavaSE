package Thread;

public class ThreadStudy implements Runnable {

    @Override
    public void run() {
        System.out.println("this is my runnable interface");
    }

    enum Size { small, middle, large }

    Size size;

    public static void main(String[] args) {
        int a = 250;
        int b = 377;
        System.out.println(a );
        Size c = Size.small;
        // 创建Runnable的实例
        ThreadStudy threadStudy = new ThreadStudy();
        // 创建Thread对象，并传入Runnable实例
        Thread thread = new Thread(threadStudy);
        // 启动线程
        thread.start();
    }
}
