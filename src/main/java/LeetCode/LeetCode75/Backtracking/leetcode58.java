package LeetCode.LeetCode75.Backtracking;

import java.util.*;

public class leetcode58 {
    public static void main(String[] args) {
        leetcode58 leetcode58 = new leetcode58();
        System.out.println(leetcode58.combinationSum3(3,7));
    }
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    /**
     * 暴力遍历 枚举每一种情况 把每位的值不为空的时候 就加到临时list里 遍历list查看值是否跟目标值一致。一致就加入
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int i = 0; i < (1 << 9); i++) {
            if (check(k, n, i)){
                ans.add(new ArrayList<>(temp));
            }
        }
        return ans;
    }

    public boolean check(int k, int n, int i){
        temp.clear();
        for (int j = 0; j < 9; j++) {
            if (((1 << j) & i) != 0){
                temp.add(j + 1);
            }
        }
        if (temp.size() != k){
            return false;
        }
        int sum = 0;
        for (int value : temp) {
            sum += value;
        }
        return sum == n;
    }


    static class Solution {
        private int targetK = 0;
        private int targetSum = 0;
        private List<List<Integer>> res;
        private LinkedList<Integer> subRes;

        public static void main(String[] args) {
            Solution leetcode58 = new Solution();

            System.out.println(leetcode58.combinationSum32(9,45));
        }
        public List<List<Integer>> combinationSum31(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            LinkedList<Integer> list = new LinkedList<>();

            backtracking(res, list, 1, k , n , 0);
            //a != b != c
            //a + b + c = n
            //a < n; b < n; c < n
            return res;
        }
        public void backtracking(List<List<Integer>> res, LinkedList<Integer> list, int index, int k, int n, int tempSum){
            if (tempSum == n && list.size() == k){
                res.add(new ArrayList<>(list));
                return;
            }
            if (list.size() == k) {
                return;
            }
            for (int i = index; i <= 9 && (10 - index) >= (k - list.size()); i++) {
                list.add(i);
                backtracking(res, list, i + 1, k, n, tempSum + i);
                list.removeLast();
            }
        }
        public List<List<Integer>> combinationSum3(int k, int n) {
            res = new ArrayList<>();
            subRes = new LinkedList<>();
            targetK = k;
            targetSum = n;
            test(0,0,1);
            return res;
        }

        public void test(int curK, int sum,int curNum){
            if (sum == targetSum && curK == targetK){
                res.add(new ArrayList<>(subRes));
                return;
            }
            if (curK == targetK){
                return;
            }
            //剪枝优化
            //(9 - curNum + 1) >= (targetK - curK)
            //(9 - curNum + 1)表示从当前数字 curNum 到 9 之间剩余可选数字的个数。
            //(targetK - curK)表示还需要选择的数字个数（k 是目标总数，curK 是已选数量）。
            //要求剩余可选数字的个数 ≥ 还需要选择的数字个数。

            for (int i = curNum;i <= 9 && (9 - curNum + 1) >= (targetK - curK);i++){
                subRes.add(i);
                test(curK + 1,sum + i,i + 1);
                subRes.removeLast();
            }

        }

        List<Integer> path=new ArrayList<>();
        public List<List<Integer>> combinationSum32(int k, int n) {
            callBack(k,n,1,0);
            return res;

        }

        public void callBack(int k,int n,int startflag,int sum){
            if(sum>n)return;
            if(k==path.size()){
                if(sum==n){
                    res.add(new ArrayList<>(path));
                }
                return ;
            }
            for(int i=startflag;i<=9-(k-path.size())+1;i++){
                path.add(i);
                callBack(k,n,i+1,sum+i);
                //path.removeLast();
            }
        }
    }


}
