package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution25 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        Solution25 s = new Solution25();
        //System.out.println(s.lengthOfLastWord("luffy is still joyboy"));
        String[] strings =  {"5","-2","4","C","D","9","+","+"};
        System.out.println(s.calPoints(strings));
    }
    public int lengthOfLastWord(String s) {
        s = s.trim();
        //String[] strings = s.split(" ",-1);
        //System.out.println("last word length = "+strings[strings.length-1].length());
        return s.length() - s.lastIndexOf(" ") - 1;
    }
    public int calPoints(String[] operations) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (String operation : operations) {
            switch (operation) {
                case "+":
                    list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
                    continue;
                case "C":
                    list.remove(list.size() - 1);
                    continue;
                case "D":
                    list.add(list.get(list.size() - 1) * 2);
                    continue;
                default:
                    list.add(Integer.parseInt(operation));
            }
        }
        for
        (int i : list) {
            res += i;
        }
        return res;
    }
}
