import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Main {
    public static void main(String[] args) throws Exception{
        new ReentrantLock(true);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
            ExecutorService executorService = Executors.newScheduledThreadPool(1);
        ExecutorService executorService1 = Executors.newWorkStealingPool(1);


        int corePoolSize = 5;
        int maximumPoolSize = 10;
        long keepAliveTime = 5;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(10);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue, handler);
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<100; i++) {
            try {
                int finalI = i;
                executor.execute(new Thread(() -> list.add(finalI)));
            } catch (Exception e) {
                log.error(e.getMessage(),e);
            }
        }
        executor.shutdown();
        System.out.println(list.size());
        System.out.println(list);
    }
    public static String template(){
        return "{\n" +
                "   \"lan\": \"CN\",\n" +
                "   \"userId\": null,\n" +
                "   \"phoneNumber\": \"\",\n" +
                "   \"userName\": \"\",\n" +
                "   \"userDesc\": \"\",\n" +
                "   \"userType\": \"\",\n" +
                "   \"userFullName\": \"\",\n" +
                "   \"employeeNumber\": \"\"\n" +
                " }";
    }
}