package one_question_everyday;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，
 * 每 2k 个字符反转前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 *
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 *
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *  
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/8/20 10:19
 */

// [题目链接](https://leetcode-cn.com/problems/reverse-string-ii/submissions/)

public class Z021_08_20_ReverseStr {

    /** 暴力解， 时间复杂度O()*/
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        // 有几个完整地2k
        int n = length/(2*k);
        // 余数
        int m = length%(2*k);
        for (int y=0; y<n; y++){
            int i=2*y*k,j=2*y*k+k-1;
            reverse(chars,i,j);
        }
        if (m<k){
            reverse(chars,2*n*k,chars.length-1);
        }if (m>=k && m<2*k){
            reverse(chars,2*n*k,2*n*k+k-1);
        }

        return String.valueOf(chars);
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了55.82%的用户
     */

    /***
     * 太难得了，第一次完全靠自己做出每日一题，即使是一道简单题。
     * 3次解答错误，3次执行报错，各种边界条件处理不好。。。
     * 太菜了，还是要多练习
     */


    /** 看了题解，umm，我写的是个什么玩意。。。*/


    /** 模拟法 */
    public String reverseStr2(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了93.16%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了65.64%的用户
     */



    public char[] reverse(char[] chars, int start,int end){
        while (start<end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;end--;
        }
        return chars;
    }

}

