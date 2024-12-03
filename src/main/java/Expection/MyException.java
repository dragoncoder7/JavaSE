package Expection;

import java.util.Scanner;

public class MyException extends Exception{

    String message;

    public MyException(String message){
        this.message = message;
    }

    public String getInfo(){
        return message;
    }

    public static void main(String[] args) {
        try {
            int ans = 100;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()){

                int input = scanner.nextInt();
                if (input != ans){
                    throw new MyException("没有猜对！");
                }else {
                    throw new MyException("恭喜你猜对了！");
                }

            }

        } catch (MyException e) {
            System.out.println(e.message);
            e.printStackTrace();
        }
    }
    public static class TestException extends MyException{

        public TestException(String message) {
            super(message);
        }

        public static void main(String[] args) {
            TestException exception =  new TestException("test");
            System.out.println(exception.message);
        }
    }
}
