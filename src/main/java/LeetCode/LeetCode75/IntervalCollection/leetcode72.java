package LeetCode.LeetCode75.IntervalCollection;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode72 {
    public static void main(String[] args) {
        leetcode72 leetcode72 = new leetcode72();
        System.out.println(template());
        String s = "390006,390093,390095,390096,390097,390113,390114,390115,390116,390117,390118,390119,390120,390121,390122,390124,390125,390127,390128,390129,390130,390131,390132,390133,390134,390135,390136,390137,390138";


        int[] intArray = Arrays.stream(s.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        JSONArray responsibilityIds = new JSONArray(intArray);

        System.out.println(responsibilityIds);
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }
    private static String template(){
        return "{\n" +
                "    \"creationDate\": \"\",\n" +
                "    \"creationDateFrom\": null,\n" +
                "    \"creationDateTo\": null,\n" +
                "    \"createdBy\": null,\n" +
                "    \"lastUpdatedBy\": null,\n" +
                "    \"lastUpdatedByName\": null,\n" +
                "    \"lastUpdateDate\": \"\",\n" +
                "    \"lastUpdateDateFrom\": null,\n" +
                "    \"lastUpdateDateTo\": null,\n" +
                "    \"lastUpdateLogin\": null,\n" +
                "    \"versionNum\": null,\n" +
                "    \"importProcessStatus\": null,\n" +
                "    \"importError\": null,\n" +
                "    \"userOrgId\": null,\n" +
                "    \"userId\": null,\n" +
                "    \"orgId\": null,\n" +
                "    \"attributeCategory\": null,\n" +
                "    \"attribute1\": null,\n" +
                "    \"attribute2\": null,\n" +
                "    \"attribute3\": null,\n" +
                "    \"attribute4\": null,\n" +
                "    \"attribute5\": null,\n" +
                "    \"checkFlag\": \"Y\",\n" +
                "    \"orgCode\": \"\",\n" +
                "    \"orgName\": \"\",\n" +
                "    \"orgType\": \"\",\n" +
                "    \"parentOrgId\": \"\",\n" +
                "    \"orgLevel\": 1,\n" +
                "    \"title\": \"\",\n" +
                "    \"expand\": true,\n" +
                "    \"checked\": true,\n" +
                "    \"treeFullPath\": \"\",\n" +
                "    \"nodeKey\": 0,\n" +
                "    \"lan\": \"CN\"\n" +
                "}";
    }
}
