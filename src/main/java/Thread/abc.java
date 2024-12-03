package Thread;

import java.io.*;

public class abc {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            try {
                int a = br.read();
                System.out.println(a);
                String data = br.readLine();
                if (data.contains("abc")){
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        try {
            InputStream f = new FileInputStream("C:\\Users\\maoyunlong\\Desktop\\Study.txt");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
