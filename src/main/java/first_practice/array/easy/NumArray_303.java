package first_practice.array.easy;

/**
 * 给定一个整数数组 nums，求出数组从索引 i 到 j（i≤j）范围内元素的总和，包含 i、j 两点。
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i≤j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *  
 *
 * 示例：
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *  
 *
 * 提示：
 * 0 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 * 最多调用 104 次 sumRange 方法
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/8/19 10:08
 */


/** 
* 说实话，没看懂题目是什么意思，看了题解才知道。
* 不过这种使用一个数组来存储求和之后的元素的思路很妙
*/
public class NumArray_303 {

    private int[] sums;

    public NumArray_303(int[] nums) {
        sums = new int[nums.length+1];
        for (int i=0; i<nums.length; i++){
            sums[i+1] = sums[i]+nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right+1] - sums[left];
    }

    public static void main(String[] args) {
        NumArray_303 solution = new NumArray_303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(solution.sumRange(2,5));
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
