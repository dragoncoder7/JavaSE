package IO_Demo;

import java.io.*;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File inFile = new File("C:\\Users\\10262\\Desktop\\1.txt");

        File outFile = new File("C:\\Users\\10262\\Desktop\\3.txt");

        FileInputStream fileInputStream = new FileInputStream(inFile);

        FileOutputStream fileOutputStream = new FileOutputStream(outFile);
        System.out.println(inFile.getName());
        int c;
        while ((c = fileInputStream.read()) != -1){
            fileOutputStream.write(c);
        }
        fileInputStream.close();
        fileOutputStream.close();
        FileReader file = new FileReader("C:\\Users\\10262\\Desktop\\1.txt");
        int data = 0;
        while ((data = file.read()) != -1){
            System.out.println((char) data);
        }
        file.close();
    }
}
