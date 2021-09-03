package first_practice.sort.easy;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *  
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *  
 *
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *  
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/9/3 10:29
 */
public class IsAnagram_242 {

    /** 排序 */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * 时间复杂度：O(nlogn)，其中 n 为 s 的长度。排序的时间复杂度为O(nlogn)，比较两个字符串是否相等时间复杂度为 O(n)
     * 因此总体时间复杂度为 O(nlogn+n)=O(nlogn)。
     *
     * 空间复杂度：O(logn)。排序需要 O(logn) 的空间复杂度。
     * 注意，在某些语言（比如 Java & JavaScript）中字符串是不可变的，因此我们需要额外的 O(n) 的空间来拷贝字符串。
     * 但是我们忽略这一复杂度分析，因为：
     *      这依赖于语言的细节；
     *      这取决于函数的设计方式，例如，可以将函数参数类型更改为 char[]。
     */

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了78.99%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了51.05%的用户
     */

    /** hash */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] size = new int[26];
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        for (char c:str1){
            size[c-'a']++;
        }
        for (char c:str2){
            size[c-'a']--;
            if (size[c-'a']<0){
                return false;
            }
        }
        return true;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了82.08%的用户
     */


    /**
     * Unicode 是为了解决传统字符编码的局限性而产生的方案，它为每个语言中的字符规定了一个唯一的二进制编码。而 Unicode 中可能存在一个字符对应多个字节的问题，
     * 为了让计算机知道多少字节表示一个字符，面向传输的编码方式的 UTF−8 和 UTF−16 也随之诞生逐渐广泛使用，
     *
     * 进阶问题的核心点在于「字符是离散未知的」，因此用哈希表维护对应字符的频次即可。
     * 同时读者需要注意 Unicode 一个字符可能对应多个字节的问题，不同语言对于字符串读取处理的方式是不同的。
     */

    /** 进阶 */
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 时间复杂度：O(n)，其中 n 为 s 的长度。
     * 空间复杂度：O(S)，其中 S 为字符集大小，此处 S=26。
     */

    /**
     * 执行用时：16 ms, 在所有 Java 提交中击败了17.91%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了20.25%的用户
     */

}
