package one_question_everyday.Z021_11;

/**
 * 给定一个正整数 n ，你可以做如下操作：
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1 或 n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 *
 *  
 *
 * 示例 1：
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 *
 * 示例 3：
 * 输入：n = 4
 * 输出：2
 *  
 *
 * 提示：
 * 1 <= n <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/11/19 9:31
 */
public class Z021_11_19_IntegerReplacement {

    public int integerReplacement(int n) {
        return dfs(n);
    }

    public int dfs(long n){
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n % 2 ==0) return dfs(n/2) + 1;
        return Math.min(dfs((n-1)/2), dfs((n+1)/2)) + 2;
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了49.26%的用户
     * 内存消耗：35.1 MB, 在所有 Java 提交中击败了64.33%的用户
     */

}
