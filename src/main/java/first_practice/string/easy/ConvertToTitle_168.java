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

    /** 思路差不太多，还是没有想到要把它减去1，想模拟辗转相除法 */
    public String convertToTitle(int columnNumber) {
        StringBuffer r = new StringBuffer();
        int count = 0,val;
        while (columnNumber > 0){
            val = columnNumber%26;
            columnNumber = columnNumber/26;
            if (val>0){
                char i = columnNumber==0 && val==1 ? (char) (val*26 + 'A' -1) : (char) (val + 'A' -1);
                r.append(i);
            }
            count++;

        }
        r.reverse();
        return r.toString();
    }


    /** 提交的写法，过不了26的倍数 */
    public String convertToTitle2(int columnNumber) {
        StringBuffer r = new StringBuffer();
        while (columnNumber>0){
            int val = columnNumber/26;
            if (val>26){
                int s = columnNumber%26;
                char i = (char) (s + 'A' -1);
                r.append(i);
                columnNumber = columnNumber/26;
                continue;
            }else {
                int s = columnNumber%26;
                char i = (char) (s + 'A' -1);
                r.append(i);
            }
            if (val != 0){
                char i = (char) (val + 'A' -1);
                r.append(i);
            }
            break;
        }
        r.reverse();
        return r.toString();
    }



    /**
     * 题解解释得复杂了，和正常 0~25 的 26 进制相比，本质上就是每一位多加了 1。
     * 假设 A == 0，B == 1，那么 AB = 26 * 0 + 1 * 1，而现在 AB = 26 * (0 + 1) + 1 * (1 + 1)。
     * 所以只要在处理每一位的时候减 1，就可以按照正常的 26 进制来处理
     */


    public String convertToTitle3(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            // 这两行解决了余数是0的时候导致的输出@
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char)(a0 - 1 + 'A'));
            // 如果去掉 -a0 701过不了
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();
    }


    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.4 MB, 在所有 Java 提交中击败了69.06%的用户
     */

}
