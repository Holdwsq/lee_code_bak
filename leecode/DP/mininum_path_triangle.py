"""
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
"""
"""
问题分析：这是一个计算全局最小路径的问题，需要考虑全局，因此，这道题考虑的是动态规划的知识
最基础的思想：
https://leetcode-cn.com/problems/triangle/solution/san-jiao-xing-zui-xiao-lu-jing-he-by-leetcode-solu/
"""
from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        # 初始化状态转移代价矩阵
        # 这里所需的额外空间是 n*n，思考怎么去优化
        n = len(triangle)
        f = [[0] * n for _ in range(n)]
        # f[0][0]该点的路径代价就是三角形的顶点
        f[0][0] = triangle[0][0]

        # 计算其他元素的代价值
        for i in range(1, n):
            f[i][0] = f[i - 1][0] + triangle[i][0]
            for j in range(1, i):
                f[i][j] = min(f[i - 1][j - 1], f[i - 1][j]) + triangle[i][j]
            f[i][i] = f[i - 1][i - 1] + triangle[i][i]

        return min(f[n - 1])

    def minimumTotal2(self, triangle: List[List[int]]) -> int:
        # 初始化状态转移代价矩阵
        n = len(triangle)
        # 由于代价计算，后一个状态只有只与紧挨着的前一个状态有关，将状态转移的代价矩阵维度降为 2*n
        f = [[0] * n for _ in range(2)]

        f[0][0] = triangle[0][0]
        for i in range(1, n):
            curr, prev = i % 2, 1 - i % 2
            f[curr][0] = f[prev][0] + triangle[i][0]
            for j in range(1, i):
                f[curr][j] = min(f[prev][j - 1], f[prev][j]) + triangle[i][j]
            f[curr][i] = f[prev][i - 1] + triangle[i][i]
        return min(f[(n - 1) % 2])


if __name__ == '__main__':
    triangle = [
        [2],
        [3, 4],
        [6, 5, 7],
        [4, 1, 8, 3]
    ]
    s = Solution()
    mininum_path = s.minimumTotal2(triangle)
    print(mininum_path)
