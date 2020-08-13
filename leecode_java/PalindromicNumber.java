/**
 * @author wsq
 * @date 2020/7/23
 * 	回文数
	 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
	示例 1:
	
	输入: 121
	输出: true
	示例 2:
	
	输入: -121
	输出: false
	解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
	
	链接：https://leetcode-cn.com/problems/palindrome-number
 */
package code.wsq.notsubmit;

public class PalindromicNumber {
    public boolean isPalindrome(int x) {
    	if(x < 0 || (x % 10 == 0 && x != 0)) {
    		return false;
    	}
    	int revertedNumber = 0;
    	while(x > revertedNumber) {
    		revertedNumber = revertedNumber * 10 + x % 10;
    		x /= 10;
    	}
    	return x == revertedNumber || x == revertedNumber / 10;
    }
    
    public static void main(String[] args) {
    	PalindromicNumber pn = new PalindromicNumber();
    	int x = 121;
		boolean ans = pn.isPalindrome(x);
		System.out.println(ans);
	}
}
