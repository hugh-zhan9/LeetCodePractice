package first_practice.hash.easy;

/**
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 *
 * 示例 1:
 * 输入: candies = [1,1,2,2,3,3]
 * 输出: 3
 * 解析: 一共有三种种类的糖果，每一种都有两个。
 *      最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 *
 * 示例 2 :
 * 输入: candies = [1,1,2,3]
 * 输出: 2
 * 解析: 妹妹获得糖果[2,3]，弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
 *
 * 注意:
 * 数组的长度为[2, 10,000]，并且确定为偶数。
 * 数组中数字的大小在范围[-100,000, 100,000]内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distribute-candies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

/**
 * @author zyk
 * @description
 * @since 2021/10/20 21:10
 */
public class DistributeCandies_575 {

    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int length = candyType.length;
        int size = 0, last=-1;
        for (int i=0; i<length; i++){
            if (last != candyType[i]){
                last = candyType[i];
                size++;
            }
        }
        return size>length/2 ? length/2 : size;
    }

    /**
     * 执行用时：38 ms, 在所有 Java 提交中击败了32.23%的用户
     * 内存消耗：40.4 MB, 在所有 Java 提交中击败了51.69%的用户
     */


    public int distributeCandies2(int[] candyType) {
        int length = candyType.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<length; i++){
            map.put(candyType[i], map.getOrDefault(candyType[i],0)+1);
        }
        return map.size()>length/2 ? length/2 : map.size();
    }

    /**
     * 执行用时：42 ms, 在所有 Java 提交中击败了12.56%的用户
     * 内存消耗：40.4 MB, 在所有 Java 提交中击败了51.11%的用户
     */


    public int distributeCandies3(int[] candyType) {
        int length = candyType.length;
        Set<Integer> map = new HashSet<>();
        for (int i=0; i<length; i++){
            map.add(candyType[i]);
        }
        return map.size()>length/2 ? length/2 : map.size();
    }

    /**
     * 执行用时：32 ms, 在所有 Java 提交中击败了91.39%的用户
     * 内存消耗：40.4 MB, 在所有 Java 提交中击败了37.69%的用户
     */

}
