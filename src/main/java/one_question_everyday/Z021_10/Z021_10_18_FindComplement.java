package one_question_everyday.Z021_10;

/**
 * 给你一个正整数 num，输出它的补数。补数是对该数的二进制表示取反。
 *  
 *
 * 示例 1：
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 *
 * 示例 2：
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *  
 *
 * 提示：
 * 给定的整数 num 保证在 32 位带符号整数的范围内。
 * num >= 1
 * 你可以假定二进制数不包含前导零位。
 * 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * @author zyk
 * @description
 * @since 2021/10/18 9:14
 */
public class Z021_10_18_FindComplement {


    /**
     * 思路与算法
     * 根据题目的要求，我们需要将 num 二进制表示的每一位取反。然而在计算机存储整数时，并不会仅仅存储有效的二进制位。
     * 例如当 num=5 时，它的二进制表示为 (101)₂，而使用 32 位整数存储时的结果为：(0000 0000 0000 0000 0000 0000 0000 0101) ₂
     *
     * 因此我们需要首先找到 num 二进制表示最高位的那个 1，再将这个 1 以及更低的位进行取反。
     * 如果 num 二进制表示最高位的 11 是第 i (0≤i≤30) 位，那么一定有：2^i ≤ num < 2^(i+1)
     *
     * 因此我们可以使用一次遍历，在 [0,30] 中找出 i 的值。
     * 在这之后，我们就可以遍历 num 的第 0 ∼ i 个二进制位，将它们依次进行取反。
     *
     * 我们也可以用更高效的方式，构造掩码 mask=2^(i+1) −1，它是一个 i+1 位的二进制数，并且每一位都是 1。
     * 我们将 num 与 mask 进行异或运算，即可得到答案。
     *
     * 细节
     * 当 i=30 时，构造 mask=2 ^(i+1) −1 的过程中需要保证不会产生整数溢出。
     */
    public int findComplement(int num) {
        int highBit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (num >= 1 << i) {
                highBit = i;
            } else {
                break;
            }
        }
        int mask = highBit == 30 ? 0x7fffffff : (1 << (highBit + 1)) - 1;
        // 异或运算两个位相同为0，相异为1
        return num ^ mask;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.1 MB, 在所有 Java 提交中击败了81.62%的用户
     */




    public int findComplement2(int num) {
        StringBuffer buffer = new StringBuffer();
        String str = Integer.toBinaryString(num);
        int length = str.length();
        for (int i=0; i<length; i++){
            if (str.charAt(i)=='1'){
                buffer.append('0');
            }else {
                buffer.append('1');
            }
        }
        return Integer.valueOf(buffer.toString(),2);
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了13.18%的用户
     * 内存消耗：35 MB, 在所有 Java 提交中击败了89.13%的用户
     */




    /**
     * 返回对 num 的二进制表示取反的数，注意 num 的二进制表示是不包含前导零的。
     * 因此主要问题变成：求 num 最高位 1 的位置。
     * 一个简单的做法是：先对 num 进行「从高到低」的检查，找到最高位 1 的位置 s，然后再对 num 进行遍历，将低位到 s 位的位置执行逐位取反操作。
     */
    public int findComplement3(int num) {
        int s = -1;
        // 找第一位 1
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) != 0) {
                s = i;
                break;
            }
        }
        int ans = 0;
        for (int i = 0; i < s; i++) {
            if (((num >> i) & 1) == 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.3 MB, 在所有 Java 提交中击败了40.93%的用户
     */



}
