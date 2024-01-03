package LeetCode;

public class Solution11 {

    /*public static String longestPalindrome(String s) {
        String result = "";
        if (s.isEmpty()){
            return result;
        }
        int j = s.length() - 1;
        int i = 0;
        for (; i < s.length(); i++){
            if (s.charAt(i) == s.charAt(j)){
                break;
            }
        }
        if (i > j){
            result = s.substring(j,i);
        }else {
            result = s.substring(i,j);
        }
        return result;
    }*/
    /*public static String longestPalindrome(String s) {
        int[] result = new int[]{0, 0};
        int i = 0;
        char[] chars = s.toCharArray();
        while (i < chars.length) {
            // 下一个offset的i是从下一个整体单位开始的
            i = offset(i, chars, result);
        }
        return s.substring(result[0], result[1]);
    }

    public static int offset(int i, char[] chars, int[] result) {
        int high = i + 1;
        while (high < chars.length && chars[i] == chars[high]) {
            high++;
        }
        int next = high;
        // 获取到中间点,high++,i--对比是否相同
        while(i > 0 && high < chars.length && chars[i - 1] == chars[high]) {
            high++;
            i--;
        }
        if (high - i > result[1] - result[0]) {
            result[0] = i;
            result[1] = high;
        }
        return next;

    }*/


    //判断子串是否是回文串
    private static boolean validPalindromic(char[] chars, int left, int right){
        while (left < right){
            char a = chars[left];
            char b = chars[right];
            if (a != b){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
    /*解题思路：cbbd 从第一个字符开始 往后累加
    *一个字符的字符串 肯定是回文串 如c 截取的话 从（0，1）就是这个c
    * c cb cbb cbbd
    * b bb bbd
    * b bd
    * d
    * 如果有 就记下来这个串是从哪个下标到哪个下标 长度是多少
    * 如果后续还有 得判断这个新的回文串比之前的长没 长就替换 否则不管
    *
    */
    public static String longestPalindrome(String s) {
        if (s.length() < 2){
            return s;
        }
        char[] chars = s.toCharArray();
        int begin = 0;
        int maxLen = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++){
                if(j - i + 1 > maxLen && validPalindromic(chars,i,j)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
