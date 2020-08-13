/**
 * @author wsq
 * @date 2020/7/30
 * 	整数拆分
	给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
	
	示例 1:
	输入: 2
	输出: 1
	解释: 2 = 1 + 1, 1 × 1 = 1。
	
	示例 2:
	输入: 10
	输出: 36
	解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
	
	链接：https://leetcode-cn.com/problems/integer-break
 */
package code.wsq.notsubmit.dp;

public class IntegerBreak {
	/**
	 * 	动态规划，整数n分解整数乘积最大，整体有两种情况分解为：n = i + (n-i)
	 * 	1. 乘积为 i * (n-i)
	 * 	2. 乘积为 i * dp(n - i) 
	 * 	dp[n] = max{max(j * (n-i), i * dp(n-i)}， i 取值范围：[0, n)
	 * @param n
	 * @return
	 */
    public int integerBreak(int n) {
    	int[] dp = new int[n + 1];
    	dp[0] = dp[1] = 0;
    	
    	for(int i = 2; i <= n; ++i) {
    		for(int j = 0; j < i; ++j) {
    			dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
    		}
    	}
    	return dp[n];
    }
    /**
     * 	数学方法
     * @param n
     * @return
     */
    public int integerBreak2(int n) {
    	if(n <= 3) {
    		return n - 1;
    	}
    	int quotient = n / 3;
    	int remainder = n % 3;
    	
    	if(remainder == 0) {
    		return (int)Math.pow(3, quotient);
    	}else if(remainder == 1) {
    		return (int)Math.pow(3, quotient - 1) * 4;
    	}else {
    		return (int)Math.pow(3, quotient) * 2;
    	}
    }
    
    public static void main(String[] args) {
		int n = 10;
		IntegerBreak ib = new IntegerBreak();
		int ans = ib.integerBreak2(n);
		System.out.println(ans);
	}
}
