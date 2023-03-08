package StringStudy;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {

        System.out.println("请输入：");
        Scanner scan = new Scanner(System.in);
        String[] strings = new String[100];
        int i = 0;
        while (!scan.hasNext("end") && i < 100){
            strings[i] = scan.nextLine();
            i++;
        }

        for(int ii = 0; ii<strings.length; ii++){
            if(strings[ii] == null)
                break;
            System.out.println(strings[ii]);
        }
       /* StringBuilder stringBuffer = new StringBuilder(s);
        for(int i = 0; i < stringBuffer.length(); i++ ){
            if(stringBuffer.charAt(i) == ' '){
                stringBuffer.deleteCharAt(i);
                i--;
            }
        }
        System.out.println(stringBuffer.toString());*/ //清除空格 或者 某一指定字符的方法

        /*String a = scan.nextLine();
        String b = scan.nextLine();
        if (b.compareTo(a) == 0)
            System.out.println("相同");
        */ //判断两个字符串是否一样 1.可以先比较长短 再用循环挨个比较字符  2.直接用String的compare方法
        scan.close();
    }
}
