class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] a = null;
        for(int i=0; i<nums.length ;i++){
            for (int j=nums.length-1; j>i;j--){
                if (target == (nums[i]+nums[j])){
                    a = new int[]{i, j};
                    break;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = new int[] {3,3};
        int target = 6;
        int[] ints = solution.twoSum(test, target);
        System.out.println(""+ints[0] + ints[1]);
    }
}