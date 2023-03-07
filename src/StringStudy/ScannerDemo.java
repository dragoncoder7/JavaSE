package StringStudy;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        System.out.println("请输入数字：");
        Scanner scan = new Scanner("新建文本文档.txt");
//        scan.
//        double sum = 0;
//        int m = 0;
//
//        while (scan.hasNextDouble()) {
//            double x = scan.nextDouble();
//            m = m + 1;
//            sum = sum + x;
//        }
//
//        System.out.println(m + "个数的和为" + sum);
//        System.out.println(m + "个数的平均值是" + (sum / m));

        System.out.println(scan.delimiter());
        scan.close();

    }
}
