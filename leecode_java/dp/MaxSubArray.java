/***
 * 53. 最大子序和
 * @author wsq
 * @date 2020/8/14
	 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

	示例:
	输入: [-2,1,-3,4,-1,2,1,-5,4]
	输出: 6
	解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
	
	链接：https://leetcode-cn.com/problems/maximum-subarray
 */
package code.wsq.notsubmit.dp;

import java.util.Arrays;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
    	int[] f = new int[nums.length];
    	f[0] = nums[0];
    	for(int i = 1; i < nums.length; i++) {
    		f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
    	}
    	Arrays.sort(f);
    	return f[f.length - 1];
    }
    public static void main(String[] args) {
    	int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		MaxSubArray msa = new MaxSubArray();
		int ans = msa.maxSubArray(nums);
		System.out.println(ans);
	}
}
