//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。 
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 的值为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 131 👎 0


package com.sixtofly.leetcode.editor.cn;

public class NumberOfEnclaves{
    public static void main(String[] args) {
        Solution solution = new NumberOfEnclaves().new Solution();
        int[][] grid = new int[][] {
//                {0,0,0,0},
//                {1,0,1,0},
//                {0,1,1,0},
//                {0,0,0,0},
                {0},{1},{1},{0},{0}
//                {0,0,0,1,1,1,0,1,0,0},{1,1,0,0,0,1,0,1,1,1},{0,0,0,1,1,1,0,1,0,0},{0,1,1,0,0,0,1,0,1,0},{0,1,1,1,1,1,0,0,1,0},{0,0,1,0,1,1,1,1,0,1},{0,1,1,0,0,0,1,1,1,1},{0,0,1,0,0,1,0,1,0,1},{1,0,1,0,1,1,0,0,0,0},{0,0,0,0,1,1,0,0,0,1}
        };
        System.out.println(solution.numEnclaves(grid));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numEnclaves(int[][] grid) {
        // 存储能达到边界的值
        int[][] achieve = new int[grid.length][grid[0].length];
        int row = grid.length - 1;
        int col = grid[0].length - 1;

        // 初始化最两边列
        for (int i = 0; i < grid.length; i++) {
            traverse(grid, i, 0, achieve);
            traverse(grid, i, col, achieve);
        }

        // 初始化上下中间两列
        for (int i = 1; i < grid[0].length - 1; i++) {
            traverse(grid, 0, i, achieve);
            traverse(grid, row, i, achieve);
        }

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (achieve[i][j] == 1) {
                        continue;
                    }
                    if (achieve[i][j] == 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public void traverse(int[][] grid, int x, int y, int[][] achieve) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == 0 || achieve[x][y] == 1) {
            return;
        }
        achieve[x][y] = 1;
        traverse(grid, x, y - 1, achieve);
        traverse(grid, x + 1, y, achieve);
        traverse(grid, x, y + 1, achieve);
        traverse(grid, x - 1, y, achieve);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



