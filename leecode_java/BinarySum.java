/**
 * 67. 二进制求和
 * @author wsq
 * @date 2020/8/17
	 给你两个二进制字符串，返回它们的和（用二进制表示）。
	输入为 非空 字符串且只包含数字 1 和 0。
	
	示例 1:
	输入: a = "11", b = "1"
	输出: "100"

	示例 2:
	输入: a = "1010", b = "1011"
	输出: "10101"

	提示：
	每个字符串仅由字符 '0' 或 '1' 组成。
	1 <= a.length, b.length <= 10^4
	字符串如果不是 "0" ，就都不含前导零。
	
	链接：https://leetcode-cn.com/problems/add-binary
 */
package code.wsq.notsubmit;

public class BinarySum {
    public String addBinary(String a, String b) {
    	int len_a = a.length();
    	int len_b = b.length();
        StringBuilder sb = new StringBuilder(Math.max(len_a, len_b));
        int i = len_a - 1;
        int j = len_b - 1;
        int add = 0;
        while(i >= 0 || j >= 0 || add != 0) {
        	int x = i < 0 ? 0 : a.charAt(i) - '0';
        	int y = j < 0 ? 0 : b.charAt(j) - '0';
        	int product = x + y + add;
        	sb.append(product % 2);
        	add = product / 2;
        	i--;
        	j--;
        }
        sb.reverse();
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	 String a = "11", b = "1";
    	 BinarySum bs = new BinarySum();
    	 String ans = bs.addBinary(a, b);
    	 System.out.println(ans);
	}
}
