package IO_Demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {
    public void copy(InputStream in, OutputStream out) throws IOException {
        byte[] bytes = new byte[4096];
        int len = in.read(bytes);
        while (len != -1) {
            out.write(bytes,0,len);
            len = in.read(bytes);
        }
    }
    public static void main(String[] args) throws IOException {
        Test t = new Test();
        t.copy(System.in, System.out);
    }
}
