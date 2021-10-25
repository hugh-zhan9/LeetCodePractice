package one_question_everyday.Z021_10;

/**
 * 编写一个高效的算法来搜索m x n矩阵 matrix中的一个目标值target。
 * 该矩阵具有以下特性：
 *  每行的元素从左到右升序排列。
 *  每列的元素从上到下升序排列。
 *  
 * 示例 1：
 * ![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/25/searchgrid2.jpg)
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 * 示例 2：
 * ![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/25/searchgrid.jpg)
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *  
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/10/25 18:58
 */
public class Z021_10_25_SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int i=0, j=0, count=0, m = matrix.length, n = matrix[0].length;
        while (i < m && count>-1){
            if (matrix[i][j] > target){
                i++;
                count = j;
                j=0;
                continue;
            }else if (matrix[i][j] == target){
                return true;
            }else {
                j++;
                if (j >= n){
                    i++;
                    count = j;
                    j=0;
                    continue;
                }
            }
        }
        return false;
    }

    /**
     * 执行用时：18 ms, 在所有 Java 提交中击败了7.24%的用户
     * 内存消耗：44.1 MB, 在所有 Java 提交中击败了19.70%的用户
     */





    // [题解中的解法](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-so-9hcx/)


    /** 二分查找法
     *
     * 由于矩阵 matrix 中每一行的元素都是升序排列的，因此我们可以对每一行都使用一次二分查找，
     * 判断 target 是否在该行中，从而判断 target 是否出现。
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }



    /** Z字查找
     *
     * 从矩阵 matrix 的右上角 (0, n-1) 进行搜索。
     * 在每一步的搜索过程中，如果我们位于位置 (x, y)，
     * 那么我们希望在以 matrix 的左下角为左下角、以 (x, y) 为右上角的矩阵中进行搜索，
     * 即行的范围为 [x,m−1]，列的范围为 [0,y]：
     */
    public boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

}
