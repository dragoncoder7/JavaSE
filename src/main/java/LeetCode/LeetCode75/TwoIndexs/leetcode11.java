package LeetCode.LeetCode75.TwoIndexs;

public class leetcode11 {
    public static void main(String[] args) {
        leetcode11 leetcode11 = new leetcode11();
        leetcode11.isSubsequence1("aaaaaa","bbaaaa");
    }
    public boolean isSubsequence(String s, String t) {
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(i,i+1);
            if (t.substring(j).contains(left)){
                j = t.substring(j).indexOf(left) + j + 1;
            }else return false;
        }
        return true;
    }

    public boolean isSubsequence1(String s, String t) {
        int sn = s.length();
        int tn = t.length();

        int si = 0;
        int ti = 0;
        while (si < sn && ti < tn) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
            }
            ti++;
        }

        return si == sn;
    }

}
