package first_practice.array.easy;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * @author zyk
 * @description
 * @since 2021/6/9 14:11
 */
public class MergeSortedArray_88 {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        //从后往前，最大的放在num1的最后面
        int i=m-1, j=n-1, p=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]) {
                nums1[p--]=nums1[i--];
            } else {
                nums1[p--]=nums2[j--];
            }
        }
        while(j>=0) {
            nums1[p--]=nums2[j--];
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n){
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        MergeSortedArray_88 mergeSortedArray = new MergeSortedArray_88();
        int[] nums1 = {0};
        int[] nums2 = {1};
        mergeSortedArray.merge(nums1,0 ,nums2,1);
        for (int i : nums1){
            System.out.println(i);
        }
    }
}

/**
 * 解题思路：
 * 合并两个有序数组，注意到第一个数组已经开辟了相应的空间。本题需要注意的题眼，有序，注意到这个就可以考虑使用双指针的方式进行处理。
 *
 * 先分析解法二，解法二中使用了两个指针，对 nums2 进行遍历。
 * 注意，遍历的时候并没有使用for循环，因为后面的逻辑中可以发现，和 nums1 中的数进行比较时，nums2的指针不一定发生了移动。
 * 整体思路很简单，
 * 将 nums2 中的数和 nums1 中的数进行比较，若 nums2 中的数较小，则把 nums1 中所有的数都向后平移，然后插入 nums2 中当前指针索引到的数字即可，
 * 若不是，则将 nums1 的指针向后移动。
 *
 * 对于解法一来说，是参考了题解中的答案，使用三指针，并从 nums1 中后面开始插入数字，这样能够防止元素被覆盖的问题。
 * 使用三个指针，分别从 nums1 小数组（理解成长度为m的这个数组）最后一个，nums1 大数组（长度为m+n的这个数组）最后一个，
 * 以及 nums2 最后一个数开始判断比较。
 * 解答中使用的是 nums2 的指针进行循环，
 * 这样做有好处：
 * 如果使用 m+n 长度的 nums1 开始for循环的话，的确对于指针的移动比较方便，
 * 但是需要考虑的情况比较多，比如，
 * 当 nums1 中非零元素都填充完或者 nums2 中非零元素都填充完成的特殊情况，需要加入判断条件，
 * 而使用 nums2 进行 while 循环时，需要手动移动大数组的索引，
 * 但是只需要考虑 nums1 中非零元素都填充完成的特殊情况即可，因为对于 nums2 进行循环，已经隐含考虑到了 nums2 中非零元素都填充完成的特殊情况。
 * 这里一定要注意，循环时对三个索引的处理，这是逻辑的体现也是重点
 */

