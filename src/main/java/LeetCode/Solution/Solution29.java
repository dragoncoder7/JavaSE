package LeetCode.Solution;

/*
import cn.hutool.core.codec.Base64;
*/

import java.util.*;

public class Solution29 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        Solution29 s = new Solution29();

        /*String a = null;
        if(a == null){
            //System.out.println("输出null");
        }
        int tableMainId = 5918;
        String tablename = "formtable_main_31";
        String sqlDuplicate = "select  a.bdrxm,a.bdsj, a.gh,count(1) as counts\n" +
                "    from "+ tablename +"_dt1 a\n" +
                "    where a.mainid  = "+ tableMainId +"\n" +
                "   group by  a.bdrxm, a.gh,a.bdyy,a.bdsj\n" +
                "  having count(a.mainid) > 1 and count(a.bdrxm) > 1 and count(a.gh) > 1 and count(a.bdyy) > 1 and count(a.bdsj) > 1";
        System.out.println(sqlDuplicate);
        int cl = 0;
        String tempIn = "123";

        String res = Base64.decodeStr("5bm/5ZGK54mMLeWuieWFqOS/oeaBr+WFrOekuuagjyjlsLrlr7g4MGNtKjE2MGNtKQs=");
        System.out.println(res.trim());//广告牌-安全信息公示栏(尺寸80cm*160cm)
        System.out.println(res);//广告牌-安全信息公示栏(尺寸80cm*160cm)
        String time = null,date = null,HRid = null;
        String abc = "SELECT\n" +
                "	* \n" +
                "FROM\n" +
                "	k20 a \n" +
                "WHERE\n" +
                "	a.k2008 = ( SELECT CONVERT ( DATETIME, '1900-01-01 ' + '"+time1+"' ) ) \n" +
                "	AND a.k2009 = ( SELECT CONVERT ( DATETIME, '1900-01-01 ' + '"+time2+"' ) ) \n" +
                "	AND a.k2006 = ( SELECT CONVERT ( DATETIME, '"+date1+"', 120 ) ) \n" +
                "	AND a.k2007 = ( SELECT CONVERT ( DATETIME, '"+date2+"', 120 ) ) \n" +
                "	AND a.A0188 = "+HRid;
        System.out.println(abc);*/
        int[][] grid = {{9,1,7},{8,9,2},{3,4,6}};
        int[] res1 = s.twoSum(new int[]{-1,-2,-3,-4,-5},-8);
        //System.out.println(res1[0]+" "+res1[1]);
        /*int[] res1 = s.findMissingAndRepeatedValues(grid);
        System.out.println(res1[0]+" "+res1[1]);*/
        int[] arr = {1,1,2,2,3,3};
        //new HashSet<>(List.of(arr)).forEach(System.out::print);
        //System.out.println(s.distributeCandies(arr));
        s.resultArray(new int[]{5,14,3,1,2});
    }
    public int distributeCandies(int[] candyType) {
        int num = candyType.length;
        int canEat = num / 2; // 可以吃的糖的数量
        Set<Integer> hashset = new HashSet<>();
        for (int i :
            candyType) {
            hashset.add(i);
        }
        int canEatTypeNum = hashset.toArray().length;//拥有的糖的种类
        return Math.min(canEatTypeNum, canEat);
    }
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] res = new int[2];
        int n = grid.length;
        for(int m = 1; m <= n*n; m++){
            int noun = n*n;
            int exist = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(m == grid[i][j]){
                        exist++;
                    }else{
                        noun--;
                    }
                }
            }
            if(exist == 2){
                res[0] = m;
            }
            if(noun == 0){
                res[1] = m;
            }
        }
        return res;
    }
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        boolean tag = false;
        for(int i = 0; i < nums.length; i++ ){
            int a = nums[i];
            if(a > target){
                continue;
            }
            for(int j = i + 1; j < nums.length; j++){
                int b = nums[j];
                if(a + b > target){
                    continue;
                }
                if(a + b == target){
                    res[0] = i;
                    res[1] = j;
                    tag = true;
                    break;
                }
            }
            if(tag){
                break;
            }
        }
        return res;
    }










































    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if(greaterCount(list1.toArray(), nums[i]) > greaterCount(list2.toArray(), nums[i])){
                list1.add(nums[i]);
            }
            if(greaterCount(list1.toArray(), nums[i]) < greaterCount(list2.toArray(), nums[i])){
                list2.add(nums[i]);
            }
            if(greaterCount(list1.toArray(), nums[i]) == greaterCount(list2.toArray(), nums[i])){
                if (list1.size() <= list2.size()){
                    list1.add(nums[i]);
                }else {
                    list2.add(nums[i]);
                }
            }
        }
        list1.addAll(list2);
        return list1.stream().mapToInt(Integer::intValue).toArray();
    }
    public int greaterCount(Object[] arr, int val){
        int count = 0;
        for(Object i : arr){
            if((int)i > val){
                count++;
            }
        }
        return count;
    }

}
