/**
 * 101. 对称二叉树
 * @author wsq
 * @date 2020/8/20
	给定一个二叉树，检查它是否是镜像对称的。
	
	例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
	
	    1
	   / \
	  2   2
	   \   \
	   3    3

	链接：https://leetcode-cn.com/problems/symmetric-tree
 */
package code.wsq.notsubmit;

import java.util.Deque;
import java.util.LinkedList;

public class SymmetricBinaryTree {
	/**
	 *	迭代方法
	 *	创建两个堆，分别表示左右两个子树的展开节点
	 *	判断两个子树是否对称，关键点就是在于，对称节点的子节点之间的对应关系
	 * @param root
	 * @return
	 */
    public boolean isSymmetric(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
        boolean ans = true;
        Deque<TreeNode> leftStack = new LinkedList<TreeNode>();
        Deque<TreeNode> rightStack = new LinkedList<TreeNode>();
        leftStack.push(root.left);
        rightStack.push(root.right);
        while(!leftStack.isEmpty() && 
        		! rightStack.isEmpty()) {
        	TreeNode leftNode = leftStack.pop();
        	TreeNode rightNode = rightStack.pop();
        	if(leftNode != null && rightNode != null) {
        		if(leftNode.val != rightNode.val) {
        			ans = false;
        			break;
        		}
        		leftStack.push(leftNode.left);
        		leftStack.push(leftNode.right);
        		rightStack.push(rightNode.right);
        		rightStack.push(rightNode.left);
        	}else if(leftNode == null && rightNode == null) {
        		
        	}else {
        		ans = false;
        		break;
        	}
        }
        if(!leftStack.isEmpty() || !rightStack.isEmpty()) {
        	ans = false;
        }
        return ans;
    }
    /**
     *	采用递归的方式
     *	1.将一个树的对称可划为每个子树、节点的对称
     *	2.判断树的对称与判断对应的子树和节点的方式一致
     *	3.当两个节点不相等时或者同时为null时，结束递归
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
    	return checkSymmetric(root.left, root.right);
    }
    
    public boolean checkSymmetric(TreeNode p, TreeNode q) {
    	if(p == null && q == null) {
    		return true;
    	}
    	if(p == null || q == null) {
    		return false;
    	}
    	
    	if(p.val != q.val) {
    		return false;
    	}
    	
    	return checkSymmetric(p.left, q.right) && checkSymmetric(p.right, q.left);
    }
}
