import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

public class Main {
    public static void main(String[] args) {


        //System.out.println(s);

        String startTime = "2024-07-01 08:00";
        String endTime = "2024-07-20 17:30";
        int id = 433039;
        String sql = "SELECT\n" +
                "\t* \n" +
                "FROM\n" +
                "\tk20 a \n" +
                "WHERE\n" +
                "\ta.A0188 = "+id+" \n" +
                "\tAND (\n" +
                "\t\t( a.k2006 > CONVERT ( VARCHAR, '"+startTime.split(" ")[0]+"', 120 ) AND a.k2006 < CONVERT ( VARCHAR, '"+endTime.split(" ")[0]+"', 120 ) ) \n" +
                "\t\tOR ( a.k2006 <= CONVERT ( VARCHAR, '"+startTime.split(" ")[0]+"', 120 ) AND a.k2007 >= CONVERT ( VARCHAR, '"+endTime.split(" ")[0]+"', 120 ) ) \n" +
                "\t\tOR ( a.k2007 > CONVERT ( VARCHAR, '"+startTime.split(" ")[0]+"', 120 ) AND a.k2007 < CONVERT ( VARCHAR, '"+endTime.split(" ")[0]+"', 120 ) ) \n" +
                "\t)";
        /*String sql = "SELECT *\n" +
                "FROM\n" +
                "\tk07 a \n" +
                "WHERE\n" +
                "\ta.k0701 = (SELECT CONVERT\n" +
                "\t(\n" +
                "\t\tDATETIME,\n" +
                "\t\t'1900-01-01 ' + '"+time+"' ))\n" +
                "\t\tAND a.k0700 = (select CONVERT ( DATETIME, '"+date+"', 120 ))  and a.A0188 = "+ HRid;*/
        System.out.println(sql);
        String spk = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqAClqpl6lGnLPuR3tx4OBJa8rhAo+WhxUQKjU7XFoGBMCTVPPeGJ8SWG5JynxHJl681i84WL2FP6gX+5Trleq/VKlCQESJEU2r2EYEYUHoZ9PD9ELlaJHCd2fySlSK8cCME7iFSJ4VI3TkTD91L+yJzFpL9110VegN1Ss3s0X12qO1uCrBx5henfMuCd7xk/cW9uOqoUWBShd/n95CJnhXSHVSVV32WwybFDTmUN12X56++o/fBr3MTCtxpZjog4k6rurzwOqX7YEEKgpoIEHU0ypZ1z2uNtl8XK7Qla0XgILz69z1YB6hbnsdAXQRQYWVEtnK77wU2yZigDE/TQ6QIDAQAB";
        RSA rsa = new RSA(null,spk);
        String secret = "5a2e2238-4bdf-4145-b578-5a05077939a3";
        String encryptSecret = rsa.encryptBase64(secret, CharsetUtil.CHARSET_UTF_8,KeyType.PublicKey);
        System.out.println(encryptSecret);

        System.out.println("\n==============================\n");
        //对用户信息进行加密传输,暂仅支持传输OA用户ID
        String encryptUserid = rsa.encryptBase64("231129",CharsetUtil.CHARSET_UTF_8,KeyType.PublicKey);
        System.out.println(encryptUserid);
    }
}