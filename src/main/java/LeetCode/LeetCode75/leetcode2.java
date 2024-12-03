package LeetCode.LeetCode75;

public class leetcode2 {
    public String gcdOfStrings(String str1, String str2) {
        int max = Math.min(str1.length(),str2.length());
        for (int i = max; i >= 1; i--) {
            String suffix ;
            if (str1.length() <= str2.length()){
                suffix = str1.substring(0,i);
            }else {
                suffix = str2.substring(0,i);
            }
            if (check(suffix,str1) && check(suffix,str2)){
                return suffix;
            }
        }
        return "";
    }

    public boolean check(String a, String b){
        StringBuilder sb = new StringBuilder(a);
        while (sb.length() <= b.length()){
            if (sb.toString().equals(b)){
                return true;
            }else {
                sb.append(a);
            }
        }
        return false;
    }
}
