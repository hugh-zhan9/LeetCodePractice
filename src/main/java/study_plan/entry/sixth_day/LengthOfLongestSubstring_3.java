package study_plan.entry.sixth_day;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 *  
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *  
 *
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/11/1 9:00
 */
public class LengthOfLongestSubstring_3 {

    /** 滑动窗口 */
    public int lengthOfLongestSubstring(String s) {
        int length = s.length(), res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start=0, end=0; end < length; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            res = Math.max(res, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return res;
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了87.96%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了47.01%的用户
     */

}

