/***
 * 66. 加一
 * @author wsq
 * @date 2020/8/15
	 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
	最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
	你可以假设除了整数 0 之外，这个整数不会以零开头。
	
	示例 1:
	输入: [1,2,3]
	输出: [1,2,4]
	解释: 输入数组表示数字 123。

	示例 2:
	输入: [4,3,2,1]
	输出: [4,3,2,2]
	解释: 输入数组表示数字 4321。
	
	链接：https://leetcode-cn.com/problems/plus-one
 */
package code.wsq.notsubmit;

public class PlusOne {
	/**
	 *	该题需要考虑到向上进位
	 *	如果到了digits数组第一位时还需要进位时，我们需要新建一个数组，
	 *	将进位数作为新数组的第一位，然后再将digits数组进行复制
	 * @param digits
	 * @return
	 */
    public int[] plusOne(int[] digits) {
    	int[] ans = digits;
    	int add = 1;
    	int i = digits.length - 1;
    	int product = 0;
    	while(add != 0 && i >= 0) {
    		product = digits[i] + add;
    		add = product / 10;
    		digits[i] = product % 10;
    		i--;
    	}
    	
    	if(add != 0) {
    		ans = new int[digits.length + 1];
    		ans[0] = add;
    		System.arraycopy(digits, 0, ans, 1, digits.length);
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	int[] digits = {9, 9};
    	PlusOne po = new PlusOne();
    	int[] ans = po.plusOne(digits);
    	for(int i = 0; i < ans.length; ++i) {
    		System.out.println("ans[" + i + "] = " + ans[i]);
    	}
	}
}
