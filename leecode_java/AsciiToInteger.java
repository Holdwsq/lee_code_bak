/**
 * @author wsq
 * @date 2020/7/22
 *	 字符串转换整数 (atoi)
 *	请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *	具体规则参加LeeCode网站：
 *	示例 1:
	
	输入: "42"
	输出: 42
	示例 2:
	
	输入: "   -42"
	输出: -42
	解释: 第一个非空白字符为 '-', 它是一个负号。
	     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
	
	链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 */
package code.wsq;

public class AsciiToInteger {
    public int myAtoi(String str) {
    	String tmp_str = str.trim();
    	int len = tmp_str.length();
        if(len <= 0){
            return 0;
        }
    	int ans = 0;
    	char ch = tmp_str.charAt(0);
    	boolean negative_flag = false;
    	int parseInt;
		if(Character.isDigit(ch)) {
//			parseInt = Integer.parseInt(String.valueOf(ch));
			parseInt = ch - '0';
    		ans = ans * 10 + parseInt;
    	}else if(ch == '-') {
    		negative_flag = true;
    	}else if(ch == '+') {
    		
    	}else {
    		return 0;
    	}

    	for(int i = 1; i < len; ++i) {
    		ch = tmp_str.charAt(i);
    		if(!Character.isDigit(ch)) {
    			break;
    		}
    		
    		parseInt = ch - '0';;
    		
    		if(negative_flag) {    			
    			if(-ans < Integer.MIN_VALUE/10 || (-ans == Integer.MIN_VALUE/10 && parseInt > 8)) {
    				return Integer.MIN_VALUE;
    			}
    		}else {    			
    			if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && parseInt > 7)) {
    				return Integer.MAX_VALUE;
    			}
    		}
    		ans = ans * 10 + parseInt;
    	}
    	return negative_flag ? -ans : ans;
    }
    public static void main(String[] args) {
		String str = "-91283472332";
		AsciiToInteger atoi = new AsciiToInteger();
		int ans = atoi.myAtoi(str);
		System.out.println(ans);
	}
}
