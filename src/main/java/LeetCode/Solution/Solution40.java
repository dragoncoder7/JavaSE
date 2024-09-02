package LeetCode.Solution;
public class Solution40 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        System.out.println(isRobotBounded("GLGLGGLGL"));
        System.out.println(multiply("498828660196","840477629533"));
    }
    public static boolean isRobotBounded(String instructions) {
        int towardDirCounts = 0;
        int x = 0;
        int y = 0;
        int xStep = 0;
        int yStep = 1;
        String nowDir;
        String[] dir = new String[]{"北","东","南","西",};

            for (int i = 0; i < instructions.length(); i++) {
                if (instructions.charAt(i) != 'G'){
                    if (instructions.charAt(i) == 'R'){
                        towardDirCounts++;
                    }else {
                        towardDirCounts = towardDirCounts + 3;
                    }
                    towardDirCounts = towardDirCounts % 4;
                    nowDir = dir[towardDirCounts % 4];
                    switch (nowDir) {
                        case "东" -> {
                            xStep = 1;
                            yStep = 0;
                        }
                        case "南" -> {
                            xStep = 0;
                            yStep = -1;
                        }
                        case "西" -> {
                            xStep = -1;
                            yStep = 0;
                        }
                        case "北" -> {
                            xStep = 0;
                            yStep = 1;
                        }
                    }
                }else {
                    x += xStep;
                    y += yStep;
                }
            }
        return towardDirCounts != 0 || (x == 0 && y == 0);
    }
    public static String multiply(String num1, String num2) {
        double a = Long.parseLong(num1);
        double b = Long.parseLong(num2);
        return String.valueOf(a*b);
    }

}
