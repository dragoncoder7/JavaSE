package LeetCode.Solution;
public class Solution42 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        Solution42 solution42 = new Solution42();
        System.out.println(solution42.multiply1("5423396","5424012638"));
        System.out.println(solution42.addBinary("1010", "1011"));
    }

    /**
     * 二进制数字符串相加 返回一个二进制的结果字符串
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = Math.max(a.length(),b.length());

        int aa,bb,step = 0;

        for (int i = 0; i < length; i++) {
            aa = (i + 1) > a.length() ? 0 : Integer.parseInt(String.valueOf(new StringBuilder(a).reverse().charAt(i)));
            bb = (i + 1) > b.length() ? 0 : Integer.parseInt(String.valueOf(new StringBuilder(b).reverse().charAt(i)));
            stringBuilder.append(((aa + bb + step) % 2));
            step = (aa + bb + step) / 2;
        }
        if (step != 0){
            stringBuilder.append(step);
        }
        return stringBuilder.reverse().toString();
    }

    public String multiply(String num1, String num2) {
        int length = Math.max(num1.length(), num2.length());

        double ans = 0;
        for (int i = 0; i < length; i++) {
            double a = i + 1 > num1.length() ? 0 : num1.charAt(num1.length() - 1 - i) - '0';
            double b = Double.parseDouble(num2);
            ans += a * b * Math.pow(10,i);
        }
        return String.valueOf(ans).substring(0,String.valueOf(ans).length() - 2);
    }

    public String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
