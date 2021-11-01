package study_plan.entry.sixth_day;

/**
 * 给你两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1的排列之一是 s2 的子串 。
 *
 *  
 *
 * 示例 1：
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 *
 * 示例 2：
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *  
 *
 * 提示：
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * @author zyk
 * @description
 * @since 2021/11/1 10:42
 */
public class CheckInclusion_576 {

    /** 我愚蠢的解法 */
    public boolean checkInclusion(String s1, String s2) {
        int m=s1.length(), n = s2.length();
        if (m>n) return false;
        char[] chars2 = s1.toCharArray();
        Arrays.sort(chars2);
        int i=0, j=m-1;
        for (; j<n; j++, i++){
            String substring = s2.substring(i, j+1);
            char[] chars = substring.toCharArray(); Arrays.sort(chars);
            if (Arrays.equals(chars,chars2)) return true;
        }
        return false;
    }

    /**
     * 执行用时：843 ms, 在所有 Java 提交中击败了6.40%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了10.45%的用户
     */

    /** 滑动窗口 */
    public boolean checkInclusion2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }

        if (Arrays.equals(cnt1, cnt2)) return true;

        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) return true;
        }

        return false;
    }


    /** 滑动窗口优化 */
    public boolean checkInclusion3(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }

        int diff = 0;
        for (int c : cnt) {
            if (c != 0)  ++diff;
        }

        if (diff == 0) return true;

        for (int i = n; i < m; ++i) {
            int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
            if (x == y) continue;
            if (cnt[x] == 0) ++diff;

            ++cnt[x];

            if (cnt[x] == 0) --diff;
            if (cnt[y] == 0) ++diff;

            --cnt[y];

            if (cnt[y] == 0) --diff;
            if (diff == 0) return true;
        }

        return false;
    }



    /** 双指针 */
    public boolean checkInclusion4(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m)  return false;

        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }

        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n)  return true;
        }

        return false;
    }


    // 这道题的解法太妙了，运用了很多技巧。 [官方题解](https://leetcode-cn.com/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-leetcode-solut-7k7u/)
    // 真的牛逼，滑动窗口！将找排列转化为统计字符个数的hashmap，太强了

}
