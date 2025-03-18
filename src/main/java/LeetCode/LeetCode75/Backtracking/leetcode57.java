package LeetCode.LeetCode75.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode57 {
    public static void main(String[] args) {
        leetcode57 leetcode57 = new leetcode57();
        System.out.println(leetcode57.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        String[] letters = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int n = digits.length();
        List<String> list = new ArrayList<>();
        if (n == 0) return list;
        backtrack(list, letters, digits, 0, new StringBuffer());
        return list;


//        List<String> combinations = new ArrayList<>();
//        if (digits.isEmpty()) {
//            return combinations;
//        }
//        Map<Character, String> phoneMap = new HashMap<>() {{
//            put('2', "abc");
//            put('3', "def");
//            put('4', "ghi");
//            put('5', "jkl");
//            put('6', "mno");
//            put('7', "pqrs");
//            put('8', "tuv");
//            put('9', "wxyz");
//        }};
//        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
//        return combinations;
    }

//    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
//        if (index == digits.length()) {
//            combinations.add(combination.toString());
//        } else {
//            char digit = digits.charAt(index);
//            String letters = phoneMap.get(digit);
//            int lettersCount = letters.length();
//            for (int i = 0; i < lettersCount; i++) {
//                combination.append(letters.charAt(i));
//                backtrack(combinations, phoneMap, digits, index + 1, combination);
//                combination.deleteCharAt(index);
//            }
//        }
//    }

    public void backtrack(List<String> list, String[] letters, String digits, int index, StringBuffer combination) {
        if(digits.length() == index){
            list.add(combination.toString());
        }else {
            String letter = letters[digits.charAt(index) - '2'];
            for (int i = 0; i < letter.length(); i++) {
                combination.append(letter.charAt(i));
                backtrack(list, letters, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
