package StringStudy;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Stringlength {
    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        String s="4";

        String s0=new String("aebd");

        String s1="ABED";
        String s2="ABED";
        byte[] bytes=null;
        int i=s.length();
        int i1=s0.length();
        boolean b=(s2==s1);
//        s=s1.concat(s2);
//        System.out.println(s);
//        System.out.println(s0.equalsIgnoreCase(s1));
          char[] helloArray = {'r','u','n','t','o','b'};
//        String helloString =new String(helloArray);
//        helloString=helloString.concat(s2);
//        System.out.println(helloString);
        //String.format(s1, );
        String str1 = "String";
        String str2 = "Strings";
        String str3 = "Docstrings";

//        int result = str1.compareTo( str2 );
//        System.out.println(result);
//
//        result = str2.compareTo( str3 );
//        System.out.println(result);
//
//        result = str3.compareTo( str1 );
//        System.out.println(result);
        CharSequence charSequence="asd13465";
//        System.out.println(charSequence);
//        charSequence=charSequence.subSequence(1,4);
//        System.out.println(charSequence);
//        StringBuffer stringBuffer=new StringBuffer("String");
//        System.out.println(str1.contentEquals(stringBuffer));
//        System.out.println(str1.contentEquals(charSequence));
//        int ii=s0.codePointAt(2);
//        IntStream intStream=s0.codePoints();
//        System.out.println(intStream);
        b=s0.contains("b");
       // System.out.println(b);
        String s3=String.copyValueOf(helloArray,1,4);
        //System.out.println(s3);
        b=s3.endsWith("o");
        //System.out.println(b);
        //System.out.println(s.codePointCount(0,s.length()));
        //System.out.println(s.lines());
        s1=String.format("1jdasflasd",s,s1,s2);
       // System.out.println(s+s1+s2);
       // System.out.println(s.intern());
        //System.out.println(s.repeat(10));
        System.out.println(s.getBytes());
        Charset charset=Charset.forName("utf8");
        bytes=s.getBytes(charset);
//        System.out.println(bytes);
//        System.out.println(helloArray);
        str3.getChars(1,6,helloArray,0);
//        System.out.println(helloArray);
//        System.out.println(str3.hashCode());
        System.out.println(str3);
        //System.out.println(str3.lastIndexOf("s"));
        str3.replace("ooo","s");
        System.out.println(str3);
        str3="  Docs  tri n g s ";
        System.out.println(str3.trim());
    }
}
