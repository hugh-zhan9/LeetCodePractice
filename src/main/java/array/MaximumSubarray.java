package array;

/**
 * @author zyk
 * @description
 * @since 2021/6/4 16:52
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int res = Integer.MIN_VALUE;
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                int sum =0;
                for (int i=left; i<right; i++){
                    sum += nums[i];
                }
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maximumSubarray.maxSubArray(nums);
        System.out.println(result);
    }
}
