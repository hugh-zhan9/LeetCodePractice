package first_practice.string.easy;

/**
 * 给你一个整数 columnNumber，返回它在 Excel 表中相对应的列名称。
 *
 *
 * 例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *  
 *
 * 示例 1：
 * 输入：columnNumber = 1
 * 输出："A"
 *
 * 示例 2：
 * 输入：columnNumber = 28
 * 输出："AB"
 *
 * 示例 3：
 * 输入：columnNumber = 701
 * 输出："ZY"
 *
 * 示例 4：
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 *  
 *
 * 提示：
 * 1 <= columnNumber <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/9/26 22:05
 */
public class ConvertToTitle_168 {

    public String convertToTitle(int columnNumber) {
        StringBuffer r = new StringBuffer();
        int count;
        while (columnNumber > 0){
            count = columnNumber%26;
            columnNumber = columnNumber/26;
            char i = (char) (count +'A' -1);
            r.append(i);
        }
        r.reverse();
        return r.toString();
    }


    public static void main(String[] args) {
        ConvertToTitle_168 convert = new ConvertToTitle_168();
        System.out.println(convert.convertToTitle(28));
    }

}
