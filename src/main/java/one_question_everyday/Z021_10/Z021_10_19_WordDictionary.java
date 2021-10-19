package one_question_everyday.Z021_10;

/**
 * 请你设计一个数据结构，支持添加新单词和查找字符串是否与任何先前添加的字符串匹配。
 *
 * 实现词典类 WordDictionary：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true；否则，返回 false。word 中可能包含一些'.'，每个 . 都可以表示任何一个字母。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *  
 *
 * 提示：
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

/**
 * @author zyk
 * @description
 * @since 2021/10/19 9:00
 */
public class Z021_10_19_WordDictionary {

    private Map<Integer, List<String>> map;

    /** 暴力题解：超时 */

    /*
    public Z021_10_19_WordDictionary() {
        map = new HashMap<>();
    }

    private Map<Character, List<String>> map;

    public void addWord(String word) {
        char c = word.charAt(0);
        List<String> list = map.getOrDefault(c, new ArrayList<>());
        list.add(word);
        map.put(c,list);
    }

    public boolean search(String word) {
        char c = word.charAt(0);
        if (!map.containsKey(c) && c != '.'){
            return false;
        }
        if (c == '.'){
            Iterator<Character> iterator = map.keySet().iterator();
            while (iterator.hasNext()){
                Character next = iterator.next();
                List<String> strings = map.get(next);
                for (String str : strings){
                    if (word.length() != str.length()){
                        continue;
                    }
                    for (int i=0; i<word.length();i++){
                        if (word.charAt(i)!='.' && str.charAt(i) == word.charAt(i)){
                            if (i == word.length()-1){
                                return true;
                            }
                        }else if (word.charAt(i) == '.'){
                            if (i == word.length()-1){
                                return true;
                            }
                            continue;
                        }else {
                            break;
                        }
                    }
                }
            }
            return false;
        } else {
            List<String> strings = map.get(c);
            for (String str : strings){
                if (word.length() != str.length()){
                    continue;
                }
                for (int i=0; i<word.length();i++){
                    if (word.charAt(i)!='.' && str.charAt(i) == word.charAt(i)){
                        if (i == word.length()-1){
                            return true;
                        }
                    }else if (word.charAt(i) == '.'){
                        if (i == word.length()-1){
                            return true;
                        }
                        continue;
                    }else {
                        break;
                    }
                }
            }

        }
        return false;
    }
     */

    /** 按照字符长度进行分组 */

    /*
    public Z021_10_19_WordDictionary() {
        map = new HashMap<>();
    }


    public void addWord(String word) {
        int length = word.length();
        List<String> list = map.getOrDefault(length, new ArrayList<>());
        list.add(word);
        map.put(length,list);
    }

    public boolean search(String word) {
        int length = word.length();
        if (!map.containsKey(length)){
            return false;
        }
        List<String> list = map.get(length);
        for (String str : list){
            for (int i=0; i<length; i++){
                if (word.charAt(i)!='.' && str.charAt(i) == word.charAt(i)){
                    if (i == word.length()-1){
                        return true;
                    }
                }else if (word.charAt(i) == '.'){
                    if (i == word.length()-1){
                        return true;
                    }
                    continue;
                }else {
                    break;
                }
            }
        }
        return false;
    }

    /**
     * 执行用时：45 ms, 在所有 Java 提交中击败了46.45%的用户
     * 内存消耗：48.5 MB, 在所有 Java 提交中击败了90.71%的用户
     */




    /**
     * 诚然字典树更适合这种题目，😔 慢慢来吧。
     * [官方题解：](https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/solution/tian-jia-yu-sou-suo-dan-ci-shu-ju-jie-go-n4ud/)
     * [题解中前缀树的学习指南](https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/solution/fu-xue-ming-zhu-qian-zhui-shu-xiang-xi-r-rty2/)
     */

    private Trie root;

    public Z021_10_19_WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Trie node) {
        if (index == word.length()) {
            return node.isEnd();
        }
        char ch = word.charAt(index);
        if (Character.isLetter(ch)) {
            int childIndex = ch - 'a';
            Trie child = node.getChildren()[childIndex];
            if (child != null && dfs(word, index + 1, child)) {
                return true;
            }
        } else {
            for (int i = 0; i < 26; i++) {
                Trie child = node.getChildren()[i];
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
        }
        return false;
    }
}



class Trie {
    private Trie[] children;
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

    public Trie[] getChildren() {
        return children;
    }

    public boolean isEnd() {
        return isEnd;
    }

}


