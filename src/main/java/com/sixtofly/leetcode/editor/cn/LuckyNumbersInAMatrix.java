//给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。 
//
// 幸运数是指矩阵中满足同时下列两个条件的元素： 
//
// 
// 在同一行的所有元素中最小 
// 在同一列的所有元素中最大 
// 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
//输出：[15]
//解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
//输出：[12]
//解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
// 
//
// 示例 3： 
//
// 输入：matrix = [[7,8],[1,2]]
//输出：[7]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= n, m <= 50 
// 1 <= matrix[i][j] <= 10^5 
// 矩阵中的所有元素都是不同的 
// 
// Related Topics 数组 矩阵 👍 71 👎 0


package com.sixtofly.leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LuckyNumbersInAMatrix{
    public static void main(String[] args) {
        Solution solution = new LuckyNumbersInAMatrix().new Solution();
        int[][] matrix = {{3,6},{7,1},{5,2},{4,8}};
        System.out.println(solution.luckyNumbers(matrix));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            // 找出当前行最小数
            int temp = Integer.MAX_VALUE;
            int col = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < temp) {
                    temp = matrix[i][j];
                    col = j;
                }
            }
            // 判断当前数的列是否最大的
            boolean max = true;
            for (int n = 0; n < matrix.length; n++) {
                if (n != i && matrix[i][col] < matrix[n][col]) {
                    max = false;
                    break;
                }
            }
            if (max) {
                res.add(matrix[i][col]);
            }
        }
        return new LinkedList<>(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



