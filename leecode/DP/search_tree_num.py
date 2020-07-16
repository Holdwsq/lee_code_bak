"""
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

链接：https://leetcode-cn.com/problems/unique-binary-search-trees。
"""
"""
分析要点：
1. 二叉搜索树的特点：对于树中的每个节点X，它的左子树中所有关键字值小于X的关键字值，而它的右子树中所有关键字值大于X的关键字值。
2. 给定1...n序列中，遍历每一个数字i，将该数字作为根，小于i的数字作为作左子树，大于i的数字作为右子树，因此可以将原问题分解为规模更小的问
   题取解决，可以理解为是动态规划问题。
   F(i,n)=G(i−1)⋅G(n−i)
   G(n) = F(i, n) 的累加， i 从 1 到 n
"""


class Solution:
    def numTrees(self, n) -> int:
        """
        求解不同结构的二叉搜索树的个数
        :param n: int
        :return:
        """
        G = [0] * (n + 1)
        G[0] = 1
        G[1] = 1

        for i in range(2, n+1):
            for j in range(1, i + 1):
                G[i] += G[j - 1] * G[i - j]
        return G[n]


if __name__ == "__main__":
    s = Solution()
    num = s.numTrees(3)
    print(num)