package first_practice.string.easy;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，
 * 你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 *  
 *
 * 示例 1：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 示例 2：
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *  
 *
 * 提示：
 * 1 <= s.length <= 105
 * s[i] 都是 ASCII 码表中的可打印字符
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/10/1 10:53
 */
public class ReverseString_344 {

    public void reverseString(char[] s) {
        int i=0, j=s.length-1;
        while (i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] =temp;
            i++; j--;
        }
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：45 MB, 在所有 Java 提交中击败了42.69%的用户
     */

    /** 位运算 */
    public void reverseString2(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; ++i) {
            int j = n - 1 - i;
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了96.01%的用户
     * 内存消耗：44.7 MB, 在所有 Java 提交中击败了91.67%的用户
     */

}
