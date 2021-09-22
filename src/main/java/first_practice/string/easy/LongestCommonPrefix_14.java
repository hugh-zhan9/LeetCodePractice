package first_practice.string.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * @author zyk
 * @description
 * @since 2021/9/22 9:01
 */
public class LongestCommonPrefix_14 {

    /** 我写的纵向扫描 */
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        char[] first = strs[0].toCharArray();
        for (int i=0; i<first.length; i++){
            result += first[i];
            for (int j=1; j<strs.length; j++){
                char[] others = strs[j].toCharArray();
                if (i<others.length && first[i] == others[i]){
                    continue;
                }else {
                    return result.substring(0,result.length()-1);
                }
            }
        }
        return result;
    }

    /**
     * 执行用时：13 ms, 在所有 Java 提交中击败了6.85%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了5.05%的用户
     */

    /** 优化后的纵向扫描 */
    public String longestCommonPrefix_Optimize(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        char[] first = strs[0].toCharArray();
        for (int i=0; i<first.length; i++){
            for (int j=1; j<strs.length; j++){
                char[] others = strs[j].toCharArray(); // 这一步非常影响效率
                if (i<others.length && first[i] == others[i]){
                    continue;
                }else {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了11.57%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了5.20%的用户
     */

    /** 题解中的纵向扫描 */
    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了73.72%的用户
     * 内存消耗：36.5 MB, 在所有 Java 提交中击败了53.02%的用户
     */



    /** 我写的排序之后再对比的算法 */
    public String longestCommonPrefix2(String[] strs) {
        String result = "";
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();
        for (int i=0; i<first.length; i++){
            if (first[i] == last[i]){
                result += first[i];
            }else {
                return result;
            }
        }
        return result;
    }

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了9.44%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了5.05%的用户
     */

    /** 排序之后再对比的算法优化 */
    public String longestCommonPrefix2_Optimize(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String first = strs[0];
        int length = first.length();
        String last = strs[strs.length - 1];
        for (int i=0; i<length; i++){
            if (first.charAt(i) != last.charAt(i)){
                return first.substring(0,i);
            }
        }
        return first;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了73.72%的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了74.90%的用户
     */

    /** 可以看到：字符串拼接特别耗费时间 */

    /**
     * 总结：
     *
     * 可以看到 我写的纵向扫描的逻辑和题解中的逻辑基本上是一致的，
     * 但是我使用的是toCharArray()方法，而题解中使用的是CharAt()方法
     * 所以效率差距主要就体现在了这两个方法的差别上，下面是结论：
     * 1. String 使用 charAt() 比使用 toCharArray() 遍历，效率要高。
     * 2. 避免在 for 循环中使用 s.length() 方法，可以显著提升效率。
     * 3. 虽然底层都调用了 C 语言的 Native 方法，
     *      toCharArray 多了复制数组的一个步骤，所以会慢，
     *      因为 String 的数据结构本来也是数组。
     * 4. 最好不要在 for 循环条件里面写方法，会影响效率
     * 5. 尽量不要直接拼接字符串，尤其是在循环里，非常耗时，
     *      因为字符串是不可变的，在连接时首先为新字符串分配足够的空间，
     *      复制旧字符串中的内容，并附加到新字符串。
     *
     * https://www.jianshu.com/p/6546ce752f3e
     */


    /** 评论中看到的一个解法，startWith方法的调用，没使用过该api */
    public String longestCommonPrefix_submission(String[] strs) {
        if(strs.length==0)return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length()==0)return "";
                //公共前缀不匹配就让它变短！
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }






    /** 横向扫描 */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.6 MB, 在所有 Java 提交中击败了42.33%的用户
     */


    /** 分治算法 */
     public String longestCommonPrefix5(String[] strs) {
         if (strs == null || strs.length == 0) {
             return "";
         } else {
             return longestCommonPrefix(strs, 0, strs.length - 1);
         }
     }

     public String longestCommonPrefix(String[] strs, int start, int end) {
         if (start == end) {
             return strs[start];
         } else {
             int mid = (end - start) / 2 + start;
             String lcpLeft = longestCommonPrefix(strs, start, mid);
             String lcpRight = longestCommonPrefix(strs, mid + 1, end);
             return commonPrefix(lcpLeft, lcpRight);
         }
     }

     public String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
     }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.6 MB, 在所有 Java 提交中击败了28.97%的用户
     */


    /** 二分查找 */
    public String longestCommonPrefix6(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了73.72%的用户
     * 内存消耗：36.5 MB, 在所有 Java 提交中击败了46.38%的用户
     */


}
