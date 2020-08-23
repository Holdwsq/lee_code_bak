/**
 * 58. 最后一个单词的长度
 * @author wsq
 * @date 2020/8/15
	 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
	如果不存在最后一个单词，请返回 0 。
	说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
	
	示例:
	输入: "Hello World"
	输出: 5
	
	链接：https://leetcode-cn.com/problems/length-of-last-word
 */
package code.wsq.notsubmit;

public class LengthOfLastWord {
	/**
	 *	寻找最后一个单词长度，通过trim直接将端的空格去掉
	 *	然后通过从右向左寻找第一个空格的位置(lastIndexOf)
	 *	因此我们的最终结果就是 (len - lastIndexOf - 1)
	 * @param s
	 * @return
	 */
    public int lengthOfLastWord(String s) {
    	s = s.trim();
    	int len = s.length();
    	int lastIndexOf = s.lastIndexOf(" ");
    	
    	if(lastIndexOf == -1) {
    		return len;
    	}
    	
    	return len - lastIndexOf - 1;
    }
    public static void main(String[] args) {
    	String s = " ";
    	LengthOfLastWord lo = new LengthOfLastWord();
    	int ans = lo.lengthOfLastWord(s);
    	System.out.println(ans);
	}
}
