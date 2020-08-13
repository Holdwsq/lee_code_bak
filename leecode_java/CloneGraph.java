/***
 * 133. 克隆图
 * @author wsq
 * @date 2020/8/12
	  给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
	图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
	
	class Node {
	    public int val;
	    public List<Node> neighbors;
	}
	
	测试用例格式：
	简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
	邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
	给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
	
	示例 1：
	输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
	输出：[[2,4],[1,3],[2,4],[1,3]]
	解释：
	图中有 4 个节点。
	节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
	节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
	节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
	节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
	
	示例 2：
	输入：adjList = [[]]
	输出：[[]]
	解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
	
	示例 3：

	输入：adjList = []
	输出：[]
	解释：这个图是空的，它不含任何节点。
	链接：https://leetcode-cn.com/problems/clone-graph/
 */
package code.wsq.notsubmit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    } 
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
	/**
	 *	采用bfs的搜索思想
	 *	使用哈希表存储已经生成的新节点
	 *	1. 当哈希表中已存在的，直接添加到新的邻居列表中
	 *	2. 当哈希表不存在对应的新节点，需生成新节点，将新节点放入队列中，最后将新节点加入新的邻居列表
	 * @param node
	 * @return
	 */
    public Node cloneGraph(Node node) {
    	if(node == null) {
    		return null;
    	}
        Map<Integer, Node> node_map = new HashMap<Integer, Node>();
        Queue<Node> node_queue = new LinkedList<Node>();
        Node new_node = new Node(node.val, (ArrayList)node.neighbors);
		node_queue.offer(new_node);
        node_map.put(node.val, new_node);
        
        
        while(!node_queue.isEmpty()) {
        	Node h = node_queue.poll();
        	if(h.neighbors != null && !h.neighbors.isEmpty()) {
        		List<Node> new_neighbors = new ArrayList<>(h.neighbors.size());
        		for(Node n : h.neighbors) {
        			Node tmp_node = node_map.get(n.val);
        			if(tmp_node == null) {
        				tmp_node = new Node(n.val, (ArrayList)n.neighbors);
        				node_queue.offer(tmp_node);
        				node_map.put(n.val, tmp_node);
        			}
        			new_neighbors.add(tmp_node);
        		}
        		h.neighbors = new_neighbors;
        	}
        }
        return new_node;
    }
    
    public static void main(String[] args) {
    	CloneGraph cg = new CloneGraph();
    	Node root1 = new Node(1);
    	Node root2 = new Node(2);
    	Node root3 = new Node(3);
    	Node root4 = new Node(4);
    	
    	root1.neighbors = new ArrayList<Node>() {
    		{
    			add(root2);
    			add(root4);
    		}
    	};
    	
    	root2.neighbors = new ArrayList<Node>() {
    		{
    			add(root1);
    			add(root3);
    		}
    	};
    	
    	root3.neighbors = new ArrayList<Node>() {
    		{
    			add(root2);
    			add(root4);
    		}
    	};
    	
    	root4.neighbors = new ArrayList<Node>() {
    		{
    			add(root1);
    			add(root3);
    		}
    	};
    	
    	Node node = cg.cloneGraph(root1);
    	System.out.println(node.val);
	}
}
