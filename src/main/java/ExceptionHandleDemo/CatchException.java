package ExceptionHandleDemo;

public class CatchException {
    public static void main(String[] args) {
        try {
            System.out.println("I am try block.");

            Class<?> tempClass = Class.forName("");

            System.out.println("bye! try block.");

        }catch (ClassNotFoundException e){
            System.out.println("I am catch block.");
            e.printStackTrace();
        }finally {
            System.out.println("I am a finally block.");
        }
    }
}
