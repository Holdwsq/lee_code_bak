"""
给定一个无向图graph，当这个图为二分图时返回true。
如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。

示例 1:
输入: [[1,3], [0,2], [1,3], [0,2]]
输出: true
解释:
无向图如下:
0----1
|    |
|    |
3----2
我们可以将节点分成两组: {0, 2} 和 {1, 3}。

链接：https://leetcode-cn.com/problems/is-graph-bipartite
"""
"""
题目分析：

"""
from typing import List
import collections


class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)
        UNCOLORED, RED, GREEN = 0, 1, 2
        # 用于存储节点的染色情况
        color = [0] * n
        valid = True

        def dfs(node: int, c: int):
            """
            深度优先遍历的方式涂色
            :param node: 节点
            :param c: 将要涂的颜色
            :return:
            """
            nonlocal valid
            color[node] = c
            c_next = RED if c == GREEN else GREEN
            # 遍历其连接的节点
            for neighbor in graph[node]:
                if color[neighbor] == UNCOLORED:
                    # 深度优先遍历 与 递归 更配哦
                    dfs(neighbor, c_next)
                    if not valid:
                        return
                elif color[neighbor] != c_next:
                    valid = False
                    return

        # 确保每个节点都要被染色
        for i in range(n):
            if color[i] == UNCOLORED:
                dfs(i, RED)
                if not valid:
                    break

        return valid

    def isBipartite2(self, graph: List[List[int]]) -> bool:
        """
        广度优先遍历 实现涂色
        :param graph:
        :return:
        """
        n = len(graph)
        UNCOlORED, RED, GREEN = 0, 1, 2
        color = [UNCOlORED] * n

        for i in range(n):
            if color[i] == UNCOlORED:
                # 双端队列
                q = collections.deque([i])
                color[i] = RED
                while q:
                    node = q.popleft()
                    c_next = RED if color[node] == GREEN else GREEN
                    for neighbor in graph[node]:
                        if color[neighbor] == UNCOlORED:
                            q.append(neighbor)
                            color[neighbor] = c_next
                        elif color[neighbor] != c_next:
                            return False
        return True


if __name__ == "__main__":
    graph = [[1, 3], [0, 2], [1, 3], [0, 2]]
    s = Solution()
    flag = s.isBipartite(graph)
    print(flag)
