package first_practice.hash.easy;

/**
 * 给定一个保存员工信息的数据结构，它包含了员工 唯一的 id，重要度和直系下属的 id。
 * 比如，员工1 是员工2 的领导，员工2 是员工3 的领导。他们相应的重要度为15, 10, 5。
 * 那么员工1 的数据结构是[1, 15, [2]]，员工2 的数据结构是[2, 10, [3]]，员工3 的数据结构是[3, 5, []]。
 * 注意虽然员工3 也是员工1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工1 的数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 *
 *  
 *
 * 示例：
 * 输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出：11
 * 解释：
 * 员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
 *  
 *
 * 提示：
 * 一个员工最多有一个直系领导，但是可以有多个直系下属
 * 员工数量不超过 2000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/employee-importance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

/**
 * @author zyk
 * @description
 * @since 2021/10/27 6:49
 */
public class GetImportance_690 {

    /** 深度优先 */
    private Map<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee:employees){
            map.put(employee.id, employee);
        }
        return dfs(id);
    }

    public int dfs(int id){
        Employee employee = map.get(id);
        int importance = employee.importance;
        List<Integer> subordinates = employee.subordinates;
        for (Integer i:subordinates){
            importance += dfs(i);
        }
        return importance;
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了12.71%的用户
     */
    
    
    /** 广度优先 */
    public int getImportance2(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int total = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            // poll 移除并返问队列头部的元素. 如果队列为空, 则返回null
            int curId = queue.poll();
            Employee employee = map.get(curId);
            total += employee.importance;
            List<Integer> subordinates = employee.subordinates;

            for (int subId : subordinates) {
                // offer 添加一个元素并返回true. 如果队列已满, 则返回false
                queue.offer(subId);
            }

        }
        return total;
    }

    /**
     * 没写出来
     */

}



class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
