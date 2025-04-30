package LeetCode.LeetCode75.Prefix;

public class leetcode70 {

    leetcode70[] children;
    boolean isEnd = false;
    public static void main(String[] args) {
        leetcode70 leetcode70 = new leetcode70();
        System.out.println();
    }

    public leetcode70() {
        children =  new leetcode70[26];
    }

    public void insert(String word) {
        leetcode70 leetcode70 = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (leetcode70.children[index] == null){
                leetcode70.children[index] = new leetcode70();
            }
            leetcode70 = leetcode70.children[index];
        }
        leetcode70.isEnd = true;
    }

    private leetcode70 searchPrefix(String prefix) {
        leetcode70 leetcode70 = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (leetcode70.children[index] == null) {
                return null;
            }
            leetcode70 = leetcode70.children[index];
        }
        return leetcode70;
    }

    public leetcode70 search(String word) {
        leetcode70 leetcode70 = searchPrefix(word);
        return leetcode70 != null && leetcode70.isEnd ? leetcode70 : null;
    }

    public leetcode70 startsWith(String prefix) {
        return searchPrefix(prefix);
    }




/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

    /**
     * Trie() 初始化前缀树对象。
     * void insert(String word) 向前缀树中插入字符串 word 。
     * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
     * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
     */
    class Trie {
        private final Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }

}
