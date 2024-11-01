package demo.Demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<String>{

    @Override
    public String call() {
        System.out.println("call success");
        return "system call";
    }

    public static void main(String[] args) throws Exception {
        Callable<String> callable = new CallableDemo();

        FutureTask<String> future = new FutureTask<>(callable);
        Thread thread = new Thread(future);
        thread.start();
        System.out.println(future.get());
    }
}
