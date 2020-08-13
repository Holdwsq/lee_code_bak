/**
 * 43. 字符串相乘
 * @author wsq
 * @date 2020/8/13
	 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
	
	示例 1:
	输入: num1 = "2", num2 = "3"
	输出: "6"

	示例 2:
	输入: num1 = "123", num2 = "456"
	输出: "56088"

	说明：
	num1 和 num2 的长度小于110。
	num1 和 num2 只包含数字 0-9。
	num1 和 num2 均不以零开头，除非是数字 0 本身。
	不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

	链接：https://leetcode-cn.com/problems/multiply-strings
 */
package code.wsq.notsubmit;

public class StringMultiply {
	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		String ans = "0";
		int n = num1.length();
		int m = num2.length();
		
		for(int i = n-1; i >= 0; --i) {
			StringBuilder curr = new StringBuilder();
			for(int j = n-1; j > i; --j) {
				curr.append("0");
			}
			
			int add = 0;
			int x = num1.charAt(i) - '0';
			for(int j = m-1; j >= 0; --j) {
				int y = num2.charAt(j) - '0';
				int result = x * y + add;
				curr.append(result % 10);
				add = result / 10;
			}
			if(add != 0) {
				curr.append(add % 10);
			}
			ans = addStrings(ans, curr.reverse().toString());
		}
		return ans;
	}
	public String addStrings(String num1, String num2) {
		StringBuilder ans = new StringBuilder();
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int add = 0;
		while(i >= 0 || j >= 0 || add != 0) {
			int x = i >= 0 ? num1.charAt(i) - '0' : 0;
			int y = j >= 0 ? num2.charAt(j) - '0' : 0;
			int result = x + y + add;
			ans.append(result % 10);
			add = result / 10;
			i--;
			j--;
		}
		ans.reverse();
		return ans.toString();
	}
	
	public static void main(String[] args) {
		String num1 = "12";
		String num2 = "12";
		StringMultiply sm = new StringMultiply();
		String ans = sm.multiply(num1, num2);
		System.out.println(ans);
	}
}
