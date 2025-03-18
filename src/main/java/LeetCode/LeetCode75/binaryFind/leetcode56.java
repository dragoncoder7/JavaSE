package LeetCode.LeetCode75.binaryFind;

public class leetcode56 {
    public static void main(String[] args) {
        leetcode56 leetcode56 = new leetcode56();
        System.out.println(leetcode56.minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }
        int k = right;
        while (left < right) {
            int speed = left + (right - left) / 2;
            int time = eatBanana(piles, speed);
            if (time <= h) {
                k = speed;
                right = speed;
            }else {
                left = speed + 1;
            }
        }
        return k;
    }

    private int eatBanana(int[] piles, int speed) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed;
        }
        return time;
    }
}
