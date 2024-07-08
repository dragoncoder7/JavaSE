package DataStructureAndAlgorithm.ExceptionHandleDemo;

import java.util.Arrays;

public class ExceptionTest {
    public static void main(String[] args) {
        int[] array = new int[5];

        Arrays.fill(array, 5);
        for (int i = 4; i > -1; i--) {
            //使用for循环逆序遍历整个数组，i每次递减

            if (i == 0) {
                // 如果i除以了0，就使用带异常信息的构造方法抛出异常

                throw new MyAriException("There is an exception occured.");
            }

            System.out.println("array[" + i + "] / " + i + " = " + array[i] / i);
        }
    }
}
