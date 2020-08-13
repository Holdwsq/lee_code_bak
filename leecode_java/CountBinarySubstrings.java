/**
 * 696. 计数二进制子串
 * @author wsq
 * @date 2020/8/10
	给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
	重复出现的子串要计算它们出现的次数。

	示例 1 :
	输入: "00110011"
	输出: 6
	解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
	请注意，一些重复出现的子串要计算它们出现的次数。
	另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
	
	示例 2 :
	输入: "10101"
	输出: 4
	解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
	
	链接：https://leetcode-cn.com/problems/count-binary-substrings
 */
package code.wsq.notsubmit;

public class CountBinarySubstrings {
	/***
	 * 	count_pre：存储前一个数字的重复次数
	 * 	count_next：存储后一个数字的重复次数
	 * 	取两者的最小值，就是两者之间满足条件的二进制字串
	 * 	如：00 1 ——> count_pre = 0, count_next = 2(0重复了2次，两者最小值为0)
	 * 	   00 11 0 ——> count_pre = 2, count_next = 2(1重复了2次，两者最小值为2(0011可分为：0011，01))
	 * 	   ...	
	 * @param s
	 * @return
	 */
    public int countBinarySubstrings(String s) {
    	if(s == null || s.length() <= 1) {
    		return 0;
    	}
    	int ans = 0;
    	int len = s.length();
    	int count_pre = 0;
    	int count_next = 1;
    	for(int i = 1; i < len; ++i) {
    		if(s.charAt(i) == s.charAt(i-1)) {
    			count_next++;
    		}else {
    			ans += Math.min(count_pre, count_next);
    			count_pre = count_next;
    			count_next = 1;
    		}
    	}
    	ans += Math.min(count_pre, count_next);
    	return ans;
    }
    
    public static void main(String[] args) {
    	String s = "00110011";
    	CountBinarySubstrings cbs = new CountBinarySubstrings();
    	int ans = cbs.countBinarySubstrings(s);
    	System.out.println(ans);
	}
}
