import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {  //正则表达式
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        String[] emails = {"shiyanlou@shiyanlou.com", "shiYanLou"};
        for (String email: emails
             ) {
            Matcher matcher = pattern.matcher(email);
            System.out.println(email + "匹配结果：" + matcher.matches());
        }
        Scanner sc = new Scanner(System.in);
        CharSequence phoneNum = sc.nextLine();
        Pattern p = Pattern.compile("^1([3456789])\\d{9}$");
        Matcher matcher = p.matcher(phoneNum);

        if (matcher.matches() && phoneNum.length() == 11 )
            System.out.println(true);
    }
}

