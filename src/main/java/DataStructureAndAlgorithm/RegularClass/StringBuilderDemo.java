package DataStructureAndAlgorithm.RegularClass;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("maoyunlongzhendeshuai");
        sb.append("zhale");
        sb.insert(0,"nijiade");
        System.out.println(sb);
        sb.setCharAt(5,'o');
        System.out.println(sb);
        System.out.println(sb.reverse());
        sb.replace(0,10,"mama,nideerzi");
        System.out.println(sb.reverse());
        sb.delete(0,10);
        System.out.println(sb);

    }
}
