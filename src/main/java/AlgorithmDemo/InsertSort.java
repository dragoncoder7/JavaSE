package AlgorithmDemo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InsertSort {
    public static void InsertSort (int[] arr ) {
        int j, t;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < arr[i - 1]){
                t = arr[i];
                for (j = i - 1; j >= 0 && arr[j] > t; j--){
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {34,77,58,66,92,18};
        InsertSort.InsertSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
