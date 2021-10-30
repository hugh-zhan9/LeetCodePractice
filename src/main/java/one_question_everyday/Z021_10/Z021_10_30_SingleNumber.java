package one_question_everyday.Z021_10;

/**
 * 给定一个整数数组nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *  
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 *  
 * 示例 1：
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 *
 * 示例 2：
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 *
 * 示例 3：
 * 输入：nums = [0,1]
 * 输出：[1,0]
 *
 * 提示：
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/10/30 19:04
 */
public class Z021_10_30_SingleNumber {

    public int[] singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int[] res = new int[2]; int index =0;
        for (Map.Entry<Integer,Integer> m: map.entrySet()){
            if (m.getValue() == 1){
                res[index++] =m.getKey();
            }
        }
        return res;
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了10.85%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了27.51%的用户
     */


    /** 线性时间复杂度的解法：位运算，但是不知道怎么实现 */

}
