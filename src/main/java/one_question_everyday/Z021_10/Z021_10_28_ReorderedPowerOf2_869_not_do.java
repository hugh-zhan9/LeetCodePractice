package one_question_everyday.Z021_10;

/**
 * 给定正整数 N，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * 如果我们可以通过上述方式得到2的幂，返回 true；否则，返回 false。
 *
 *  
 *
 * 示例 1：
 * 输入：1
 * 输出：true
 *
 * 示例 2：
 * 输入：10
 * 输出：false
 *
 * 示例 3：
 * 输入：16
 * 输出：true
 *
 * 示例 4：
 * 输入：24
 * 输出：false
 *
 * 示例 5：
 * 输入：46
 * 输出：true
 *  
 *
 * 提示：
 * 1 <= N <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reordered-power-of-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zyk
 * @description
 * @since 2021/10/28 15:18
 */
public class Z021_10_28_ReorderedPowerOf2_869_not_do {

    static Set<Integer> set = new HashSet<>();

    static {
        for (int i = 1; i < (int)1e9+10; i *= 2) set.add(i);
    }

    public boolean reorderedPowerOf2(int n) {
        int[] cnts = new int[10];
        while (n != 0) {
            cnts[n % 10]++;
            n /= 10;
        }
        int[] cur = new int[10];
        // 这是标签，用于跳出循环的。break用于跳出包含它的最内层循环，break out可以直接跳出被out标记的循环
        out:for (int x : set) {
            Arrays.fill(cur, 0);
            while (x != 0) {
                cur[x % 10]++;
                x /= 10;
            }
            for (int i = 0; i < 10; i++) {
                if (cur[i] != cnts[i]) continue out;
            }
            return true;
        }
        return false;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了97.93%的用户
     * 内存消耗：35.3 MB, 在所有 Java 提交中击败了70.54%的用户
     */

}
