/*
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

链接：https://leetcode-cn.com/problems/longest-palindromic-substring
问题分析：
1. 暴力解法，求解每一个字串是否是回文，并求得最大的
2. 动态规划：设状态dp[j][i]表示索引j到索引i的子串是否是回文串，
	转移方程：
		a. dp[j][i] = true, j = i
		b. dp[j][i] = s[i] == s[j], i - j < 1
		c. dp[j][i] = s[i] == s[j] && dp[j+1][i-1], i - j >= 2
 */
package code.wsq;

public class LongestPalindrome {
	/*
	 * 暴力解法，从第一个字符开始，判断每一个字串是否是回文，时间复杂度O(N^2)
	 */
    public String longestPalindrome(String s) {
    	int len = s.length();
    	if(len <= 0) {
    		return "";
    	}
    	int start = 0;
    	int maxLen = 1;
    	for(int i = 0; i < len; ++i) {
    		for(int j = i + 1; j < len; ++j) {
    			int tmp_i = i;
    			int tmp_j = j;
    			while(tmp_i < tmp_j && s.charAt(tmp_i) == s.charAt(tmp_j)) {
    				tmp_i++;
    				tmp_j--;
    			}
    			if(tmp_i >= tmp_j && j - i + 1 > maxLen) {
    				maxLen = j - i + 1;
    				start = i;
    			}
    		}
    		
    	}
		return s.substring(start, start + maxLen);
    }
    public String longestPalindrome2(String s) {
    	int len = s.length();
    	if(len <= 0) {
    		return "";
    	}
    	int start = 0;
    	int maxLen = 1;
//    	f[j][i] 表示从索引j到索引i是否是回文
    	boolean[][] f = new boolean[len][len];
    	for(int i = 0; i < len; ++i) {
    		for(int j = 0; j <= i; ++j) {
    			if(i - j < 2) {
    				f[j][i] = s.charAt(j) == s.charAt(i);
    			}
    			if(i - j >= 2) {
    				f[j][i] = s.charAt(i) == s.charAt(j) && f[j + 1][i - 1];
    			}
    			if(f[j][i] && i - j + 1 > maxLen) {
    				start = j;
    				maxLen = i - j + 1;
    			}
    		}
    		
    	}
    	
    	
    	return s.substring(start, start + maxLen);
    }
    /*
     *	中心扩散方法
     */
    public String longestPalindrome3(String s) {
    	if(s == null || s.length() < 1) return "";
    	
    	int start = 0;
    	int maxLen = 1;
    	
    	for(int i = 0; i < s.length(); ++i) {
    		int len1 = expandAroundCenter(s, i, i);
    		int len2 = expandAroundCenter(s, i, i + 1);
    		int len = Math.max(len1, len2);
    		
    		if(len > maxLen) {
    			start = i - (len - 1)/2;
    			maxLen = len;
    		}
    		
    	}
    	return s.substring(start, start + maxLen);
    }
    private int expandAroundCenter(String s, int left, int right) {
    	int tmp_l = left, tmp_r = right;
    	while(tmp_l >= 0 && tmp_r < s.length() && s.charAt(tmp_l) == s.charAt(tmp_r)) {
    		tmp_l--;
    		tmp_r++;
    	}
    	return tmp_r - tmp_l - 1;
    }
    /**
     * 	马拉车算法未实现，等回顾的时候在学习一下
     * @param args
     */
    public String longestPalindrome4(String s) {
    	return s;
    }
    
    
    public static void main(String[] args) {
    	String s = "babad";
    	LongestPalindrome l = new LongestPalindrome();
    	String ans = l.longestPalindrome3(s);
    	System.out.println(ans);
	}
}
