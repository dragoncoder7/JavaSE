package RegularClass.Test;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] ints = {6,17,92,32,58,22,84,66,36,33};
        //Arrays.sort(ints);
        int i = Arrays.binarySearch(ints, 33);
        System.out.println(i);
    }

}
