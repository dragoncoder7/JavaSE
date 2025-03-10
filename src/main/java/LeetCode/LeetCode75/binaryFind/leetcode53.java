package LeetCode.LeetCode75.binaryFind;

public class leetcode53 {

    int res = 6;
    public static void main(String[] args) {
        leetcode53 leetcode53 = new leetcode53();
        System.out.println(leetcode53.guessNumber(10));
    }
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0){
                return mid;
            } else if (res > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    int guess(int num){
//        res = (int) (Math.random() * n);
//        System.out.println("生成的随机结果为："+res);
        if (num == res){
            return 0;
        } else if (num > res){
            return -1;
        } else {
            return 1;
        }
    }
}
