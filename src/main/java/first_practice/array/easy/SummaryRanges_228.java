package first_practice.array.easy;

/**
 * 给定一个无重复元素的有序整数数组 nums 。返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *  
 *
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 * 示例 3：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：["-1"]
 *
 * 示例 5：
 * 输入：nums = [0]
 * 输出：["0"]
 *  
 *
 * 提示：
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyk
 * @description
 * @since 2021/8/18 8:43
 */
public class SummaryRanges_228 {

    /** 这基本上只能算是一道业务实现题，没有使用什么算法 */
    /** 可以对比一下String和StringBuffer的效率问题 */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int low = i;
            i++;
            while (i < nums.length && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(nums[high]);
            }
            result.add(temp.toString());
        }
        return result;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了87.04%的用户
     */


    public List<String> summaryRanges2(int[] nums) {
        List<String> result = new ArrayList<>();
        int i=0;
        while (i<nums.length){
            int low=i;
            i++;
            while (i<nums.length && nums[i]-nums[i-1]==1){
                i++;
            }
            int high = i-1;
            if (high>low){
                result.add(nums[low]+"->"+nums[high]);
            }else {
                result.add(String.valueOf(nums[low]));
            }
        }
        return result;
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了55.47%的用户
     * 内存消耗：36.7 MB, 在所有 Java 提交中击败了48.67%的用户
     */


    /** for循环实现版本 */
    public List<String> summaryRanges3(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                continue;
            }
            if (i == j) {
                list.add(nums[i] + "");
            } else {
                list.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return list;
    }

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了50.34%的用户
     * 内存消耗：36.8 MB, 在所有 Java 提交中击败了34.88%的用户
     */


    public static void main(String[] args) {
        SummaryRanges_228 solution = new SummaryRanges_228();
        int[] nums = new int[]{0,2,3,4,6,8,9};
        List<String> strings = solution.summaryRanges2(nums);
        for (String s: strings){
            System.out.println(s);
        }
    }
}
