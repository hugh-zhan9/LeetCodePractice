package first_practice.array.easy;

import java.util.*;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 *
 * 示例 2:
 * 输入: rowIndex = 0
 * 输出: [1]
 *
 * 示例 3:
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *  
 * 提示:
 * 0 <= rowIndex <= 33
 *  
 * 进阶：
 * 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * @author zyk
 * @description
 * @since 2021/8/11 6:22
 */
public class Triangle2_119 {

    /** 使用118题的解法肯定可行，但是题目最后希望可否使用空间复杂度O(rowIndex)的解法
     *
     *  一开始想套用上一题的解法，思路是想到了，但是没有考虑到计算顺序。
     *  如果从前往后算的话会覆盖上一个行的结果，导致后面的结果出错
     *  看了题解之后，可以从后往前算，这样就不会覆盖上一行的结果
     *
     *  list.add(index,value) 这个并不会覆盖已存在位置的值，
     *  可以使用list.set(index,value) 来覆盖已存在位置的值。
     */
    /** 看了题解，这种方法叫滚动数组 */
    /** 时间复杂度O(n²) */
    public List<Integer> getRow(int rowIndex){
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for(int row=1;row<=rowIndex;row++){
            result.add(0);
            for(int column=row; column>0; column--){
                result.set(column,result.get(column)+result.get(column-1));
            }
        }
        return result;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了81.60%的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了36.63%的用户
     */


    /** 题解：线性递推 https://leetcode-cn.com/problems/pascals-triangle-ii/solution/yang-hui-san-jiao-ii-by-leetcode-solutio-shuk/
     * 还是没太看懂
     */
     /** 时间复杂度O(n) */
    public List<Integer> getRow1(int rowIndex){
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }



    public static void main(String[] args) {
        Triangle2_119 solution = new Triangle2_119();
        List<Integer> resultList = solution.getRow(4);
        for (Integer a: resultList) {
            System.out.println(a);
        }
    }
}
