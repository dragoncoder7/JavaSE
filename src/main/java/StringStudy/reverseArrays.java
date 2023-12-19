package StringStudy;

public class reverseArrays {
    public static void main(String[] args) {
        int[] arrs ={1,3,5,7,9,11,13,15,17,19};
        int n = arrs.length;
//        for (int i = 0; i != n; i++) {
//            if(i != n)
//                swap
//        }
        int[] newarrs = new int[n];
        for (int i = n; i >=0 ; i--) {
            newarrs[n-i] = arrs[i];
        }
        System.out.println(newarrs);
    }
//    public void swap(int a, int b){
//        int t = b;
//        b = a;
//        a = t;
//    }
}
