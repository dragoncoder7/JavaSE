package IO_Demo;

import java.io.*;
import java.util.Scanner;

public class FileCut {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        File file = new File("C:\\Users\\10262\\Desktop\\cut.txt");
        int num;
        //如果不能整除，那么需要多加一个文件 用于保存剩余的数据
        if (file.length() % n == 0) {
            num = (int) (file.length() / n);
        } else {
            num = (int) (file.length() / n) + 1;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            //读取文件到bytes
            fileInputStream.read(bytes);
            fileInputStream.close();
            for (int i = 1; i <= num; i++) {
                //文件名
                String fileName = "C:\\Users\\10262\\Desktop\\cut" + i + ".txt";
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                //最后一份文件需要特殊处理 因为他的大小不是n
                if (i == num) {
//                    (file.length()-n*(i-1)) 文件的总字节数 再减去前面已经读取的字节数 就是剩余的字节数
                    fileOutputStream.write(bytes, n * (i - 1), (int) (file.length() - n * (i - 1)));
                } else {

                    fileOutputStream.write(bytes, n * (i - 1), n);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}