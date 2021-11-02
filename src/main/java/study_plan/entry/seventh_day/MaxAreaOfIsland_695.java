package study_plan.entry.seventh_day;

/**
 * 给你一个大小为 mxn 的二进制矩阵 grid。
 * 岛屿是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直的四个方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 *  
 *
 * 示例 1：
 * ![](https://assets.leetcode.com/uploads/2021/05/01/maxarea1-grid.jpg)
 * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 *
 * 示例 2：
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 *  
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] 为 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/11/2 6:47
 */
public class MaxAreaOfIsland_695 {

    public int maxAreaOfIsland(int[][] grid) {
        int res =0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                res = Math.max(res, dfs(i,j,grid));
            }
        }
        return res;
    }


    public int dfs (int i, int j, int[][] grid){
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != 1){
            return 0;
        }else {
            grid[i][j] = 2;
            int ans = 1;
            ans += dfs(i - 1, j, grid);
            ans += dfs(i + 1, j, grid);
            ans += dfs(i, j - 1, grid);
            ans += dfs(i, j + 1, grid);
            return ans;
        }
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.99%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了51.84%的用户
     */
    
}
