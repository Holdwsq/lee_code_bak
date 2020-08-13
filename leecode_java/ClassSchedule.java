/***
 * 207. 课程表
 * @author wsq
 * @date 2020/8/5
 	你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
	在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
	给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
	
	示例 1:
	输入: 2, [[1,0]] 
	输出: true
	解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。

	示例 2:
	输入: 2, [[1,0],[0,1]]
	输出: false
	解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
	
	链接：https://leetcode-cn.com/problems/course-schedule
 */
package code.wsq.notsubmit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ClassSchedule {
	boolean valid = true;
	List<List<Integer>> edges;
	int[] visited;
	/**
	 *	采用深度优先遍历的方法，纵向扩展节点，当出现环时，valid为false，即无法构成【拓扑排序】
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	edges = new ArrayList<List<Integer>>();
    	for(int i = 0; i < numCourses; ++i) {
    		edges.add(new ArrayList<Integer>());
    	}
    	
    	visited = new int[numCourses];
    	for(int[] info : prerequisites) {
    		edges.get(info[1]).add(info[0]);
    	}
    	for(int i = 0; i < numCourses && valid; ++i) {
    		if(visited[i] == 0) {
    			dfs(i);
    		}
    		
    	}
		return valid;
    }
    /**
     *	深度遍历迭代函数
     * @param u
     */
    public void dfs(int u) {
    	visited[u] = 1;
    	for(int e : edges.get(u)){
    		if(visited[e] == 0) {
    			dfs(e);
    			if(!valid) {
    				return;
    			}
    		}else if(visited[e] == 1) {
    			valid = false;
    			return;
    		}
    	}
    	visited[u] = 2;
    }
    /**
     *	采用广度优先的思想，依次遍历 入度 为0的节点，遍历到的节点根据 邻接表 检索出与该节点存在 弧 的所有节点，并
     *	使他们的入度减去1
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
    	int result = 0;
    	List<List<Integer>> bfs_edges = new ArrayList<>();
    	int[] indeg = new int[numCourses];
    	
    	for(int i = 0; i < numCourses; ++i) {
    		bfs_edges.add(new ArrayList<Integer>());
    	}
    	for(int[] info : prerequisites) {
    		bfs_edges.get(info[1]).add(info[0]);
    		++indeg[info[0]];
    	}
    	Queue<Integer> queue = new LinkedList<Integer>();
    	for(int i = 0; i < numCourses; ++i) {
    		if(indeg[i] == 0) {
    			queue.offer(i);
    		}
    	}
    	while(!queue.isEmpty()) {
    		result++;
    		int e = queue.poll();
    		for(int i : edges.get(e)) {
    			indeg[i]--;
    			if(indeg[i] == 0) {
    				queue.offer(i);
    			}
    		}
    		
    	}
    	return result == numCourses;
    }
}
