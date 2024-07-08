package DataStructureAndAlgorithm.StringStudy;

public class weiyunsuan {
    public static void main(String[] args) {
        int a=60;

        String s=Integer.toBinaryString(a);
        System.out.println(s);
        System.out.println(a);
        a=a>>>2;
        s=Integer.toBinaryString(a);
        System.out.println(s);
        System.out.println(a);
        int b=100;
        int t=a>b?a+b:a-b;
        System.out.println(t);

    }
}
