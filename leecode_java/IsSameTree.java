/**
 * 100. 相同的树
 * @author wsq
 * @date 2020/8/20
	 给定两个二叉树，编写一个函数来检验它们是否相同。
	如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

	示例 1:
	输入:      	   1         1
	          / \       / \
	         2   3     2   3
	        [1,2,3],   [1,2,3]
	输出: true
	
	示例 2:
	输入:       	   1         1
	          / \       / \
	         2   1     1   2
	        [1,2,1],   [1,1,2]
	输出: false

	链接：https://leetcode-cn.com/problems/same-tree
 */
package code.wsq.notsubmit;

import java.util.LinkedList;
import java.util.Queue;

public class IsSameTree {
	/**
	 * BFS 采用广度优先遍历的方式
	 * 1.遍历过程中出现两节点“空值”情况不一致时，令ans为false，跳出循环
	 * 2.遍历过程中出现两个节点val不同时，领ans为false，跳出循环
	 * @param p
	 * @param q
	 * @return
	 */
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if((p != null && q == null) || (p == null && q != null)) {
    		return false;
    	}
    	if(p == null && q == null) {
    		return true;
    	}
        Queue<TreeNode> pQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> qQueue = new LinkedList<TreeNode>();
        
        boolean ans = true;
        pQueue.offer(p);
        qQueue.offer(q);
        
        while(!pQueue.isEmpty()) {
        	TreeNode pNode = pQueue.poll();
        	TreeNode qNode = qQueue.poll();
        	
        	if(pNode.val != qNode.val) {
        		ans = false;
        		break;
        	}
        	if(pNode.left != null && qNode.left != null) {
        		pQueue.offer(pNode.left);
        		qQueue.offer(qNode.left);
        	}else if(pNode.left == null && qNode.left == null) {
        		
        	}else {
        		ans = false;
        		break;
        	}
        	if(pNode.right != null && qNode.right != null) {
        		pQueue.offer(pNode.right);
        		qQueue.offer(qNode.right);
        	}else if(pNode.right == null && qNode.right == null){
        		
        	}else {
        		ans = false;
        		break;
        	}	
        }
        return ans;
    }
}
