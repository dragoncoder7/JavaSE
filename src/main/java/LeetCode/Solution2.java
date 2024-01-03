package LeetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    public static String reverseWords(String s) {

        String[] strings = s.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].trim();
            if (!strings[i].isEmpty() && !strings[i].isBlank()){
                list.add(strings[i].trim());

            }
        }


        StringBuilder t = new StringBuilder();
        for (String string : list) {
            t.append(string.trim()).append(" ");
        }
     return String.valueOf(t).trim();
    }

    /**
     * 参考答案
     * @param s 传入的字符串
     * @return 返回值
     */
    public String reverseWords1(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }



    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
        //
        Solution2 solution2 =  new Solution2();
        System.out.println(solution2.reverseWords1(s));
    }
}
