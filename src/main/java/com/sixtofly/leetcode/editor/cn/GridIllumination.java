//在大小为 n x n 的网格 grid 上，每个单元格都有一盏灯，最初灯都处于 关闭 状态。 
//
// 给你一个由灯的位置组成的二维数组 lamps ，其中 lamps[i] = [rowi, coli] 表示 打开 位于 grid[rowi][coli] 
//的灯。即便同一盏灯可能在 lamps 中多次列出，不会影响这盏灯处于 打开 状态。 
//
// 当一盏灯处于打开状态，它将会照亮 自身所在单元格 以及同一 行 、同一 列 和两条 对角线 上的 所有其他单元格 。 
//
// 另给你一个二维数组 queries ，其中 queries[j] = [rowj, colj] 。对于第 j 个查询，如果单元格 [rowj, colj]
// 是被照亮的，则查询结果为 1 ，否则为 0 。在第 j 次查询之后 [按照查询的顺序] ，关闭 位于单元格 grid[rowj][colj] 上及相邻 8 个
//方向上（与单元格 grid[rowi][coli] 共享角或边）的任何灯。 
//
// 返回一个整数数组 ans 作为答案， ans[j] 应等于第 j 次查询 queries[j] 的结果，1 表示照亮，0 表示未照亮。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
//输出：[1,0]
//解释：最初所有灯都是关闭的。在执行查询之前，打开位于 [0, 0] 和 [4, 4] 的灯。第 0 次查询检查 grid[1][1] 是否被照亮（蓝色方框）
//。该单元格被照亮，所以 ans[0] = 1 。然后，关闭红色方框中的所有灯。
//
//第 1 次查询检查 grid[1][0] 是否被照亮（蓝色方框）。该单元格没有被照亮，所以 ans[1] = 0 。然后，关闭红色矩形中的所有灯。
//
// 
//
// 示例 2： 
//
// 
//输入：n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
//输出：[1,1]
// 
//
// 示例 3： 
//
// 
//输入：n = 5, lamps = [[0,0],[0,4]], queries = [[0,4],[0,1],[1,4]]
//输出：[1,1,0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 0 <= lamps.length <= 20000 
// 0 <= queries.length <= 20000 
// lamps[i].length == 2 
// 0 <= rowi, coli < n 
// queries[j].length == 2 
// 0 <= rowj, colj < n 
// 
// Related Topics 数组 哈希表 👍 49 👎 0


package com.sixtofly.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class GridIllumination{
    public static void main(String[] args) {
        Solution solution = new GridIllumination().new Solution();
        int[][] lamps = new int[][] {{0,0},{4,4}};
        int[][] queries = new int[][] {{1,1},{1,0}};
        // {{2,5},{4,2},{0,3},{0,5},{1,4},{4,2},{3,3},{1,0}}
        // {{4,3},{3,1},{5,3},{0,5},{4,4},{3,3}}
//        int[][] lamps = new int[][] {{2,5},{4,2},{0,3},{0,5},{1,4},{4,2},{3,3},{1,0}};
//        int[][] queries = new int[][] {{4,3},{3,1},{5,3},{0,5},{4,4},{3,3}};
        System.out.println(Arrays.toString(solution.gridIllumination(5, lamps, queries)));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int[] result = new int[queries.length];

        // 保存某行的灯数量
        HashMap<Integer, Integer> row = new HashMap<>();
        // 保存某列的灯数量
        HashMap<Integer, Integer> col = new HashMap<>();
        // 保存对角线灯的数量
        HashMap<Integer, Integer> diagonal = new HashMap<>();
        // 保存反对角线灯的数量
        HashMap<Integer, Integer> nDiagonal = new HashMap<>();
        // 保存灯的坐标点信息
        HashSet<Long> points = new HashSet<>();

        // 初始化灯信息
        for (int i = 0; i < lamps.length; i++) {
            int x = lamps[i][0];
            int y = lamps[i][1];
            // 可能会存在重复灯
            if (!points.add(hash(x, y))) {
                continue;
            }
            row.put(x, row.getOrDefault(x, 0) + 1);
            col.put(y, col.getOrDefault(y, 0) + 1);
            diagonal.put(y - x, diagonal.getOrDefault(y - x, 0) + 1);
            nDiagonal.put(x + y, nDiagonal.getOrDefault(x + y, 0) + 1);
        }

        // 查询
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            // 查询
            if (row.getOrDefault(x, 0) > 0) {
                result[i] = 1;
            }
            if (col.getOrDefault(y, 0) > 0) {
                result[i] = 1;
            }
            if (diagonal.getOrDefault(y - x, 0) > 0) {
                result[i] = 1;

            }
            if (nDiagonal.getOrDefault(x + y, 0) > 0) {
                result[i] = 1;
            }

            // 关闭当前灯
            close(row, col, diagonal, nDiagonal, points, x, y);

            // 关闭周围灯
            // 上
            close(row, col, diagonal, nDiagonal, points, x - 1, y);
            // 上左
            close(row, col, diagonal, nDiagonal, points, x - 1, y - 1);
            // 上右
            close(row, col, diagonal, nDiagonal, points, x - 1, y + 1);
            // 下
            close(row, col, diagonal, nDiagonal, points, x + 1, y);
            // 下左
            close(row, col, diagonal, nDiagonal, points, x + 1, y - 1);
            // 下右
            close(row, col, diagonal, nDiagonal, points, x + 1, y + 1);
            // 左
            close(row, col, diagonal, nDiagonal, points, x, y - 1);
            // 右
            close(row, col, diagonal, nDiagonal, points, x, y + 1);
        }
        return result;
    }

    private void close(HashMap<Integer, Integer> row, HashMap<Integer, Integer> col, HashMap<Integer, Integer> diagonal, HashMap<Integer, Integer> nDiagonal, HashSet<Long> points, int x, int y) {
        if (points.contains(hash(x, y))) {
            row.put(x, row.get(x) - 1);
            col.put(y, col.get(y) - 1);
            diagonal.put(y - x, diagonal.get(y - x) - 1);
            nDiagonal.put(x + y, nDiagonal.get(x + y) - 1);
            points.remove(hash(x, y));
        }
    }

    public long hash(int x, int y) {
        return (long) x + ((long) y << 32);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}



