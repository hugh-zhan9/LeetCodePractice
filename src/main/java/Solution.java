import first_practice.array.easy.RemoveDuplicates_26;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int removeDuplicates(int[] nums) {
        String[] strArray= new String[]{"Tom", "Bob", "Jane"};
        List<String> strList= Arrays.asList(strArray);

        List<int[]> ints = Arrays.asList(nums);
        for (int i =0; i<ints.size(); i++){
            if (ints.contains(nums[i])){
                ints.remove(nums[i]);
            }
        }
        return ints.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = new int[] {1,1,2};
        int ints = solution.removeDuplicates(test);
        System.out.println(ints);
    }
}