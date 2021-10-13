package first_practice.hash.easy;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author zyk
 * @description
 * @since 2021/10/13 9:34
 */
public class LongestPalindrome_409 {


    /** 提交出错，忽略了一部分数据，出现次数为单数的字符串全部都加入了进去 */
    public int longestPalindrome(String s) {
        int result = 0, length = s.length();
        boolean hasOne = false , hasMoreOne = false;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<length; i++){
            int key = s.charAt(i)-'a';
            map.put(key, map.getOrDefault(key,0)+1);
        }
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            Integer value = map.get(iterator.next());
            if (value%2==0){
                result+=value;
            }else if (value%2==1 && value>1){
                result+=value;
                hasMoreOne = true;
            } else {
                hasOne = true;
            }
        }
        return !hasMoreOne&&hasOne? ++result : result;
    }


    /** 提交出错，忽略了一部分数据，出现次数为单数的字符中有一部分可以用来组成回文串 */
    public int longestPalindrome2(String s) {
        int result = 0, length = s.length(), hasOneCount=0; boolean hasOne = false , hasMoreOne = false;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<length; i++){
            int key = s.charAt(i)-'a';
            map.put(key, map.getOrDefault(key,0)+1);
        }
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            Integer value = map.get(iterator.next());
            if (value%2==0){
                result+=value;
            }else if (value%2==1 && value>1){
                if (hasMoreOne && hasOneCount<value){
                    result+=value-hasOneCount;
                }else {
                    result+=value;
                }
                hasOneCount = value;
                hasMoreOne = true;
            } else {
                hasOne = true;
            }
        }
        return !hasMoreOne&&hasOne? ++result : result;
    }


    public int longestPalindrome3(String s) {
        int result = 0, length = s.length(); boolean hasOne = false , hasMoreOne = false;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<length; i++){
            int key = s.charAt(i)-'a';
            map.put(key, map.getOrDefault(key,0)+1);
        }
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            Integer value = map.get(iterator.next());
            if (value%2==0){
                result+=value;
            }else if (value%2==1 && value>1){
                if (hasMoreOne){
                    result+=value-1;
                }else {
                    result+=value;
                }
                hasMoreOne = true;
            } else {
                hasOne = true;
            }
        }
        return !hasMoreOne&&hasOne? ++result : result;
    }

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了24.21%的用户
     * 内存消耗：36.8 MB, 在所有 Java 提交中击败了34.46%的用户
     */

    public int longestPalindrome4(String s) {
        int result = 0, length = s.length();
        Map<Integer,Integer> map = new HashMap<>(128);
        for (int i=0; i<length; i++){
            int key = s.charAt(i);
            map.put(key, map.getOrDefault(key,0)+1);
        }
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            Integer value = map.get(iterator.next());
            result += value/2 * 2;
            if (value%2 ==1 && result%2==0){
                result++;
            }
        }
        return result;
    }

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了33.21%的用户
     * 内存消耗：36.7 MB, 在所有 Java 提交中击败了42.11%的用户
     */


    /** 题解中的写法，思路差不多，但是后面判断的时候巧妙了许多，对比一下数组的效率还是高太多了 */
    public int longestPalindrome5(String s) {
        int[] count = new int[128];
        int length = s.length(), ans=0;
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        for (int v: count) {
            // 舍弃了出现次数为单次中多出的那个一个和只出现一次的字符
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.5 MB, 在所有 Java 提交中击败了78.47%的用户
     */
    
}
