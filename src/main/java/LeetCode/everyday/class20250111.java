package LeetCode.everyday;

public class class20250111 {
    public static void main(String[] args) {
        class20250111 class20250111 = new class20250111();
        System.out.println(class20250111.generateKey1(1,10,1000));
    }

    public int generateKey1(int num1, int num2, int num3) {

        int res = 0;
        int multiple = 1;
        for (int i = 0; i < 4; i++) {
            int n1 =  num1 % 10;
            int n2 =  num2 % 10;
            int n3 =  num3 % 10;
            res += Math.min(n1,Math.min(n2,n3)) * multiple;
            multiple *=10;
            num1 = (num1 - n1)/10;
            num2 = (num2 - n2)/10;
            num3 = (num3 - n3)/10;
        }
        return res;
    }

    public int generateKey(int num1, int num2, int num3) {
        int[] ints = new int[]{num1, num2, num3};
        String[] transformed = new String[ints.length];
        for (int i = 0; i < ints.length; i++) {
            transformed[i] = transform(ints[i]);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            int a = transformed[0].charAt(i) - '0';
            int b = transformed[1].charAt(i) - '0';
            int c = transformed[2].charAt(i) - '0';
            sb.append(Math.min(c,Math.min(a,b)));
        }
        return Integer.parseInt(sb.toString());
    }
    String transform(int value){
        if (value < 1000){
            StringBuilder res = new StringBuilder(String.valueOf(value));
            while (res.length() < 4){
                res.insert(0, "0");
            }
            return res.toString();
        }else {
            return String.valueOf(value);
        }
    }
}
