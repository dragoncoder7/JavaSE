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
     * 冒泡排序 两两一对比 如果前面的数比后面的大 就交换位置 大的泡泡冒上去
     * 同理也可以实现从大到小的倒排 即前面的数小于后面的交换即可
     * 时间复杂度最坏O(n^2) 最好O(n) 接近升序/升序
     * 空间复杂度O(1)
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
