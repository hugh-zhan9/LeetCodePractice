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

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zyk
 * @description
 * @since 2021/9/23 6:50
 */
public class IsValid_20 {

    /** 评论中的解法，思路十分巧妙的同时也完美的使用了api，虽然效率不高但是值得思考 */
    public boolean isValid(String s) {
        int length = s.length();
        if (length%2==1){
            return false;
        }
        int lengthMid = s.length() / 2;
        for (int i = 0; i < lengthMid; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }
        return s.length() == 0;
    }

    /**
     * 执行用时：40 ms, 在所有 Java 提交中击败了5.30%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了6.55%的用户
     */


    /** 使用栈来解决对称结构的问题 */
    public boolean isValid2(String s) {
        int length = s.length();
        if (length%2==1){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<length; i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
            } else if (isSym(stack.peek(), s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size() == 0;
    }

    private boolean isSym(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了62.07%的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了94.37%的用户
     */


    public boolean isValid3(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            }else if (ch == '{') {
                deque.push('}');
            }else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                deque.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return deque.isEmpty();
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了62.07%的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了80.72%的用户
     */

}
