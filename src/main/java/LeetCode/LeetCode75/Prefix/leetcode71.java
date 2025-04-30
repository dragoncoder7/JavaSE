package LeetCode.LeetCode75.Prefix;

import java.util.ArrayList;
import java.util.List;

public class leetcode71 {
    public static void main(String[] args) {
        leetcode71 leetcode71 = new leetcode71();
        System.out.println(leetcode71.suggestedProducts(new String[2], "abc"));
    }

    /**
     * 给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。
     * <p>
     * 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
     * <p>
     * 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
     *
     * @param products
     * @param searchWord
     * @return
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list = new ArrayList<>();

        leetcode70 leetcode70 = new leetcode70();
        for (String s : products) {
            leetcode70.insert(s);
        }
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> stringList = new ArrayList<>();
            String s = searchWord.substring(0, i + 1);
            leetcode70 node = leetcode70.startsWith(s);
            if (node == null) {
                list.add(stringList);
            } else {
                list.add(searchAll(node, new StringBuilder(s)));
            }
        }

        return list;
    }

    /**
     * 获取某字符串下的所有匹配字符串
     *
     * @param node
     * @param s
     * @return
     */
    public List<String> searchAll(leetcode70 node, StringBuilder s){
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= 25; i++) {

            leetcode70 child = node.children[i];
            if (child != null){
                StringBuilder builder = new StringBuilder(s);
                builder.append('a' + i);
                searchAll(child, builder);
                list.add(builder.toString());
                if (list.size() >= 3){
                    break;
                }
            }
        }
        return list;
    }

    public String getString(StringBuilder s, leetcode70 node){
        return null;
    }
}
