package LeetCode.weeklyContest.fourtwonine;

import java.util.*;

public class one {
    public static void main(String[] args) {
        int[] ints = new int[]{};
//        System.out.println(ints.length);
        one one = new one();
        System.out.println(one.minimumOperations(new int[]{6,7,8,9}));
    }
    public int minimumOperations(int[] nums) {
        int res = 0;
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        List<Integer> list = new ArrayList<>();

        for (int i : nums) {
            list.add(i);
        }
        Set<Integer> set = new HashSet<>(list);
        if (set.size()!= list.size()){
            return reduce(list,set,res);
        }

        return 0;
    }
    public int reduce(List<Integer> list,Set<Integer> set, int count){
        if (list.size() < 3){
            count++;
            return count;
        }
        Iterator<Integer> iterator = list.iterator();
        int nums = 0;
        while (iterator.hasNext()) {
            iterator.next();
            if (nums++ < 3) {
                iterator.remove();
            }else {
                break;
            }
        }
        count++;
        set.clear();
        set.addAll(list);
        if (set.size() != list.size()){
            count = reduce(list,set,count);
        }
        return count;
    }
}
