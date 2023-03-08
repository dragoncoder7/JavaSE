package BranchStudy;

public class switchStudy {
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        while (i <= 1000){
            if(i % 2 == 0){
                sum += i;
            }
            i++;
        }
        System.out.println(sum);
        sum = 0;
        i = 0;
        do {
            if(i % 2 == 0){
                sum += i;
            }
            i++;
        } while (i <= 1000);
        System.out.println(sum);
        sum=0;
        for(i = 0; i <= 1000; i++){
            if(i % 2 == 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
