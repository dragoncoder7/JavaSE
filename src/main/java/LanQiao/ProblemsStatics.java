package LanQiao;

import java.util.Scanner;

public class ProblemsStatics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int Workday = scan.nextInt();
        int Weekend = scan.nextInt();
        int n = scan.nextInt();
        int sum = 0;
        for (int i = 1; i < n;i++){
            switch (i % 7){
                case 5:

                case 6:
                    sum += Weekend;
                break;

                default: sum += Workday;
            }
            System.out.println(sum);
            if(sum >= n) {
                System.out.println(i);
                break;
            }
        }
        scan.close();
    }
}
