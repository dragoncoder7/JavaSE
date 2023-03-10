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
            System.out.println(random.nextInt(n, m));
        } else {
            System.out.println(random.nextInt(m, n));
        }
        sc.close();
    }
}