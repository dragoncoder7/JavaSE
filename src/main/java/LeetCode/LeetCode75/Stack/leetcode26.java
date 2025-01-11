package LeetCode.LeetCode75.Stack;

import java.util.LinkedList;
import java.util.Stack;

public class leetcode26 {
    public static void main(String[] args) {
        leetcode26 leetcode26 = new leetcode26();
        //System.out.println(leetcode26.decode(2,"abc"));
        System.out.println(leetcode26.decodeString2("ab2[abc]3[cd]ef"));//abcabccdcdcdef
    }
    public String decodeString2(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                tmp.append(String.valueOf(res).repeat(Math.max(0, cur_multi)));
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }
    public String decodeString1(String s) {
        int i = 0;
        return innerString(s,i)[0];
    }

    public String[] innerString(String s, int i){
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count = count * 10 + Character.getNumericValue(c);
            }else if (c == '['){
                String[] tempStrings = innerString(s,i + 1);
                String temp = tempStrings[0];
                i = Integer.parseInt(tempStrings[1]);
                while (count > 0){
                    stringBuilder.append(temp);
                    count--;
                }
            } else if (c == ']') {
                return new String[]{stringBuilder.toString(), String.valueOf(i)};
            } else {
                stringBuilder.append(c);
            }
            i++;
        }
        return new String[]{stringBuilder.toString()};
    }

    public StringBuilder repeatString(int count , String s, int i){
        i++;
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        while (s.charAt(i) != ']'){
            if (Character.isDigit(s.charAt(i))){
                temp.append(repeatString(Character.getNumericValue(s.charAt(i)), s, i));
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
    public StringBuilder judge(char c, String s) {
        if (Character.isDigit(c)) {
            //return repeatString(Character.getNumericValue(c), s).reverse();
        } else if (c == ']' || c == '[') {
            return new StringBuilder();
        } else {
            return new StringBuilder(String.valueOf(c));
        }
        return null;
    }




    //------------------------------------------------------------------------
    public String decodeString(String s) {
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
