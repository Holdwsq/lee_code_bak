/**
 * 
 *	 最长公共前缀
 *  @author wsq
 *  @date 2020/7/28
 * 	 编写一个函数来查找字符串数组中的最长公共前缀。
	如果不存在公共前缀，返回空字符串 ""。
	
	示例 1:
	输入: ["flower","flow","flight"]
	输出: "fl"

	示例 2:
	输入: ["dog","racecar","car"]
	输出: ""
	解释: 输入不存在公共前缀。
	
	说明:
	所有输入只包含小写字母 a-z 。

	链接：https://leetcode-cn.com/problems/longest-common-prefix
 */
package code.wsq.notsubmit;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0) {
    		return "";
    	}
    	int arr_len = strs.length;
    	String ans = strs[0];
    	int len = ans.length();
    	boolean flag = true;
    	for(int i = 0; i < len; ++i) {
    		for(int j = 1; j < arr_len; ++j) {
    			if(i >= strs[j].length() || strs[j].charAt(i) != ans.charAt(i)) {
    				flag = false;
    				break;
    			}
    		}
    		if(!flag) {
    			ans = ans.substring(0, i);
    			break;
    		}
    	}
    	return ans;
    }
    
    public static void main(String[] args) {
    	String[] strs = {"dog","racecar","car"};
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String ans = lcp.longestCommonPrefix(strs);
		System.out.println(ans);
	}
}
