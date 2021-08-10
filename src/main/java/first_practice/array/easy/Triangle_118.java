package first_practice.array.easy;

import java.util.ArrayList;
import java.util.List;

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
