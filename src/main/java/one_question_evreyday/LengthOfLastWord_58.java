package one_question_evreyday;

/**
 * 给你一个字符串s，由若干单词组成，单词前后用一些空格字符隔开。
 * 返回字符串中最后一个单词的长度。
 * 单词是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *  
 *
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 *
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 *
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 *  
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/9/21 9:07
 */
public class LengthOfLastWord_58 {

    public int lengthOfLastWord(String s) {
        String[] array = s.split(" ");
        String world = array[array.length - 1];
        return world.toCharArray().length;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了37.87%的用户
     * 内存消耗：36.8 MB, 在所有 Java 提交中击败了27.47%的用户
     */


    public int lengthOfLastWord2(String s) {
        char[] chars = s.toCharArray();
        int start=-1;
        char point = ' ';
        for (int i=chars.length-1; i>=0; i--){
            if (start == -1 && point != chars[i]) start = i;
            if (start !=-1 && point == chars[i]) return start-i;
        }
        if (start != -1) return start+1;
        else return 0;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.8 MB, 在所有 Java 提交中击败了29.76%的用户
     */


    public static void main(String[] args) {
        LengthOfLastWord_58 test = new LengthOfLastWord_58();
        test.lengthOfLastWord2("abc d");

    }

}
