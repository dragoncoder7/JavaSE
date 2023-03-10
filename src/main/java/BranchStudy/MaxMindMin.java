package BranchStudy;

//import java.util.Arrays;

public class MaxMindMin {
    public static void main(String[] args) {
        int[] data = {313, 89, 123, 323, 313, 15, 90, 56, 39};
        /* 方法一
        Arrays.sort(data);// 从小到大排序
        System.out.println(data[0]);
        System.out.println(data[data.length - 1]);*/

        /*   方法二
        int min = Arrays.stream(data).min().getAsInt();
        int max = Arrays.stream(data).max().getAsInt();
        System.out.println(max);
        System.out.println(min);*/

        //正常方法 循环 最小最大就替换
        int max = 0;
        int min = data[0];
        for (int i: data
             ) {
            if (min > i)
                min = i;
            if (max < i)
                max = i;
        }
        System.out.println(min);
        System.out.println(max);
    }
}
