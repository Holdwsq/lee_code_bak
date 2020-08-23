/**
 * 110. 平衡二叉树
 * @author wsq
 * @date 2020/8/17
	给定一个二叉树，判断它是否是高度平衡的二叉树。
	本题中，一棵高度平衡二叉树定义为：
	一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

	示例 1:
	给定二叉树 [3,9,20,null,null,15,7]
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	返回 true 。
	
	示例 2:
	给定二叉树 [1,2,2,3,3,null,null,4,4]
	
	       1
	      / \
	     2   2
	    / \
	   3   3
	  / \
	 4   4
	返回 false 。
	
	链接：https://leetcode-cn.com/problems/balanced-binary-tree
 */
package code.wsq.notsubmit;

class TreeNode{
	Integer val;
	TreeNode left;
	TreeNode right;
	public TreeNode(Integer val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}
	public TreeNode(Integer val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class BalancedBinaryTree {
	public boolean flag = true;
	/**
	 *	自底向上判断节点的左右两个子树的深度差绝对值是否大于1
	 * @param root
	 * @return
	 */
    public boolean isBalanced(TreeNode root) {
    	dfs(root);
		return flag;
    }
    /**
     *	递归实现
     * @param node
     * @return 当前节点的深度
     */
	private int dfs(TreeNode node) {
		// TODO Auto-generated method stub
		if(node == null) {
			return 0;
		}
		int left_depth = dfs(node.left);
		int right_depth = dfs(node.right);
		if(Math.abs(left_depth - right_depth) > 1 && flag) {
			flag = false;
		}
		return 1 + Math.max(left_depth, right_depth);
	}
}
