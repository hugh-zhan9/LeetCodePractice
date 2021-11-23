package one_question_everyday.Z021_11;

/**
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true；否则返回 false 。
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *  
 *
 * 示例 1：
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 *
 * 示例 2：
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 *
 * 示例 3：
 * 输入：s = "aa", goal = "aa"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 *
 * 示例 4：
 * 输入：s = "aaaaaaabc", goal = "aaaaaaacb"
 * 输出：true
 *  
 *
 * 提示：
 * 1 <= s.length, goal.length <= 2 * 104
 * s 和 goal 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

/**
 * @author zyk
 * @description
 * @since 2021/11/23 10:58
 */
public class Z021_11_23_BuddyStrings {

    /**
     * 字符串长度不相等, 直接返回false
     * 字符串相等的时候, 只要有重复的元素就返回true
     * A, B字符串有不相等的两个地方, 需要查看它们交换后是否相等即可.
     */

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length() || s.length()<2) return false;
        int count=0; int[] arr = new int[2]; Map<Character, Integer> map = new HashMap();
        for (int i=0; i<s.length(); i++){
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key,0)+1);
            if (key != goal.charAt(i)){
                if (count >= 2) return false;
                arr[count] = i;
                count++;
            }
        }
        if (count == 0){
            Set<Character> characters = map.keySet();
            if (map.keySet().size() == 1) return true;
            Iterator<Character> iterator = characters.iterator();
            while (iterator.hasNext()){
                if (map.get(iterator.next()) >= 2) return true;
            }
        }else {
            if (s.charAt(arr[0]) == goal.charAt(arr[1]) && s.charAt(arr[1]) == goal.charAt(arr[0])) return true;
        }
        return false;
    }

    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了5.39%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了46.55%的用户
     */

    public static void main(String[] args) {
        Z021_11_23_BuddyStrings test = new Z021_11_23_BuddyStrings();
        System.out.println(test.buddyStrings("ab", "babbb"));
    }



    public boolean buddyStrings2(String s, String goal) {
        int n = s.length(), m = goal.length();
        if (n != m) return false;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = s.charAt(i) - 'a', b = goal.charAt(i) - 'a';
            cnt1[a]++; cnt2[b]++;
            if (a != b) sum++;
        }
        boolean ok = false;
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
            if (cnt1[i] > 1) ok = true;
        }
        return sum == 2 || (sum == 0 && ok);
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了25.69%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了80.11%的用户
     */



    public boolean buddyStrings3(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
                if (count[s.charAt(i) - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < goal.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && s.charAt(first) == goal.charAt(second) &&
                    s.charAt(second) == goal.charAt(first));
        }
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.45%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了67.54%的用户
     */


}
