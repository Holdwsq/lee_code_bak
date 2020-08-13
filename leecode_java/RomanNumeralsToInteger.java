/**
 * @author wsq
 * @date 2020/7/26
 * 	 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
	
	字符          数值
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	
	这个特殊的规则只适用于以下六种情况：

	I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
	X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
	C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
	
	链接：https://leetcode-cn.com/problems/roman-to-integer
 */
/**
 * 	问题分析：
 *	1.  小的罗马数字放在大的罗马数字左边，两者就可以结合，结合的结果是 sum - num(小的Roman) + num(大的Roman)
 *	2.  遇见类似key-value形式数据时，数据量少的情况下，不建议使用HashMap的方式，这样反而会增加执行时间
 */
package code.wsq.notsubmit;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsToInteger {
    public int romanToInt(String s) {
    	
    	int ans = 0;
    	int len = s.length();
    	int pre = getRomanInt(s.charAt(0));
		for(int i = 1; i < len; ++i) {
    		int num = getRomanInt(s.charAt(i));
    		if(pre < num) {
    			ans -= pre;
    		}else {
    			ans += pre;
    		}
    		pre = num;
    	}
		ans += pre;
		return ans;
    }
    
    public int getRomanInt(char c) {
    	switch(c) {
    		case 'I': return 1;
    		case 'V': return 5;
    		case 'X': return 10;
    		case 'L': return 50;
    		case 'C': return 100;
    		case 'D': return 500;
    		case 'M': return 1000;
    		default: return 0;
    	}
    }
    
    public static void main(String[] args) {
    	String s = "LVIII";
    	RomanNumeralsToInteger rtoi = new RomanNumeralsToInteger();
    	int ans = rtoi.romanToInt(s);
    	System.out.println(ans);
		
	}
}
