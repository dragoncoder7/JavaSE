package LanQiao;

import java.util.Scanner;

public class OneTwoThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] begin = new int[T+1];
        int[] end = new int[T+1];
        int[] sum = new int[T];
        for(int i = 1; i <= T; i++){
            begin[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        int count = 0;
        for(int n = 1; n <= end[n]; n++){
            for (int m = 1; m <= n; m++){
                if (count >= begin[n] && count <= end[n])
                    sum[n-1] += m;
                count ++;
                System.out.print(m);
            }
        }
        for (int s:sum
             ) {
            System.out.println(s);
        }
        sc.close();
    }
}
