/**
 * @author wsq
 * @date 2020/7/23
 *	 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
	不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
	
	示例 1:
	
	给定数组 nums = [1,1,2], 
	
	函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 	你不需要考虑数组中超出新长度后面的元素。
	
	链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 */
package code.wsq.notsubmit;

public class DeletesDuplicates {
    public int removeDuplicates(int[] nums) {
    	if(nums.length <= 1) {
    		return nums.length; 
    	}
    	int insert_pos = 0;
    	int find_pos = 0;
    	while(find_pos < nums.length -1) {
    		if(nums[find_pos] == nums[find_pos + 1]) {
    			find_pos++;
    		}else {
    			nums[insert_pos++] = nums[find_pos++];    			
    		}
    	}
    	nums[insert_pos++] = nums[find_pos];
    	return insert_pos;
    }
    
    public static void main(String[] args) {
    	int[] nums = {};
    	DeletesDuplicates dd = new DeletesDuplicates();
    	int ans = dd.removeDuplicates(nums);
    	System.out.println(ans);
    	for(int i = 0; i < ans; ++i) {
    		System.out.println(nums[i]);
    	}
    			
	}
}
