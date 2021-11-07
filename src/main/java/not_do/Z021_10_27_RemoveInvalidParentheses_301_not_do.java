package not_do;

/**
 * 给你一个由若干括号和字母组成的字符串s，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按任意顺序返回。
 *
 *  
 * 示例 1：
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 *
 * 示例 2：
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 *
 * 示例 3：
 * 输入：s = ")("
 * 输出：[""]
 *  
 *
 * 提示：
 * 1 <= s.length <= 25
 * s 由小写英文字母以及括号 '(' 和 ')' 组成
 * s 中至多含 20 个括号
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyk
 * @description
 * @since 2021/10/27 6:35
 */
public class Z021_10_27_RemoveInvalidParentheses_301_not_do {

    /** 回溯 + 剪枝 */
    public List<String> removeInvalidParentheses(String s) {
        return new ArrayList<>();
    }


    /** 广度优先搜索 */


    /** 枚举状态子集 */
}
