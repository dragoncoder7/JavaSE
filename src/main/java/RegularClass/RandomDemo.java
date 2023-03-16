package RegularClass;

import java.util.Random;
import java.util.Scanner;


public class RandomDemo {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        if (m > n){
            System.out.println(random.nextInt(m - n + 1) + n);
        } else {
            System.out.println(random.nextInt(n - m + 1) + m);
        }
        sc.close();
    }
}