package code.wsq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
public class Longest_substring_without_repeat {
	public int lengthOfLongestSubstring(String s) {
// 验证s是否为空串		
		if(s.length()<=0){
            return 0;
        }
		int maxNum = 0;
		Set<Character> tmp_s = new HashSet<Character>();
		for(int pos=0; pos<s.length(); pos++) {
			int tmp_p = pos;
			int tmp_n = 0;
			tmp_s.clear();
			while(true) {
				if(tmp_p < s.length() && !tmp_s.contains(s.charAt(tmp_p))) {
					tmp_s.add(s.charAt(tmp_p));
					tmp_n++;
					tmp_p++;
				}else {
					maxNum = Math.max(maxNum, tmp_n);
					break;
				}
			}
			
		}
		return maxNum;
	}
	public static void main(String[] args) {
		Longest_substring_without_repeat s = new Longest_substring_without_repeat();
		int n = s.lengthOfLongestSubstring("abcabcbb");
		System.out.println(n);
	}
}
