package first_practice.array.easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * 示例 5:
 *
 * 输入: nums = [1], target = 0
 * 输出: 0
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为无重复元素的升序排列数组
 * -104 <= target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/8/7 18:19
 */
public class SearchInsert_35 {

    /** 自己写的二分查找，时间复杂度O(logn)，空间复杂度O(1)，待优化*/
    public int searchInsert(int[] nums, int target) {
        int post = 0;
        int left = 0;
        int right = nums.length-1;
        if (nums[0] >= target){
            return 0;
        }
        if (nums[nums.length-1] < target){
            return nums.length;
        }
        while (left <= right){
            int mid = ((right - left)>>1) + left;
            if (target <= nums[mid]){
                post = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return post;
    }

    /** 优化，减去判断target小于num[0]的情况*/
    public int searchInsert1(int[] nums, int target) {
        int post = 0;
        int left = 0;
        int right = nums.length-1;
        if (nums[nums.length-1] < target){
            return nums.length;
        }
        while (left <= right){
            int mid = ((right - left)>>1) + left;
            if (target <= nums[mid]){
                post = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return post;
    }

    public static void main(String[] args) {
        SearchInsert_35 solution = new SearchInsert_35();
        int[] test = new int[] {1,3,5,6};
        int ints = solution.searchInsert(test,0);
        System.out.println(ints);
    }
}
