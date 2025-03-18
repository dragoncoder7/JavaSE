package LeetCode.Algorithm.Sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        ShellSort ShellSort = new ShellSort();
        System.out.println(Arrays.toString(ShellSort.shellSort(new int[]{12, 34, 54, 2, 3})));
    }

    /**
     * 插入排序 Plus，在插入排序的基础上有一个预排序的操作。用一个gap来减少数组的乱序。
     * 理解为先简单给很乱的稍微整理一下顺序，再用插入排序
     * gap 可以根据情况调整大小 默认不超过数组长度一半
     * 时间复杂度O(n^1.3)
     * 空间复杂度O(1)
     * @param nums 乱序数组
     * @return 有序数组
     */
    public int[] shellSort(int[] nums) {
        int n = nums.length;

        // 初始间隔（gap）为数组长度的一半，逐步缩小间隔
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // 对每个子序列进行插入排序x
            for (int i = gap; i < n; i++) {
                int temp = nums[i];
                int j;

                // 插入排序的逻辑
                // 为什么条件要用 j -= gap  因为插入排序是要在当前值小于前面的值条件下，往回比较大小的
                // nums[j - gap] 对j来说下标差为gap的前面的值 与temp 是一组的 为啥不用nums[j] 因为j在遍历 值会变化 提前存好
                // 当gap为1时 就是正常的插入排序算法
                for (j = i; j >= gap && nums[j - gap] > temp; j -= gap) {
                    nums[j] = nums[j - gap];//更新小值为大值
                }

                nums[j] = temp;//更新大值为小值
            }
        }
        return nums;
    }

    /**
     * 插入排序 Plus，在插入排序的基础上有一个预排序的操作。
     *
     * @param nums
     * @return
     */
//    public int[] shellSort1(int[] nums, int n){
//        int length = nums.length;
//        int gap = n;
//        while (gap > 1){
//            gap = gap / 3 + 1;
//            for (int i = n; i < n; i++) {
//
//            }
//        }
//    }
}
