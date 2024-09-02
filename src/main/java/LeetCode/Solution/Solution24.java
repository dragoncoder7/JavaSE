package LeetCode.Solution;

import java.util.HashMap;

public class Solution24 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        Solution24 s = new Solution24();
        System.out.println("我的世界 因为有你才会美");
        System.out.println(s.romanToInt("III"));
    }

    /**
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer.
     * @param s a roman numeral
     * @return an integer
     * @apiNote 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     */
    public int romanToInt(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        char[] chars = s.toCharArray();

        int sum = 0;
        for (int i = 0; i < s.length(); i++){
            char c = chars[i];
            switch(c){
                case 'I':
                    if (i+1 < s.length()){
                        if(chars[i+1] == 'V' || chars[i+1] == 'X'){
                            sum -= map.get(String.valueOf(c));
                            continue;
                        }
                    }
                case 'X':
                    if (i+1 < s.length()){
                        if(chars[i+1] == 'L' || chars[i+1] == 'C'){
                            sum -= map.get(String.valueOf(c));
                            continue;
                        }
                    }
                case 'C':
                    if (i+1 < s.length()){
                        if(chars[i+1] == 'D' || chars[i+1] == 'M'){
                            sum -= map.get(String.valueOf(c));
                            continue;
                        }
                    }
            }
            sum += map.get(String.valueOf(c));
            System.out.println(sum);
        }
        return sum;
    }
}
