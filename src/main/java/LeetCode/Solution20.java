package LeetCode;

import java.util.Arrays;

public class Solution20 {
    public static int heightChecker(int[] heights) {
        int[] oldheights = new int[heights.length];
        System.arraycopy(heights, 0, oldheights, 0, heights.length);
        Arrays.sort(heights);
        int length = heights.length;
        int count = 0;
        for(int i = 0; i < length; i++){
            if(oldheights[i] != heights[i]){
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        int i = heightChecker(heights);
        System.out.println(i); // 3
    }
}
