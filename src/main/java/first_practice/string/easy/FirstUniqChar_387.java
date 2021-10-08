package first_practice.string.easy;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 * s = "leetcode"
 * 返回 0
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author zyk
 * @description
 * @since 2021/10/8 10:29
 */
public class FirstUniqChar_387 {

    /** 使用哈希表存储索引 */
    public int firstUniqChar(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < length; ++i) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < length; ++i) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


    /** 使用哈希表存储索引 */
    public int firstUniqChar2(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            if (position.containsKey(s.charAt(i))) {
                position.put(s.charAt(i), -1);
            } else {
                position.put(s.charAt(i), i);
            }
        }
        int first = length;
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            if (entry.getValue() != -1 && entry.getValue() < first) {
                first = entry.getValue();
            }
        }
        if (first == length) {
            first = -1;
        }
        return first;
    }


    /**
     * 借助队列找到第一个不重复的字符。队列具有「先进先出」的性质，因此很适合用来找出第一个满足某个条件的元素。
     *
     * 具体地，使用与方法二相同的哈希映射，并且使用一个额外的队列，
     * 按照顺序存储每一个字符以及它们第一次出现的位置。
     * 当对字符串进行遍历时，设当前遍历到的字符为 c，如果 c 不在哈希映射中，就将 c 与它的索引作为一个二元组放入队尾，否则就需要检查队列中的元素是否都满足「只出现一次」的要求，
     * 即不断地根据哈希映射中存储的值（是否为 -1）选择弹出队首的元素，直到队首元素「真的」只出现了一次或者队列为空。
     *
     * 在遍历完成后，如果队列为空，说明没有不重复的字符，返回 -1，否则队首的元素即为第一个不重复的字符以及其索引的二元组。
     *
     * 小贴士
     *
     * 在维护队列时，使用了「延迟删除」这一技巧。
     * 也就是说，即使队列中有一些字符出现了超过一次，但它只要不位于队首，那么就不会对答案造成影响，也就可以不用去删除它。
     * 只有当它前面的所有字符被移出队列，它成为队首时，才需要将它移除。
     *
     */
    public int firstUniqChar3(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        Queue<Pair> queue = new LinkedList<Pair>();
        int length = s.length();

        for (int i = 0; i < length; ++i) {
            if (!position.containsKey(s.charAt(i))) {
                position.put(s.charAt(i), i);
                queue.offer(new Pair(s.charAt(i), i));
            } else {
                position.put(s.charAt(i), -1);
                // 如果队列不为空 并且 该元素出现了两次及以上则移除
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }


    // [题解](https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-x9rok/)
}


class Pair {
    char ch;
    int pos;

    Pair(char ch, int pos) {
        this.ch = ch;
        this.pos = pos;
    }
}