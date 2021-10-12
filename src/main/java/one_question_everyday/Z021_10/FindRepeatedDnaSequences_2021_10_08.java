package one_question_everyday.Z021_10;

/**
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，
 * 例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *  
 *
 * 示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 *
 * 示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *  
 *
 * 提示：
 * 0 <= s.length <= 10^5
 * s[i] 为 'A'、'C'、'G' 或 'T'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/10/8 6:21
 */
public class FindRepeatedDnaSequences_2021_10_08 {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> element = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i=0; i<=s.length()-10; i++){
            String substring = s.substring(i, i + 10);
            element.put(substring,element.getOrDefault(substring,0)+1);
            if (element.get(substring) == 2){
                result.add(substring);
            }
        }
        return result;
    }

    /***
     * 执行用时：24 ms, 在所有 Java 提交中击败了17.94%的用户
     * 内存消耗：46.9 MB, 在所有 Java 提交中击败了62.70%的用户
     */

    
    
    /** 超时，看来ArrayList 和 Map的效率差的有点远呀 */
    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> element = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i=0; i<=s.length()-10; i++){
            String substring = s.substring(i, i + 10);
            if (element.contains(substring) && !result.contains(substring)){
                result.add(substring);
            }else {
                element.add(substring);
            }
        }
        return result;
    }

    
    
    
    /**
     * 哈希表 + 滑动窗口 + 位运算。 还是不太有这方面的思路
     *
     * 由于 s 中只含有 4 种字符，我们可以将每个字符用 2 个比特表示，即：
     *
     * A 表示为二进制 00；
     * C 表示为二进制 01；
     * G 表示为二进制 10；
     * T 表示为二进制 11。
     * 如此一来，一个长为 10 的字符串就可以用 20 个比特表示，而一个 int 整数有 32 个比特，
     * 足够容纳该字符串，因此我们可以将 s 的每个长为 10 的子串用一个 int 整数表示（只用低 20 位）。
     *
     * 注意到上述字符串到整数的映射是一一映射，每个整数都对应着一个唯一的字符串，因此我们可以将方法一中的哈希表改为存储每个长为 10 的子串的整数表示。
     *
     * 如果我们对每个长为 10 的子串都单独计算其整数表示，那么时间复杂度仍然和方法一一样为 O(NL)。
     * 为了优化时间复杂度，我们可以用一个大小固定为 10 的滑动窗口来计算子串的整数表示。
     *
     * 设当前滑动窗口对应的整数表示为 x，当我们要计算下一个子串时，就将滑动窗口向右移动一位，此时会有一个新的字符进入窗口，以及窗口最左边的字符离开窗口，
     * 这些操作对应的位运算，按计算顺序表示如下：
     *
     * 滑动窗口向右移动一位：x = x << 2，由于每个字符用 2 个比特表示，所以要左移 2 位；
     * 一个新的字符 ch 进入窗口：x = x | bin[ch]，这里 bin[ch] 为字符 ch 的对应二进制；
     * 窗口最左边的字符离开窗口：x = x & ((1 << 20) - 1)，由于我们只考虑 x 的低 20 位比特，需要将其余位置零，即与上 (1 << 20) - 1。
     * 将这三步合并，就可以用 O(1) 的时间计算出下一个子串的整数表示，即 x = ((x << 2) | bin[ch]) & ((1 << 20) - 1)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences/solution/zhong-fu-de-dnaxu-lie-by-leetcode-soluti-z8zn/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    static final int L = 10;
    Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};

    public List<String> findRepeatedDnaSequences3(String s) {
        List<String> ans = new ArrayList<>();
        int length = s.length();
        if (length <= L) {
            return ans;
        }
        int x = 0;
        for (int i = 0; i < L - 1; ++i) {
            x = (x << 2) | bin.get(s.charAt(i));
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i <= length - L; ++i) {
            x = ((x << 2) | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 2) {
                ans.add(s.substring(i, i + L));
            }
        }
        return ans;
    }

    
}
