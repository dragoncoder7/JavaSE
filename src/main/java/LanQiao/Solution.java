package LanQiao;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
                //在此输入您的代码...
        long[] nums = new long[n];  // 存储输入的数字
        for (int i = 0; i < n; i++) {
            long blood = scan.nextInt();
            Monster monster = new Monster(blood,0,false);

        }
        for (int i = 0; i < k; i++) {
        }
        scan.close();
    }
    static class Monster {
        private long firstDefeat;
        private long againDefeat;

        private boolean isDefeated;

        public Monster(long firstDefeat, long againDefeat, boolean isDefeated) {
            this.firstDefeat = firstDefeat;
            this.againDefeat = againDefeat;
            this.isDefeated = isDefeated;
        }
        public Monster() {

        }

        public long getFirstDefeat() {
            return firstDefeat;
        }

        public void setFirstDefeat(long firstDefeat) {
            this.firstDefeat = firstDefeat;
        }

        public long getAgainDefeat() {
            return againDefeat;
        }

        public void setAgainDefeat(long againDefeat) {
            this.againDefeat = againDefeat;
        }

        public boolean isDefeated() {
            return isDefeated;
        }

        public void setDefeated(boolean defeated) {
            isDefeated = defeated;
        }

        @Override
        public String toString() {
            return "Monster{" +
                    "firstDefeat=" + firstDefeat +
                    ", againDefeat=" + againDefeat +
                    ", isDefeated=" + isDefeated +
                    '}';
        }
    }
}
