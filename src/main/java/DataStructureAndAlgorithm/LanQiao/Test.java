package DataStructureAndAlgorithm.LanQiao;

public class Test {
    public static void main(String[] args) {
        int count = 0;
        for(int n = 1; n < 6; n++){
            for (int m = 1; m <= n; m++) {
                System.out.print(m);

                count++;
                if(count == 8)
                    break;
            }
        }
        System.out.println();
        System.out.println(count);
    }
}
