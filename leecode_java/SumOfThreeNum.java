/**
 * @author wsq
 * @date 2020/7/31
 *	三数之和
 *	给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
	注意：答案中不可以包含重复的三元组。

	示例：
	给定数组 nums = [-1, 0, 1, 2, -1, -4]，
	满足要求的三元组集合为：
	[
	  [-1, 0, 1],
	  [-1, -1, 2]
	]
	链接：https://leetcode-cn.com/problems/3sum
 */
package code.wsq.notsubmit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThreeNum {
	/**
	 * 	三个数相加，控制一个数，就相当于 之前 做的两数之和， 第一个数为目标值target
	 * 	当然可以用 三层循环来做，但是时间复杂度是O(N^3)
	 * 	采用双指针的方法，是的第二层、三层循环放在一起，时间复杂度降低为O(N^2)
	 * @param nums
	 * @return
	 */
    public List<List<Integer>> threeSum(int[] nums) {
    	int n = nums.length;
    	Arrays.sort(nums);
    	
    	List<List<Integer>> ans = new ArrayList<>();
    	for(int first = 0; first < n; ++first) {
    		if(first > 0 && nums[first] == nums[first - 1]) {
    			continue;
    		}
    		int target = -nums[first];
    		int third = n -1;
    		for(int second = first + 1; second < n; ++second) {
    			if(second > first + 1 && nums[second] == nums[second - 1]) {
    				continue;
    			}
    			while(second < third && nums[second] + nums[third] > target) {
    				third--;
    			}
    			if(second == third) {
    				break;
    			}
    			if(nums[second] + nums[third] == target) {
    				List<Integer> tmp_list = new ArrayList<>();
    				tmp_list.add(nums[first]);
    				tmp_list.add(nums[second]);
    				tmp_list.add(nums[third]);
    				ans.add(tmp_list);
    			}
    		}
    	}
		return ans;
    }
    
    public static void main(String[] args) {
    	int[] nums = {-1, 0, 1, 2, -1, -4};
		SumOfThreeNum sot = new SumOfThreeNum();
		List<List<Integer>> ans = sot.threeSum(nums);
		System.out.println(ans);
		
	}
}
