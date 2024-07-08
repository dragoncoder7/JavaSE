package DataStructureAndAlgorithm.RegularClass;

import java.util.Arrays;

public class SystemDemo {
    public static void main(String[] args) {
        System.out.println(System.getProperties());
        System.currentTimeMillis();
        System.gc();

        int[] i1 = {1, 77, 91, 56, 22, 66};
        int[] i2 = {8, 57, 21, 36, 72, 6};
        System.out.println(System.getProperty("java.home"));
        System.arraycopy(i1, 3,i2,2,3);
        System.out.println(Arrays.toString(i1));
        System.out.println(Arrays.toString(i2));
    }
}
