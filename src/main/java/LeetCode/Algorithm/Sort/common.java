package LeetCode.Algorithm.Sort;

public class common {
    public static void main(String[] args) {
        common common = new common();
        System.out.println();
    }
    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
