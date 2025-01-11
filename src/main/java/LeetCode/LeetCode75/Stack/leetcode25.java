package LeetCode.LeetCode75.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class leetcode25 {
    public static void main(String[] args) {
        leetcode25 leetcode25 = new leetcode25();
        System.out.println(Arrays.toString(leetcode25.asteroidCollision(new int[]{10,2,-5})));
    }
    public int[] asteroidCollision1(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster; // aster 是否存在
                if (stack.peek() <= -aster) {  // 栈顶行星爆炸
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        stack.push(asteroids[0]);
        for (int i = 1; i < n; i++) {
            int left = stack.peek();
            int right = asteroids[i];
            if (judgeDirection(left,right)){
                while (judgeDirection(left,right)){
                    if (Math.abs(left) == Math.abs(right)){
                        stack.pop();
                    }
                    if (Math.abs(left) > Math.abs(right)){

                    }else {

                    }
                    left = stack.peek();
                }
            } else {
                stack.push(right);
            }
        }
        for (int i : asteroids) {

            int top = stack.peek();
            while ((top > 0 && i < 0) || (top < 0 && i > 0)) {
                //stack.get(stack.size()-2);
                //continue;
                if (top + i == 0){
                    stack.pop();
                }else {
                    if (Math.abs(top) < Math.abs(i)){
                        stack.pop();
                        top = stack.peek();
                        stack.push(i);
                    }
                }
            }
            stack.push(i);

        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.get(i);
        }
        return res;
    }
    public boolean judgeDirection(int left, int right){
        return left * right < 0;
    }
}
