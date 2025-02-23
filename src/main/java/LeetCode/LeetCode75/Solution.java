package LeetCode.LeetCode75;

import java.util.Stack;

public class Solution {
    int i = 0;
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString1("3[a2[c]]"));
        //abc  acbcb acbcb acbcb
    }

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * @param s 一个经过编码的字符串
     * @return 返回它解码后的字符串
     */
    public String decodeString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        while (i < s.length()){
            stringBuilder.append(judge(s.charAt(i),s));
            i++;
        }
        return stringBuilder.toString();
    }

    public StringBuilder repeatString(int count , String s){
        i++;
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        while (s.charAt(i) != ']'){
            if (Character.isDigit(s.charAt(i))){
                temp.append(repeatString(Character.getNumericValue(s.charAt(i)), s));
            }else {
                stack.push(s.charAt(i));
                i++;
            }
        }
        char c = stack.pop();
        while (c != '['){
            stringBuilder.append(c);
            c = stack.pop();
        }// a cbcb
        temp.append(stringBuilder);
        String res = temp.toString().repeat(count);
        return new StringBuilder(res);
    }
    public StringBuilder judge(char c, String s){
        if (Character.isDigit(c)){
            return repeatString(Character.getNumericValue(c), s).reverse();
        }else if (c == ']' || c == '['){
            return new StringBuilder();
        } else {
            return new StringBuilder(String.valueOf(c));
        }
    }



    //----------------------------------分割线     题解-------------------------------------------

    //递归

    /**
     * 总体思路与辅助栈法一致，不同点在于将 [ 和 ] 分别作为递归的开启与终止条件：
     * 当 s[i] == ']' 时，返回当前括号内记录的 res 字符串与 ] 的索引 i （更新上层递归指针位置）；
     * 当 s[i] == '[' 时，开启新一层递归，记录此 [...] 内字符串 tmp 和递归后的最新索引 i，并执行 res + multi * tmp 拼接字符串。
     * 遍历完毕后返回 res。
     * 作者：Krahets
     * 链接：<a href="https://leetcode.cn/problems/decode-string/solutions/19447/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/">...</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public String decodeString1(String s) {
        return dfs(s, 0)[0];
    }
    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while(i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            else if(s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while(multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            }
            else if(s.charAt(i) == ']')
                return new String[] { String.valueOf(i), res.toString() };
            else
                res.append(s.charAt(i));
            i++;
        }
        return new String[] { res.toString() };
    }
}
