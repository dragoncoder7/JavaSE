package LeetCode.Solution;
import java.util.Scanner;
public class Solution31 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        /*System.out.println("as is null");

        System.out.println(s.getDigits(10225));
        System.out.println(s.getDigitsMutil(10225));
        System.out.println(s.accountBalanceAfterPurchase(15));
        String a = "2024-06-19 08:00";
        String b = "2024-06-21 12:00";
        System.out.println("startDate："+a.split(" ")[0]);
        System.out.println("startTime："+a.split(" ")[1]);
        System.out.println("endDate："+b.split(" ")[0]);
        System.out.println("endTime："+b.split(" ")[1]);*/
        Solution31 s = new Solution31();
        Scanner scanner = new Scanner(System.in);
        String sss = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><hrmlist><hrm action=\"add\"><loginid>C0511214</loginid><password>C0511214</password><password1>C0511214</password1><lastname>Bùi Thị Thùy Dương 裴氏垂阳</lastname><sex>女</sex><accounttype>主账号</accounttype><department>制造中心>CNC生产部</department><jobtitle>文员</jobtitle><managerid>C0503450</managerid><statue>正式</statue><mobile>0976295061</mobile><telephone></telephone><email></email><locationid>越南长盈</locationid><companystartdate>2024-06-20</companystartdate><workstartdate>2024-06-20</workstartdate><resourceimageid></resourceimageid><workcode>C0511214</workcode><subcompany>越南长盈精密技术有限公司>广东长盈越南义安分厂</subcompany><jobactivityid>ewpt</jobactivityid><jobgroupid>ewpt</jobgroupid></hrm></hrmlist></root>";
        System.out.println(s.clearEntity(sss));
        String ss = "A0000003\n" +
                "A0044612\n" +
                "A0000054\n" +
                "A0000223\n" +
                "A0000002\n" +
                "A0042265\n" +
                "A0114942\n" +
                "A0000256\n" +
                "A0000010\n" +
                "A0113107\n" +
                "A0000018\n" +
                "A0042034\n" +
                "A0102412\n" +
                "A0035741\n" +
                "A0000097\n" +
                "A0041569\n" +
                "A0036069\n" +
                "A0021216\n";
        System.out.println(ss);
        String t = scanner.nextLine();
        if (ss.contains(t)){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
        //System.out.println(s.countBeautifulPairs(new int[]{31,25,72,79,74}));
    }
    public String clearEntity(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        if (!str.toLowerCase().contains("demo/entity")) {
            return str;
        }
        return str.replaceAll("(?i)\\<\\!entity ", "*");
    }

    public int countBeautifulPairs(int[] nums) {
        int res = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(gcd(nums[i],nums[j]) == 1)
                    res++;
            }
        }
        return res;
    }
    public int gcd(int m , int n){
        for(int i = 1; i <= Math.min(m,n); i++){
            if(m % i == 0 && n % i == 0 && i != 1)
                return 0;
        }
        return 1;
    }
    public int getDigits(int num){
        int res = 0;
        res += num % 10;
        num = num / 10;
        if(num >= 10){
            num = getDigits(num);
        }
        return num+res;
    }
    public int getDigitsMutil(int num){
        if (num < 10){
            return num;
        }
        int res = 1;
        res *= num % 10;
        num = num / 10;
        if(num >= 10){
            num = getDigitsMutil(num);
        }
        return num*res;
    }
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int begin = 100;
        int l = purchaseAmount / 10, r = purchaseAmount / 10 + 1;
        if(r * 10 - purchaseAmount <= Math.abs(l * 10 - purchaseAmount)){
            return begin - r * 10;
        }else {
            return begin - l * 10;
        }
    }
}
