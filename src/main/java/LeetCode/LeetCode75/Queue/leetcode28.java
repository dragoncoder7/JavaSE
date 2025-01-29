package LeetCode.LeetCode75.Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode28 {
    public static void main(String[] args) {
        leetcode28 leetcode28 = new leetcode28();
        System.out.println(leetcode28.predictPartyVictory1("DDRRR"));
    }
    public String predictPartyVictory(String senate) {
        char first = senate.charAt(0);
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('D',0);
        for (char c : senate.toCharArray()) {
            map.merge(c,1,Integer::sum);
        }
        // 前提 d >= 0 -> d++ r-- else  d++;
        int countR = map.get('R');
        int countD = map.get('D');
        while (countD > 0 && countR > 0){
            for (int i = 0; i < (countD + countR); i++) {

            }
        }
        if (map.get('R') == map.get('D')){
            return first == 'R' ? "Radiant" : "Dire";
        }
        return map.get('R') > map.get('D') ? "Radiant" : "Dire";
    }
    public String predictPartyVictory1(String senate) {
        int length = senate.length();
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == 'R'){
                r.offer(i);
            }else {
                d.offer(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()){
            int rIndex = r.poll();
            int dIndex = d.poll();
            if (rIndex < dIndex){
                r.offer(rIndex + length);
            }else {
                d.offer(dIndex + length);
            }
        }
        return r.isEmpty() ? "Dire" : "Radiant";
    }
}
