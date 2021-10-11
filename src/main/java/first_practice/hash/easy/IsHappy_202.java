package first_practice.hash.easy;


import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 * 如果可以变为 1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true；不是，则返回 false。
 *
 *  
 *
 * 示例 1：
 * 输入：19
 * 输出：true
 * 解释：
 * 1² + 9² = 82
 * 8² + 2² = 68
 * 6² + 8² = 100
 * 1² + 0² + 0² = 1
 *
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 *  
 *
 * 提示：
 * 1 <= n <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class IsHappy_202{

    public boolean isHappy(int n) {
        Set<Integer> map = new HashSet<>();
        while (n != 1){
            n = calculate2(n);
            if (map.contains(n)){
                return false;
            }else {
                map.add(n);
            }
        }
        return true;
    }


    private int calculate(int n){
        int result = 0;
        String string = String.valueOf(n);
        int length = string.length();
        for (int i=0; i<length; i++){
            result += Math.pow(string.charAt(i)-'0', 2);
        }
        return result;
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了12.46%的用户
     * 内存消耗：35.5 MB, 在所有 Java 提交中击败了37.88%的用户
     */

    private int calculate2(int n){
        int result = 0;
        while (n>0){
            result += Math.pow(n%10, 2);
            n = n/10;
        }
        return result;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了96.65%的用户
     * 内存消耗：35.4 MB, 在所有 Java 提交中击败了57.44%的用户
     */





    /** 快慢指针，类似于在链表中找环 */
    public boolean isHappy2(int n) {
        int slow = n , fast = calculate2(n);
        while (fast != 1 && slow != fast){
            slow = calculate(slow);
            fast = calculate(calculate(fast));
        }
        return fast == 1;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了96.65%的用户
     * 内存消耗：35.2 MB, 在所有 Java 提交中击败了85.77%的用户
     */


    /**
     * 这道题的思路十分新颖，加深了我对算法的理解，算法是 思路+实现。
     * 思路是更重要的，没有思路就很难实现了。
     *
     * 这道题的题解值得多看一下 [题解地址](https://leetcode-cn.com/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/)
     */
}
