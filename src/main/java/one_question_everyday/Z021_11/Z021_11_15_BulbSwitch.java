package one_question_everyday.Z021_11;

/**
 * 初始时有 n 个灯泡处于关闭状态。
 * 第一轮，你将会打开所有灯泡。
 * 接下来的第二轮，你将会每两个灯泡关闭一个。
 * 第三轮，你每三个灯泡就切换一个灯泡的开关（即，打开变关闭，关闭变打开）。
 * 第 i 轮，你每 i 个灯泡就切换一个灯泡的开关。
 * 直到第 n 轮，你只需要切换最后一个灯泡的开关。
 * 找出并返回 n 轮后有多少个亮着的灯泡。
 *
 *
 * 示例 1：
 * ![](https://assets.leetcode.com/uploads/2020/11/05/bulb.jpg)
 * 输入：n = 3
 * 输出：1
 * 解释：
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭].
 *
 * 你应该返回 1，因为只有一个灯泡还亮着。
 *
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：1
 *  
 *
 * 提示：
 * 0 <= n <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bulb-switcher
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/11/15 6:46
 */
public class Z021_11_15_BulbSwitch {

    public int bulbSwitch(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int gap =3, i=0, j=0;
        while (i <= n){
            map.put(i,j++);
            i = i+gap;
            gap = gap+2;
        }
        int key = 0;
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            key = Math.max(key, iterator.next());
        }
        return map.containsKey(n) ? map.get(n) : map.get(key)+1;
    }

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了5.12%的用户
     * 内存消耗：37.5 MB, 在所有 Java 提交中击败了5.40%的用户
     */

    // 一开始尝试简单模拟来实现，结果发现数据量太大，会导致内存超出和超时。
    // 琢磨着可能有规律，结果还真找到了规律，就按照规律写了下代码，写的还蛮艰难。
    // [参考题解](https://leetcode-cn.com/problems/bulb-switcher/solution/gong-shui-san-xie-jing-dian-shu-lun-tui-upnnb/)
    // 看了眼题解之后 -> 什么瞎几把题目。(╯‵□′)╯︵┻━┻

}
