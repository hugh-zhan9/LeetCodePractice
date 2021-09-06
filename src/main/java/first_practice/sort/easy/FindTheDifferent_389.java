package first_practice.sort.easy;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 *
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 *
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 *
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *  
 *
 * 提示：
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * @author zyk
 * @description
 * @since 2021/9/7 6:13
 */
public class FindTheDifferent_389 {

    /** 使用了排序所以时间复杂度比较高 O(nlogn) */
    public char findTheDifference(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        if (tChars.length == 1){
            return tChars[0];
        }

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        int i=0;
        while (i<sChars.length){
            if (sChars[i] != tChars[i]){
                return tChars[i];
            }
            i++;
        }
        return tChars[tChars.length-1];
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了54.56%的用户
     * 内存消耗：36.9 MB, 在所有 Java 提交中击败了34.02%的用户
     */

    /** 计数 */
    public char findTheDifference2(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }

    /** 求和 */
    public char findTheDifference3(String s, String t) {
        int chars =0,chart=0;
        for (int i = 0; i < s.length(); ++i){
            chars +=s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i){
            chart +=t.charAt(i);
        }
        return (char) (chart-chars);
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.42%的用户
     * 内存消耗：36.7 MB, 在所有 Java 提交中击败了70.15%的用户
     */



    /** 位运算
     * 如果将两个字符串拼接成一个字符串，则问题转换成求字符串中出现奇数次的字符。
     * 类似于「136. 只出现一次的数字」，使用位运算的技巧解决本题。
     */
    public char findTheDifference4(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }

}
