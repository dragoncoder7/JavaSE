package LeetCode.Algorithm.Sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort SelectionSort = new SelectionSort();
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(SelectionSort.selectSort(nums)));
    }

    /**
     * 选择排序 通过两个指针 一个为排序指针 一个为子循环找最小值指针
     * 交换排序指针和最小值指针位置 实现排序 即 第一次找数组中最小的 跟第一个值交换 第二次找除了第一个外 最小的 跟第二个位置的值交换位置
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param nums 乱序数组
     * @return 有序数组
     */
    public int[] selectSort(int[] nums){
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (nums[j] < min){
                    min = nums[j];
                    index = j;
                }
            }
            common.swap(i, index, nums);
        }
        return nums;
    }
}
