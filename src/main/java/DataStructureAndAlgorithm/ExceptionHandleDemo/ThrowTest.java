package DataStructureAndAlgorithm.ExceptionHandleDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowTest {
    public static void main(String[] args) throws FileNotFoundException {
      throwsTest();
    }
    public static void throwsTest() throws FileNotFoundException{
        new FileInputStream("/home/project/shiyanlou.file");
    }
}
