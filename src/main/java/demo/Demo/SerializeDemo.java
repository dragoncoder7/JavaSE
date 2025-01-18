package demo.Demo;

import demo.Entity.Employee;

import java.io.*;

public class SerializeDemo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L; // 自定义的版本号



    public static void main(String[] args) {
        Employee employee = new Employee("zhangsan", "beijing", 123456, 123);
        
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\10262\\Desktop\\employee.ser");
            try {
                ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
                out.writeObject(employee);
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
