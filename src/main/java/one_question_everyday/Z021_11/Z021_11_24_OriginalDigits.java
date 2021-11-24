package one_question_everyday.Z021_11;

/**
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按升序返回原始的数字。
 *
 * 示例 1：
 * 输入：s = "owoztneoer"
 * 输出："012"
 *
 * 示例 2：
 * 输入：s = "fviefuro"
 * 输出："45"
 *  
 *
 * 提示：
 * 1 <= s.length <= 105
 * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
 * s 保证是一个符合题目要求的字符串
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/11/24 15:10
 */
public class Z021_11_24_OriginalDigits {

    static String[] english = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static int[] number = new int[]{0, 8, 6, 3, 2, 7, 5, 9, 4, 1};
    public String originalDigits(String s) {
        int length = s.length();
        int[] sArray = new int[26];
        for (int i = 0; i < length; i++) sArray[s.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i : number) {
            int k = Integer.MAX_VALUE;
            for (char c : english[i].toCharArray()) k = Math.min(k, sArray[c - 'a']);
            for (char c : english[i].toCharArray()) sArray[c - 'a'] -= k;
            while (k-- > 0) sb.append(i);
        }
        char[] cs = sb.toString().toCharArray();
        Arrays.sort(cs);
        return String.valueOf(cs);
    }

    /**
     * 因为 z 这个字母只有zero有，所以有几个z就代表有几个0. 以此类推:
     * four的u， six的x， two的w， one的o （因为其它有o的已经被排除了），
     * five的f （同上）， seven的v， nine的n， three的r， 和最后eight任意一个字母都行。
     * 最后把数排序一下构建字符串即可
     */

    public String originalDigits2(String s) {
        Map<Character, Integer> c = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            c.put(ch, c.getOrDefault(ch, 0) + 1);
        }

        int[] cnt = new int[10];
        cnt[0] = c.getOrDefault('z', 0);
        cnt[2] = c.getOrDefault('w', 0);
        cnt[4] = c.getOrDefault('u', 0);
        cnt[6] = c.getOrDefault('x', 0);
        cnt[8] = c.getOrDefault('g', 0);

        cnt[3] = c.getOrDefault('h', 0) - cnt[8];
        cnt[5] = c.getOrDefault('f', 0) - cnt[4];
        cnt[7] = c.getOrDefault('s', 0) - cnt[6];

        cnt[1] = c.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = c.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < cnt[i]; ++j) {
                ans.append((char) (i + '0'));
            }
        }
        return ans.toString();
    }

}

