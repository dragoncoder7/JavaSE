package LanQiao;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int line = scan.nextInt();
        long[] ans = new long[line];
        for (int i = 0; i < line; i++){
                long A = scan.nextInt();
                long B = scan.nextInt();
                long C = scan.nextInt();

                long left = A%C;
                if(A < C){
                    ans[i] = B;
                    continue;
                }
                long turn = A/C + 1;
                if (B % turn > 0){
                    ans[i] = B/turn + 1;
                }else {
                    ans[i] = B/turn;
                }
        }
        for (int i = 0; i < line; i++) {
            System.out.println(ans[i]);
        }
        scan.close();
    }
}
