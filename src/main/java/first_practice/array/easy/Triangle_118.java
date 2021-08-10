package first_practice.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 *  
 *
 * 提示:
 * 1 <= numRows <= 30
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/8/10 9:12
 */
public class Triangle_118 {

    /** 暴力解法，时间复杂度O(n²)，空间复杂度O(1) */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        for (int i=0;i<numRows;i++){
            List<Integer> list = new ArrayList<Integer>();
            for (int j=0; j<=i; j++){
                if (j==0 || j==i){
                    list.add(1);
                }else {
                    list.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
                }
            }
            triangle.add(list);
        }
        return triangle;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了40.71%的用户
     */

    public static void main(String[] args) {
        Triangle_118 solution = new Triangle_118();
        int numRows = 5;
        List<List<Integer>> generate = solution.generate(numRows);
        System.out.println(generate);
    }
}
