package DataStructureAndAlgorithm.LanQiao;

import java.util.Scanner;

public class BeverageExchange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        if(n <= 0 || n >= 1000){
            System.out.println("n值超出范围");
        }
        int sum = BeverageExchange.function(n);
        System.out.println(sum+n);  // 方法一

        scan.close();
    }
    public static int function(int n){
        int i = n / 3;
        int left = n % 3;
        if ( n < 3)
            return i;
        int sum = i + function(i + left);
        System.out.println(i);
        return sum;
    }
}
