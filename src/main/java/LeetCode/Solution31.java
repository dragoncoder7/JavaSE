package LeetCode;
public class Solution31 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        String as = null;
        if (as == null){
            System.out.println("as is null");
        }else {
            System.out.println("as is not null");
        }
        Solution31 s = new Solution31();
        System.out.println(s.getDigits(10225));
        System.out.println(s.getDigitsMutil(10225));
        System.out.println(s.accountBalanceAfterPurchase(15));
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
