package LeetCode;
public class Solution26 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        String s = "UD";
        Solution26 s26 = new Solution26();
        System.out.println(s26.judgeCircle(s));
    }

    public boolean judgeCircle(String moves) {

        int[] ints = {0,0};

        for(int i = 0; i < moves.length(); i++){
            switch (moves.charAt(i)){
                case 'L' :
                    ints[0]--;
                    continue;
                case 'R' :
                    ints[0]++;
                    continue;
                case 'U' :
                    ints[1]++;
                    continue;
                case 'D' :
                    ints[1]--;
            }
        }
        return ints[0] == 0 && ints[1] == 0;
    }
}
