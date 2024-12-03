package LeetCode.QueueAndStack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(isValid("[([]])"));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> list = new LinkedList<>();
        for (char c :
                s.toCharArray()) {
            if (list.isEmpty()){
                list.add(c);
                continue;
            }
            char top = list.get(list.size() - 1);
            if (compare(top, c)){
                list.remove(list.size() - 1);
            }else
                list.add(c);
        }
        return stack.empty();
    }
    public static boolean compare(char top, char next){
        if (top == '{' && next == '}'){
            return true;
        } else if (top == '(' && next == ')') {
            return true;
        } else return top == '[' && next == ']';
    }
}
