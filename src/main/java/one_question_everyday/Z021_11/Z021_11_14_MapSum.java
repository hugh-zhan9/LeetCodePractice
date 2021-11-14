package one_question_everyday.Z021_11;

/**
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key，整数表示值 val。
 * 如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *  
 *
 * 示例：
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *  
 *
 * 提示：
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author zyk
 * @description
 * @since 2021/11/14 20:18
 */
public class Z021_11_14_MapSum {

    private HashMap<String, Integer> map;

    public Z021_11_14_MapSum() {
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key,val);
    }

    public int sum(String prefix) {
        int count = 0, length = prefix.length();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            if (key.length()>=length && prefix.equals(key.substring(0,length))){
                count += map.get(key);
            }
        }
        return count;
    }

    /**
     * 执行用时：12 ms, 在所有 Java 提交中击败了66.71%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了55.95%的用户
     */


    // 上面是最简单的暴力解法，参考题解后发现可以使用前缀树来进行处理，等学习完之后再来补充

    // TODO: 2021/11/14 前缀树解法 

}



/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
