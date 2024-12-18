package LeetCode.LeetCode75;

public class leetcode12 {
    public static void main(String[] args) {
        leetcode12 leetcode12 = new leetcode12();

        int res = leetcode12.maxArea(new int[]{1,1});
        System.out.println(res);
    }
    public int maxArea(int[] height) {
        int n = height.length;
        int res = (n - 1) * Math.min(height[height.length - 1],height[0]) ;
        int left = 0,right = n - 1;
        while (left != right){
            if (height[left] <= height[right]){
                left++;
            }else {
                right--;
            }
            int ans = (right - left) * Math.min(height[left],height[right]);
            res = Math.max(res,ans);
        }
        return res;
    }
}
