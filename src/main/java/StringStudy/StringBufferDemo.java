package StringStudy;

public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer("i will study hard");
        sb.setLength(30);
        sb.setCharAt(7, 'c');
        System.out.println(sb);
    }
}
