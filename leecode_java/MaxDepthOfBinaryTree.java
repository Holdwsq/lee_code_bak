/**
 * 	二叉树的最大深度
 * @author wsq
 * @date 2020/7/28
 	给定一个二叉树，找出其最大深度。
	二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
	说明: 叶子节点是指没有子节点的节点。
	
	示例：
	给定二叉树 [3,9,20,null,null,15,7]，
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	返回它的最大深度 3 。
	
	链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 */
package code.wsq.notsubmit;

import java.util.LinkedList;
import java.util.Queue;

//class TreeNode {
//	Integer val;
//	TreeNode left;     
//    TreeNode right;
//    TreeNode(Integer x) { val = x; }
//}

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	int ans = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		return ans;
    }
    /**
     * 	再来个BFS优先
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	
    	int ans = 0; 
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	
    	while(!queue.isEmpty()) {
    		// 该处与一般的BFS不同，这里需要把上一层的节点全部取走
    		int size = queue.size();
    		while(size > 0) {
        		TreeNode node = queue.poll();
        		if(node.left != null) {
        			queue.offer(node.left);
        		}
        		if(node.right != null) {
        			queue.offer(node.right);
        		}
        		size--;
    		}
    		ans++;
    		
    	}
    	return ans;
    }
    
}
