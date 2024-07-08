package DataStructureAndAlgorithm.LanQiao;


import java.util.Scanner;

public class ScoreEval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int n = scan.nextInt();
        int[] scores = new int[n];
        float sum = 0;
        if (n >= 1 && n <= 10000){
            int i = 0;
            while (true){
                if (scan.hasNext()){
                    scores[i] = scan.nextInt();
                }
                sum += scores[i];
                if(i == n - 1){
                    break;
                }
                System.out.println(" n = "+n + " i = "+i);
                i++;
            }
        }
        int max = scores[0];
        int min = scores[0];
        for (int s:scores
             ) {
            if ( s >= max)
                max = s;
            if ( s <= min)
                min = s;
        }
        System.out.println(sum);
        double avg = sum / n;
        System.out.println(max);
        System.out.println(min);
        System.out.printf("%.2f", avg);
        scan.close();
    }
}
