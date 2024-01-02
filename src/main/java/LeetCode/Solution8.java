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

    public void changeDate(Date createTime){
        int month = createTime.getMonth();
        int year = createTime.getYear();
    // 处理月份和年份
        int targetFinishYear = month >= 3 ? year : year - 1;
        int targetYear = month >= 3 ? year + 1 : year;
        int targetResultYear = month >= 3 ? year : year - 1;
    }
}

