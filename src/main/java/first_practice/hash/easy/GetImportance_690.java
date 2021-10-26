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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zyk
 * @description
 * @since 2021/10/27 6:49
 */
public class GetImportance_690 {

    public int getImportance(List<Employee> employees, int id) {
        Optional<Employee> leader = employees.stream().filter(x -> x.id == id).findFirst();
        List<Integer> subordinates = leader.get().subordinates;
        int importance = leader.get().importance;
        List<Employee> employe = employees.stream().filter(x -> subordinates.contains(x.id)).collect(Collectors.toList());
        for (Employee employee : employe){
            importance += employee.importance;
        }
        return importance;
    }

}



class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};