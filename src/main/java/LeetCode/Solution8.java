package LeetCode;

import java.util.Date;

class Solution8 {

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        System.out.println(solution8.strStr("hello", "ll"));
    }
    public int strStr(String haystack, String needle) {
        if (haystack.contains(needle)){
            return haystack.indexOf(needle);
        }else {
            return -1;
        }
    }

    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        
        int sss = 0, ttt = 0;
        for (char value : ss) {
            sss += value;
        }
        for (char c : tt) {
            ttt += c;
        }
        return (sss == ttt);
    }
}

