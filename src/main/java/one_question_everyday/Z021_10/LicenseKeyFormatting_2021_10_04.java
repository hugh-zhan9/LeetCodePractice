package one_question_everyday.Z021_10;

/**
 * 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。
 * 其中， N 个 '-' 将字符串分成了 N+1 组。
 * 给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含K个字符。
 * 特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。
 * 两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 *
 *  
 *
 * 示例 1：
 * 输入：S = "5F3Z-2e-9-w", K = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 *      注意，两个额外的破折号需要删掉。
 *
 * 示例 2：
 * 输入：S = "2-5g-3-J", K = 2
 * 输出："2-5G-3J"
 * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
 *  
 *
 * 提示:
 * S 的长度可能很长，请按需分配大小。K 为正整数。
 * S 只包含字母数字（a-z，A-Z，0-9）以及破折号'-'
 * S 非空
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/license-key-formatting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/10/4 7:28
 */
public class LicenseKeyFormatting_2021_10_04 {

    public String licenseKeyFormatting(String s, int k) {
        String replace = s.replace("-", "").toUpperCase();
        if(replace.length() == 0){
            return "";
        }
        StringBuffer buffer = new StringBuffer(replace);
        StringBuffer result = new StringBuffer();
        int length = replace.length();
        int i = length/k;
        int j = length%k;
        result.append(replace, 0, j);
        int y=0;
        while (y<i){
            result.append("-");
            String substring = replace.substring(j+k*y,j+(k*(y+1)));
            result.append(substring);
            y++;
        }
        return j==0 ? result.substring(1) : result.toString();
    }

    /**
     * 执行用时：11 ms, 在所有 Java 提交中击败了73.51%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了32.47%的用户
     */


    public String licenseKeyFormatting2(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '-') {
                continue;
            }
            sb.append((c >= 'a' && c <= 'z')?(char)(c-32):c);
        }
        int len = sb.length()-k;
        while (len > 0){
            sb.insert(len,"-");
            len-=k;
        }
        return sb.toString();
    }

    /**
     * 执行用时：50 ms, 在所有 Java 提交中击败了18.41%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了77.02%的用户
     */

    public String licenseKeyFormatting3(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                cnt++;
                ans.append(Character.toUpperCase(s.charAt(i)));
                if (cnt % k == 0) {
                    ans.append("-");
                }
            }
        }
        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == '-') {
            ans.deleteCharAt(ans.length() - 1);
        }

        return ans.reverse().toString();
    }

    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了85.93%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了87.57%的用户
     */
}
