package LeetCode.Algorithm.Sort;

import java.util.Arrays;

public class InsertSort {
    private int sb = 0;

    private static int b = 123;

    public static void main(String[] args) {

        InsertSort InsertSort = new InsertSort();
        InsertSort.inner in =  InsertSort.new inner(); //声明类 a.b 说明b是a的内部类 InsertSort.inner 通过a的实例去实例化内部类InsertSort.new inner()
        int a = in.getA();

        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(InsertSort.insertSort(nums)));
    }

    /**
     * 插入排序 如果遍历到现在的值比它下一个位置的值大 就需要排序
     * 然后从该位置下标一直往回匹配 到合适位置 再插入
     * 默认排序是从小到大
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param nums 数组
     * @return 排序后数组
     */
    public int[] insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                int temp = nums[i];//记录要插入的值
                int j;//记录要插入的位置 随着遍历会往前找 遍历结束的位置就是要插入（在该下标后）的位置
                for (j = i - 1; j >= 0 && nums[j] > temp; j--) {
                    nums[j + 1] = nums[j];
                }

//                for (j = i - 1; j >= 0 && nums[j] > temp ; j--) {
//                    //把前面大的值往后排 调整顺序
//                    nums[j + 1] = nums[j];
//                }
//                nums[j + 1] = temp;
            }
        }
        return nums;
    }

    //插入排序
//两次循环就可以实现
//内部循环完成一趟的插入
//外层循环完成插入排序
    public class inner {
        private static final int a = 0;

        private String s = "abc";


        public int getA() {
            System.out.println(b);
            System.out.println();
            return a;
        }
    }
}
