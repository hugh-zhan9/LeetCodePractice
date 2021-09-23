package first_practice.string.easy;

/**
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack和needle，
 * 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回 -1 。
 *
 *  
 *
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 *  
 *
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 *
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 *
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 *  
 *
 * 提示：
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/9/23 22:11
 */
public class StrStr_28 {

    /** 暴力匹配，时间复杂度O(m*n) */
    public int strStr(String haystack, String needle) {
        int aimLength = needle.length();
        int targetLength = haystack.length();
        if (aimLength == 0){
            return 0;
        }
        if (aimLength == targetLength && haystack.equals(needle)){
            return 0;
        }
        int i=0;
        int j=0;
        while (i<targetLength){
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
                if (j == aimLength){
                    return i-j+1;
                }
            }else {
                i =i-j;
                j=0;
            }
            i++;
        }
        return -1;
    }


    /**
     * 执行用时：1470 ms, 在所有 Java 提交中击败了14.24%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了36.43%的用户
     */


    /** 这直接使用了api，也是取巧了 */
    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        String replace = haystack.replace(needle, " ");
        for (int i=0; i<replace.length(); i++){
            if (replace.charAt(i) == ' '){
                return i;
            }
        }
        return -1;
    }

    /**
     * 执行用时：385 ms, 在所有 Java 提交中击败了46.38%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了51.56%的用户
     */


    /** 这写法太无耻了。。。 尝试提交了一下，发现这和第二种写法效率差不多欸 */
    public int strStr3(String haystack, String needle) {
        return haystack.indexOf(needle);
    }



    /** 还有一种KMP算法，但是这要手写KMP也太难了，不能算是简单题了 */


}
