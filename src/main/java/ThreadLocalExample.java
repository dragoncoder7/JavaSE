import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocalExample {

    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int releases) {
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        final ConditionObject newCondition() {
            return new ConditionObject();
        }
    }

    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    public Condition newCondition() {
        return sync.newCondition();
    }

    private static final ReentrantLock reentrantLock = new ReentrantLock();
    ExecutorService executorService = Executors.newCachedThreadPool((runnable) -> {
        System.out.println("create new thread");
        return null;
    });

    ExecutorService executorService22 = Executors.newCachedThreadPool(new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return null;
        }
    });
    ExecutorService executorService1 = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));

    // 创建一个 ThreadLocal 变量
    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        // 启动多个线程，每个线程会有自己独立的 ThreadLocal 变量副本
        for (int i = 0; i < 5; i++) {
            new Thread(new Task()).start();
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {

            // 获取当前线程的 ThreadLocal 变量值
            Integer value = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + " initial value: " + value);

            // 修改当前线程的 ThreadLocal 变量值
            value += 1;
            threadLocal.set(value);

            // 再次获取当前线程的 ThreadLocal 变量值
            System.out.println(Thread.currentThread().getName() + " modified value: " + threadLocal.get());
        }
    }
}


