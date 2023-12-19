package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;


class Solution {

    /**
     * 最长公共前缀 优化版本
     */

    public static String longestCommonPrefix(String[] strs) {
        int longest = 0;

        String longestStr = "";
        //判断是否为空串组
        if(strs.length==0){
            return "";
        }

        //获得最长的字符串
        for (String str : strs) {
            if (str.length() > longest){
                longest = str.length();
                longestStr = str;
            }
        }

        //两两匹配 把匹配后的作为新的字符串继续匹配 直至全部匹配过 剩下的就是匹配到的
        for (String str : strs){
            int i = 0;
            for (; i < str.length(); i++){
                if (str.charAt(i) != longestStr.charAt(i)){
                    break;
                }
            }
            longestStr = longestStr.substring(0,i);
            if (longestStr.equals(" ")){
                return longestStr;
            }
        }
        return longestStr;
    }

    /*
    自己写的版本
     */

    public static String longestCommonPrefix1(String[] strs) {
        int longest = 0;

        String longestStr = "";

        for (String str : strs) {

            if (str.length() > longest){
                longest = str.length();
                longestStr = str;
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (String str : strs){
            int n = 0;
            for (int i = 0; i < str.length(); i++){
                if (str.charAt(i) == longestStr.charAt(i)){
                    n++;
                }else{
                    break;
                }
            }
            list.add(String.valueOf(n));
            System.out.println(list);
        }
        Iterator<String> iterator = list.iterator();
        int element = 999;
        // 遍历集合
        while (iterator.hasNext()) {
            // 获取下一个元素
            int i = Integer.parseInt(iterator.next());
            if (i <= element){
                element = i;
            }
            // 打印元素
            //System.out.println(element);
        }
        if (element == 0){
            return "";
        }
        longestStr = longestStr.substring(0,element);
        return longestStr;
    }

    public static void main(String[] args) {
        //String[] strings = {"flower","flow","flight"};
        String[] strings = {"cir","car"};
        System.out.println(longestCommonPrefix(strings));
        longestCommonPrefix1(strings);
    }
}
