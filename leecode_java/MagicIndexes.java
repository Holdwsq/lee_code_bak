/**
 * 	面试题 08.03. 魔术索引
 * @author wsq
 * @date 2020/7/31
 *	 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，
 *	编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
	
	示例1:
	 输入：nums = [0, 2, 3, 4, 5]
	 输出：0
	 说明: 0下标的元素为0
	
	示例2:
 	输入：nums = [1, 1, 1]
	 输出：1
	
	链接：https://leetcode-cn.com/problems/magic-index-lcci
 */
package code.wsq.notsubmit;

public class MagicIndexes {
	/**
	 * 	由于列表是有序的，所以可以采用“跳格”的方式寻找
	 * @param nums
	 * @return
	 */
    public int findMagicIndex(int[] nums) {
    	int i = 0;
    	while(i < nums.length) {
    		if(i == nums[i]) {
    			return i;
    		}else if(i < nums[i]) {
    			i = nums[i];
    		}else {
    			i++;
    		}
    	}
    	return -1;
    }
    public static void main(String[] args) {
    	int[] nums = {1, 1, 2, 3, 4};
		MagicIndexes mi = new MagicIndexes();
		int ans = mi.findMagicIndex(nums);
		System.out.println(ans);
	}
}