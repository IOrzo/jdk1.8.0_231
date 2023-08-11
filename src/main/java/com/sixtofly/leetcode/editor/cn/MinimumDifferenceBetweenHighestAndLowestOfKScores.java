//给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。 
//
// 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。 
//
// 返回可能的 最小差值 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [90], k = 1
//输出：0
//解释：选出 1 名学生的分数，仅有 1 种方法：
//- [90] 最高分和最低分之间的差值是 90 - 90 = 0
//可能的最小差值是 0
// 
//
// 示例 2： 
//
// 输入：nums = [9,4,1,7], k = 2
//输出：2
//解释：选出 2 名学生的分数，有 6 种方法：
//- [9,4,1,7] 最高分和最低分之间的差值是 9 - 4 = 5
//- [9,4,1,7] 最高分和最低分之间的差值是 9 - 1 = 8
//- [9,4,1,7] 最高分和最低分之间的差值是 9 - 7 = 2
//- [9,4,1,7] 最高分和最低分之间的差值是 4 - 1 = 3
//- [9,4,1,7] 最高分和最低分之间的差值是 7 - 4 = 3
//- [9,4,1,7] 最高分和最低分之间的差值是 7 - 1 = 6
//可能的最小差值是 2 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 排序 滑动窗口 👍 37 👎 0


package com.sixtofly.leetcode.editor.cn;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores{
    public static void main(String[] args) {
        Solution solution = new MinimumDifferenceBetweenHighestAndLowestOfKScores().new Solution();
        int[] nums = new int[]{41900,69441,94407,37498,20299,10856,36221,2231,54526,79072,84309,76765,92282,13401,44698,17586,98455,47895,98889,65298,32271,23801,83153,12186,7453,79460,67209,54576,87785,47738,40750,31265,77990,93502,50364,75098,11712,80013,24193,35209,56300,85735,3590,24858,6780,50086,87549,7413,90444,12284,44970,39274,81201,43353,75808,14508,17389,10313,90055,43102,18659,20802,70315,48843,12273,78876,36638,17051,20478};
//        int[] nums = new int[]{9,4,1,7};
        System.out.println(solution.minimumDifference(nums, 5));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        int[] result = new int[nums.length];
        System.arraycopy(nums, 0, result, 0, nums.length);
        quickSort(result, 0, result.length - 1);
        int p = 1;
        int res = result[k - 1] - result[0];
        while (p + k <= nums.length) {
            int cop = result[p + k - 1] - result[p];
            if (cop < res) {
                res = cop;
            }
            p++;
        }
        return res;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = nums[start];
            int lp = start;
            int rp = end;

            while (lp < rp) {
                while (rp > lp) {
                    if (nums[rp] > pivot) {
                        rp--;
                    } else {
                        nums[lp++] = nums[rp];
                        break;
                    }
                }

                while (lp < rp) {
                    if (nums[lp] < pivot) {
                        lp++;
                    } else {
                        nums[rp--] = nums[lp];
                        break;
                    }
                }
            }
            nums[lp] = pivot;
            quickSort(nums, start, lp - 1);
            quickSort(nums, lp + 1, end);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



