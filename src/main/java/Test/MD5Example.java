package Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Example {
    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis() / 1000;
        String originalString = "key=ZqhFBP3kJZhc4IewlIAh&timestamp="+currentTime+"&secret=wj$hExL1";
        System.out.println(originalString);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(originalString.getBytes());
            byte[] digest = md.digest();

            // 将 byte 数组转为 16 进制字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            System.out.println("Original: " + originalString);
            System.out.println("MD5 Hash: " + sb.toString().toUpperCase());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}

