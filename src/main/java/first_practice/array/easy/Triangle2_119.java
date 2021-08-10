package first_practice.array.easy;

import java.util.*;

/**
 * @author zyk
 * @description
 * @since 2021/8/11 6:22
 */
public class Triangle2_119 {

    /** 使用118题的解法肯定可行，但是题目最后希望可否使用空间复杂度O(rowIndex)的解法 */
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

    public static void main(String[] args) {
        Triangle2_119 solution = new Triangle2_119();
        List<Integer> resultList = solution.getRow(4);
        for (Integer a: resultList) {
            System.out.println(a);
        }
    }
}
