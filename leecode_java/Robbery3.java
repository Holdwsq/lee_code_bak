/**
 *	打家劫舍 III
 * @author wsq
 * @date 2020/8/5
	在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
	计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
	示例 1:
	
	输入: [3,2,3,null,3,null,1]
	
	     3
	    / \
	   2   3
	    \   \ 
	     3   1
	
	输出: 7 
	解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.

	链接：https://leetcode-cn.com/problems/house-robber-iii
 */
package code.wsq.notsubmit;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Robbery3 {
    public int rob(TreeNode root) {
		int r1 = root.val + dfs(root.left, false) + dfs(root.right, true);
		int r2 = dfs(root.left, true) + dfs(root.right, true);
		return Math.max(r1, r2);
    }
    public int dfs(TreeNode node, boolean canRob) {
    	if(node == null) {
    		return 0;
    	}
    	if(canRob) {
    		int rob1 = node.val + dfs(node.left, false) + dfs(node.right, false);
    		int rob2 = dfs(node.left, true) + dfs(node.right, true);
    		return Math.max(rob1, rob2);
    	}else {
    		return dfs(node.left, true) + dfs(node.right, true);
    	}
    }
    
    public static void main(String[] args) {
    	Integer[] nodes = {3,2,3,null,3,null,1};
		TreeNode root = buildTree(nodes);
		Robbery3 rb = new Robbery3();
		rb.rob(root);
	}
    
    public static TreeNode buildTree(Integer[] nodes) {
    	TreeNode root = null;
    	if(nodes.length <= 0) {
    		return root;
    	}
    	Queue<TreeNode> queue = new LinkedList<>();
    	int i = 0;
    	root = new TreeNode(nodes[i++]);
		queue.offer(root);
    	while(!queue.isEmpty()) {
    		TreeNode pre_node = queue.poll();
    		if(i == nodes.length) {
    			continue;
    		}
    		TreeNode n1 = createNode(i++, nodes);
    		if(n1 != null) {
    			queue.offer(n1);
    		}
    		TreeNode n2 = createNode(i++, nodes);
    		if(n2 != null) {
    			queue.offer(n2);
    		}
    		pre_node.left = n1;
    		pre_node.right = n2;
    	}
    	return root;
    }
    
    
    public static TreeNode createNode(int i, Integer[] nodes) {
    	if(nodes[i] == null) {
    		return null;
    	}else {
    		return new TreeNode(nodes[i]);
    	}
    }
}
