package DataStructureAndAlgorithm.StringStudy;

public class StringBuilderDemo {

    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("i love you, mom");//默认初始容量为16
        sb.append(" and dad");
        System.out.println(sb+"\tcap"+sb.capacity());
    }
}
