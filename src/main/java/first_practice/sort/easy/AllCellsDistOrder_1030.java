package first_practice.sort.easy;

/**
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，
 * 其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 *  
 *
 * 示例 1：
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 *
 * 示例 2：
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 *
 * 示例 3：
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 *  
 *
 * 提示：
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zyk
 * @description
 * @since 2021/9/17 9:40
 */
public class AllCellsDistOrder_1030 {

    /**
     * 直接排序
     * 时间复杂度：O(rows×cols×log(rows×cols))，存储所有点时间复杂度 O(rows×cols)，排序时间复杂度 O(rows×cols×log(rows×cols))。
     * 空间复杂度：O(log(rows×cols))，即为排序需要使用的栈空间，不考虑返回值的空间占用。
     */
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] result = new int[rows * cols][];
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                result[i*cols+j] = new int[]{i,j};
            }
        }
        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs(o1[0]-rCenter)+Math.abs(o1[1]-cCenter)-Math.abs(o2[0]-rCenter)-Math.abs(o2[1]-cCenter);
            }
        });
        return result;
    }

    /**
     * 执行用时：13 ms, 在所有 Java 提交中击败了53.23%的用户
     * 内存消耗：40.4 MB, 在所有 Java 提交中击败了70.64%的用户
     */


    /**
     * 桶排序，很妙
     *
     * 时间复杂度：O(rows×cols)，存储所有点时间复杂度 O(rows×cols)，桶排序时间复杂度 O(rows×cols)。
     * 空间复杂度：O(rows×cols)，需要存储矩阵内所有点。
     */
    public int[][] allCellsDistOrder2(int rows, int cols, int rCenter, int cCenter) {
        int maxDist = Math.max(rCenter, rows - 1 - rCenter) + Math.max(cCenter, cols - 1 - cCenter);
        List<List<int[]>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<>());
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int d = dist(i, j, rCenter, cCenter);
                bucket.get(d).add(new int[]{i, j});
            }
        }
        int[][] ret = new int[rows * cols][];
        int index = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] it : bucket.get(i)) {
                ret[index++] = it;
            }
        }
        return ret;
    }

    public int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了92.26%的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了96.77%的用户
     */


    /** 几何法，在超时的边缘疯狂试探 */
    public int[][] allCellsDistOrder3(int rows, int cols, int rCenter, int cCenter) {
        int[][] ret = new int[rows * cols][];
        int count = 1;
        int val = 1;
        ret[0] = new int[]{rCenter,cCenter};
        while (count < rows*cols){
            for (int i=0; i<rows; i++){
                for (int j=0; j<cols; j++){
                    if ( Math.abs(rCenter-i)+Math.abs(cCenter-j) == val){
                        ret[count++] = new int[]{i,j};
                    }
                }
            }
            val++;
        }
        return ret;
    }

    /**
     * 执行用时：22 ms, 在所有 Java 提交中击败了9.03%的用户
     * 内存消耗：40.4 MB, 在所有 Java 提交中击败了66.77%的用户
     */


    /**
     * 题解中的几何法
     *
     * 时间复杂度：O((*rows*+*cols*)²)
     * 我们需要遍历矩阵内所有点，同时也会遍历部分超过矩阵部分的点。
     * 在最坏情况下，给定的单元格位于矩阵的一个角，例如 (0,0)，此时最大的曼哈顿距离为 rows+cols−2，需要遍历的点数为 2(rows+cols-2)(rows+cols-1)+1，
     * 因此时间复杂度为 O((*rows*+*cols*)²)
     *
     * 空间复杂度：O(1)，不考虑返回值的空间占用。
     */
    int[] dr = {1, 1, -1, -1};
    int[] dc = {1, -1, -1, 1};
    public int[][] allCellsDistOrder4(int rows, int cols, int rCenter, int cCenter) {
        int maxDist = Math.max(rCenter, rows - 1 - rCenter) + Math.max(cCenter, cols - 1 - cCenter);
        int[][] ret = new int[rows * cols][];
        int row = rCenter, col = cCenter;
        int index = 0;
        ret[index++] = new int[]{row, col};
        for (int dist = 1; dist <= maxDist; dist++) {
            row--;
            for (int i = 0; i < 4; i++) {
                while ((i % 2 == 0 && row != rCenter) || (i % 2 != 0 && col != cCenter)) {
                    if (row >= 0 && row < rows && col >= 0 && col < cols) {
                        ret[index++] = new int[]{row, col};
                    }
                    row += dr[i];
                    col += dc[i];
                }
            }
        }
        return ret;
    }

    /**
     *
     * 最后一个解法很有趣呢，本质是朴素的广度优先搜索。但是由于没有任何状态需要保存、所以存在空间O(1)的简化形式，只不过枚举起来需要很熟练呢。
     * Java的同学如果对Stream API有兴趣，也可以借此题熟悉一下Stream的魔力。下面两种枚举的方向都和题解方法1中完全一致：
     *
     * 传统的数学思路（赋权）：
     * Stream<int[]> s1 = IntStream.range(0, R * C).mapToObj(rc -> new int[]{rc / C, rc % C});
     *
     * Stream式的思路：
     * Stream<int[]> s2 = IntStream.range(0, R).boxed().flatMap(r -> IntStream.range(0, C).mapToObj(c -> new int[]{r, c}));
     *
     * 看起来前者简单一些，但是并不是任何问题都有机会通过数学进行简化的。最后加个sort就很容易得到答案。
     *
     * public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
     *     return IntStream.range(0, R).boxed()
     *         .flatMap(r -> IntStream.range(0, C).mapToObj(c -> new int[]{r, c}))
     *         .sorted((pos1, pos2) -> dist(pos1[0], pos1[1], r0, c0) - dist(pos2[0], pos2[1], r0, c0))
     *         .toArray(int[][]::new);
     * }
     *
     * private int dist(int r, int c, int r0, int c0) {
     *     return Math.abs(r - r0) + Math.abs(c - c0);
     * }
     *
     */

}
