package study_plan.entry.third_day;

/**
 * 给定一个已按照非递减顺序排列的整数数组numbers，请你从数组中找出两个数满足相加之和等于目标数target。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。
 * numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 *  
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 *
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 *  
 *
 * 提示：
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers 按 非递减顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/10/29 9:00
 */
public class TwoSum_167 {

    public int[] twoSum(int[] numbers, int target) {
        int i=0, j=i+1;
        int[] res = new int[2];
        while (i<numbers.length-1){
            if (j == numbers.length){
                i++;
                j=i+1;
                continue;
            }

            if (numbers[i]+numbers[j]==target){
                res[0] = i+1; res[1] = j+1;
                return res;
            }else {
                j++;
            }
        }

        return res;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int i=0, j=numbers.length-1;
        int[] res = new int[2];
        while (i<j){
            if (numbers[i]+numbers[j] == target){
                res[0] = 1+i;
                res[1] = 1+j;
                return res;
            }else if (numbers[i]+numbers[j]>target){
                j--;
            }else {
                i++;
            }
        }
        return res;
    }
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了65.78%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了68.20%的用户
     */

}
