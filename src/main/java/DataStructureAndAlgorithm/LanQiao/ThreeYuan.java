package DataStructureAndAlgorithm.LanQiao;

import java.util.Scanner;

public class ThreeYuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0;i < n; i++){
            a[i] = sc.nextInt();
        }
        for (int i = 0;i < n; i++){
            b[i] = sc.nextInt();
        }
        for (int i = 0;i < n; i++){
            c[i] = sc.nextInt();
        }
        int[][][] abc = new int[n][n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    if( abc[i][j][k] >= 1 && abc[i][j][k] <= n ){
                        if(a[i] < b[j] && a[i] < c[k] && b[j] < c[k])
                            sum++;

                    }
                }
            }
        }
        System.out.println(sum);
    }
}
