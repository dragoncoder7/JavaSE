package BranchStudy;

public class shuzu {
//    private  int teacher;
//    private  String student;
//    public  shuzu(int teacher, String student){
//         this.teacher  = teacher;
//         this.student  = student;
//    }
//    public  String good(){
//        return "good good good";
//    }
    public static void main(String[] args) {
//       shuzu t = new shuzu(1,"123");
//        System.out.println(t.good());
//        System.out.println(t.student);
//       int[] ints = {1,2,3,4,5,6,7,8,9,10};
//       String[] strings = {"adsfds","sadsagf","fttsdf15"};
//        for (int i: ints
//             ) {
//            System.out.println(i);
//        }
//        for (String s : strings
//             ) {
//            System.out.println(s);
//        }
        /*String[][] name = {{"ZhaoYi", "QianEr", },
                {"LiSi", "ZhouWu", },{"SunSan","WuLiu"}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(name[i][j]+" ");
            }
            System.out.println();
        }*/
        int[] grades = {61,57,95,85,75,65,44,66,90,32};
        int sum = 0;
        for (int grade : grades
             ) {
            sum += grade;
        }
        float avg = sum / grades.length;
        System.out.println(avg);
    }
}
