package first_practice.string.easy;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串s，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 *  
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/9/23 6:50
 */
public class IsValid_20 {

    public boolean isValid(String s) {
        int length = s.length();
        if (length%2==1){
            return false;
        }
        int j=length-1;
        for (int i=0; i<length; i++){

        }
        return true;
    }

    public static void main(String[] args) {
        IsValid_20 test = new IsValid_20();
        test.isValid("()[]{}");
    }

}
