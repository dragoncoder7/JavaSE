package Test;

import java.util.Date;

public class Thread {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10; i++) {
            Date date = new Date();
            System.out.println("现在的时间："+ date + "\n"+i);
            java.lang.Thread.sleep(5000);
        }
    }
}
