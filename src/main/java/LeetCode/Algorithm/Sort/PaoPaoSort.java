package LeetCode.Algorithm.Sort;

import java.util.Arrays;

/**
 * 冒泡排序算法
 */
public class PaoPaoSort {

    public static void main(String[] args) {
        PaoPaoSort PaoPaoSort = new PaoPaoSort();
        System.out.println(Arrays.toString(PaoPaoSort.paopaoSort(new int[]{3, 9, -1, 10, 20})));
    }

    /**
     * 冒泡排序
     * 时间复杂度O(n^2)
     * 空间复杂度O(n)
     * @param nums 需要排序的数组
     * @return 排序后的数组结果
     */
    public int[] paopaoSort(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 1; j < n - i; j++) {
                if (nums[j - 1] > nums[j]){
                    swap(j - 1, j, nums);
                    count++;
                }
            }
            if (count == 0){
                return nums;
            }
        }
        return nums;
    }
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
