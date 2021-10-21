package one_question_everyday.Z021_10;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 *  
 *
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import first_practice.array.easy.PlusOne_66;

/**
 * @author zyk
 * @description
 * @since 2021/10/21 6:52
 */
public class Z021_10_21_PlusOne {

    /** 改题与{@link PlusOne_66} 相同，解法思路一样，但是前者效率更高 */
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length+1];
        for (int i=digits.length-1; i>=0; i--) {
            if (digits[i] != 9){
                digits[i] = digits[i]+1;
                return digits;
            }else {
                digits[i] = 0;
            }
        }
        res[0] = 1;
        return res;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37 MB, 在所有 Java 提交中击败了15.66%的用户
     */

}
