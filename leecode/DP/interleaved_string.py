"""
交错字符串

给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。

示例 1:

输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出: true
示例 2:

输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
输出: false

链接：https://leetcode-cn.com/problems/interleaving-string

问题分析：

"""


class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        target_n = len(s3)
        len_s1 = len(s1)
        len_s2 = len(s2)
        if len_s1 + len_s2 != target_n:
            return False
        # 路径状态矩阵
        f = [[False] * (len_s2 + 1) for i in range(len_s1 + 1)]

        f[0][0] = True

        for i in range(len_s1 + 1):
            for j in range(len_s2 + 1):
                p = i + j - 1
                if i > 0:
                    f[i][j] = f[i][j] or (f[i - 1][j] and s1[i - 1] == s3[p])
                if j > 0:
                    f[i][j] = f[i][j] or (f[i][j - 1] and s2[j - 1] == s3[p])
        return f[len_s1][len_s2]


if __name__ == "__main__":
    s1 = "aabcc"
    s2 = "dbbca"
    s3 = "aadbbcbcac"
    s = Solution()
    ans = s.isInterleave(s1, s2, s3)
    print(ans)
