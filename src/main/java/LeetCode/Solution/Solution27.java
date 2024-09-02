package LeetCode.Solution;

import static java.lang.Math.max;

public class Solution27 {
    public static void main(String[] args) {

        Solution27 s = new Solution27();
        int res = s.maxLengthBetweenEqualCharacters("cbzxy");
        //System.out.println(res);
        String abc = null;
        assert true : "abc is null";
        //Assert.assertEquals(3, res);
        String ss = "";
        System.out.println(ss);
        ss += "6268876 : 43313 我的";
        System.out.println(ss);
        ss += "fdasfasdfa�ļ�����ɽ��v";
        System.out.println(ss);

    }

    public int maxLengthBetweenEqualCharacters(String s) {

        int max = -1;

        for(int i = 0; i < s.length(); i++){
            int length = 0;
            int beginLength = s.indexOf(s.charAt(i));
            int endLength = s.lastIndexOf(s.charAt(i));
            length = endLength - beginLength - 1;
            max = max(max, length);
        }
        return max;
    }
    public String addBinary(String a, String b) {
        int length = Math.max(a.length(),b.length());
        for (int i = 0; i < length; i++){
            char aChar = a.charAt(a.length()- i - 1);
            char bChar = b.charAt(b.length()- i - 1);

            if(aChar+bChar > 1){
                int temp = 1;

            }
        }
        return "";
    }

    /*public boolean isRobotBounded(String instructions) {
        for(char c : instructions.toCharArray()){
            int x = 0, y = 0;
            String[] directions = {"up","down","left","right"};
            switch (c){

                case 'G':
                    if (direction.equals("up")){
                        y++;
                    }else if (direction.equals("down")){
                        y--;
                    }else if (direction.equals("left")){
                        x--;
                    }else {
                        x++;
                    }
                    break;
                case 'L':

                    break;
                case 'R':

                    break;
            }
        }
    }*/
}
