/***
 * 20. 有效的括号
 * @author wsq
 * @date 2020/8/11
	 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
	有效字符串需满足：
	左括号必须用相同类型的右括号闭合。
	左括号必须以正确的顺序闭合。
	注意空字符串可被认为是有效字符串。
	
	示例 1:
	输入: "()"
	输出: true
	
	示例 2:
	输入: "()[]{}"
	输出: true
	
	示例 3:
	输入: "([)]"
	输出: false
	
	链接：https://leetcode-cn.com/problems/valid-parentheses
 */
package code.wsq.notsubmit;

import java.util.Deque;
import java.util.LinkedList;

public class VerifyBrackets {
	/**
	 * 	采用栈的方式，左括号直接进，右括号则需要与栈顶比较
	 * 	推荐使用Deque模拟栈结构
	 * @param s
	 * @return
	 */
    public boolean isValid(String s) {
    	boolean ans = false;
    	if(s.length() % 2 != 0) {
    		return ans;
    	}
    	Deque<Character> stack = new LinkedList<Character>();
    	for(int i = 0; i < s.length(); ++i) {
    		char tmp_c = s.charAt(i);
			if(tmp_c == '{' || tmp_c == '(' || tmp_c =='[') {
				stack.push(tmp_c);
			}else if(stack.size() > 0){
				Character pop = stack.pop();
				int gap = tmp_c - pop;
				if(gap != 1 && gap != 2) {
					return ans;
				}
			}else {
				return ans;
			}
    	}
    	if(stack.size() == 0) {
    		ans = true;
    	}
    	return ans;
    }
    public static void main(String[] args) {
    	String s = "()";
    	VerifyBrackets vb = new VerifyBrackets();
    	boolean ans = vb.isValid(s);
    	System.out.println(ans);
	}
}
