package first_practice.string.easy;

/**
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 *
 *  
 * 例如：
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *  
 *
 * 示例 1:
 * 输入: columnTitle = "A"
 * 输出: 1
 *
 * 示例 2:
 * 输入: columnTitle = "AB"
 * 输出: 28
 *
 *
 * 示例 3:
 * 输入: columnTitle = "ZY"
 * 输出: 701
 *
 * 示例 4:
 * 输入: columnTitle = "FXSHRXW"
 * 输出: 2147483647
 *  
 *
 * 提示：
 * 1 <= columnTitle.length <= 7
 * columnTitle 仅由大写英文组成
 * columnTitle 在范围 ["A", "FXSHRXW"] 内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/9/28 10:15
 */
public class TitleToNumber_171 {

    /** 朴素的进制转换思想，哈哈哈 */
    public int titleToNumber(String columnTitle) {
        int result =0;
        int j=0;
        for (int i=columnTitle.length()-1; i>=0; i--){
            result += (columnTitle.charAt(i)-'A'+1) * Math.pow(26,j);
            j++;
        }
        return result;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了46.41%的用户
     */

}
