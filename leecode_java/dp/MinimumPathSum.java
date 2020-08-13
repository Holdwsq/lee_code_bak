/**
 * @author wsq
 * @date 2020/7/23
 * 	最小路径和
 * 	给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
	说明：每次只能向下或者向右移动一步。
	示例:
	输入:
	[
	  [1,3,1],
	  [1,5,1],
	  [4,2,1]
	]
	输出: 7
	解释: 因为路径 1→3→1→1→1 的总和最小。
	链接：https://leetcode-cn.com/problems/minimum-path-sum
 */
package code.wsq.notsubmit.dp;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
    	int ans = 0;
    	if(grid.length <= 0) {
    		return ans;
    	}
    	int m = grid.length;
    	int n = grid[0].length;
    	int[][] dp = new int[m][n];
    	dp[0][0] = grid[0][0];
    	
    	for(int i = 1; i < n; ++i) {
    		dp[0][i] = dp[0][i-1] + grid[0][i];
    	}
    	
    	for(int i = 1; i < m; ++i) {
    		dp[i][0] = dp[i-1][0] + grid[i][0];
    	}
    	
    	for(int i = 1; i < m; ++i) {
    		for(int j = 1; j < n; ++j) {
    			dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
    		}
    	}
    	ans = dp[m-1][n-1];
    	return ans;
    }
    
    public static void main(String[] args) {
    	MinimumPathSum mp = new MinimumPathSum();
    	
    	int[][] nums = {
    					{1,3,1},
    			  		{1,5,1},
    			  		{4,2,1}
    			  		};
		int ans = mp.minPathSum(nums);
		System.out.println(ans);
	}
}
