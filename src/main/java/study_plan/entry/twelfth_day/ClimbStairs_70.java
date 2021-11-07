package study_plan.entry.twelfth_day;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/11/7 12:05
 */
public class ClimbStairs_70 {

    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


    /**
     * 思路：
     * 动态规划的三要素：重叠子问题、最优子结构、状态转移方程
     * 类似于斐波那契数列的求解，第n级台阶的求解 = 第n-1级台阶+第n-2级台阶节的和。
     * 所以可以得到 状态转移方程：f(n) = f(n-1) + f(n-2)。
     * 所以可以使用 DP table 来自底向上的计算出顶部 f(n) 的值；
     */
    public int climbStairs_dp(int n){
        if (n <= 2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1; dp[2] = 2;
        for (int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35 MB, 在所有 Java 提交中击败了89.67%的用户
     */

}
