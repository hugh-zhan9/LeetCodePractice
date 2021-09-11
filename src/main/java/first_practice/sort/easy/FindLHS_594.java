package first_practice.sort.easy;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：2
 *
 * 示例 3：
 * 输入：nums = [1,1,1,1]
 * 输出：0
 *  
 *
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/9/11 20:07
 */
public class FindLHS_594 {

    /** 连续子序列只需要满足在原数组中顺序相同即可不需要真的连续，如1，2，3，4；那么1，4可以是一个子序列 */
    /** 之前总是同时考虑比nums[i]大一和小一的情况，其实只需要考虑大一或小一的情况就好了 */
    public int findLHS(int[] nums) {
        int result = 0;
        for (int i=0; i<nums.length; i++){
            int count = 0;
            boolean flag = false;
            for (int j=0; j<nums.length; j++){
                if (nums[i] == nums[j]){
                    count++;
                }else if (nums[j]+1 == nums[i]){
                    count++;
                    flag = true;
                }
            }
            if (flag){
                result = Math.max(result,count);
            }
        }
        return result;
    }

    /**
     * 超时了、、、
     */

    public int findLHS2(int[] nums) {
        Map< Integer, Integer > map = new HashMap <> ();
        int result = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key: map.keySet()) {
            if (map.containsKey(key + 1)){
                result = Math.max(result, map.get(key) + map.get(key + 1));
            }
        }
        return result;
    }

    /**
     * 执行用时：18 ms, 在所有 Java 提交中击败了58.05%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了54.06%的用户
     */

}
