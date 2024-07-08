package DataStructureAndAlgorithm.RegularClass;

import java.util.Arrays;
import java.util.Random;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] ints = new int[10];
        Arrays.fill(ints, 9);
        System.out.println(Arrays.toString(ints));
        Random random = new Random();
        for(int i = 0; i < ints.length; i++){
            ints[i] = random.nextInt(101);
        }
        System.out.println(Arrays.toString(ints));
        ints[5] = 50;
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        int i = Arrays.binarySearch(ints, 50);
        System.out.println(i);
        int[] ints1 = Arrays.copyOf(ints,ints.length);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.equals(ints, ints1));
    }
}
