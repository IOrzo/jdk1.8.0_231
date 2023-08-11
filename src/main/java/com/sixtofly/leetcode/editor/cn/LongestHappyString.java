////如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。 
////
//// 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s： 
////
//// 
//// s 是一个尽可能长的快乐字符串。 
//// s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。 
//// s 中只含有 'a'、'b' 、'c' 三种字母。 
//// 
////
//// 如果不存在这样的字符串 s ，请返回一个空字符串 ""。 
////
//// 
////
//// 示例 1： 
////
//// 输入：a = 1, b = 1, c = 7
////输出："ccaccbcc"
////解释："ccbccacc" 也是一种正确答案。
//// 
////
//// 示例 2： 
////
//// 输入：a = 2, b = 2, c = 1
////输出："aabbc"
//// 
////
//// 示例 3： 
////
//// 输入：a = 7, b = 1, c = 0
////输出："aabaa"
////解释：这是该测试用例的唯一正确答案。 
////
//// 
////
//// 提示： 
////
//// 
//// 0 <= a, b, c <= 100 
//// a + b + c > 0 
//// 
//// Related Topics 贪心 字符串 堆（优先队列） 👍 125 👎 0
//


package com.sixtofly.leetcode.editor.cn;

public class LongestHappyString{
    public static void main(String[] args) {
        Solution solution = new LongestHappyString().new Solution();
        System.out.println(solution.longestDiverseString(7,1,0));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        char choose = '0';
        while (a > 0 || b > 0 || c > 0) {
            if (sb.length() == 0) {
                if (a > b) {
                    if (a > c) {
                        choose = 'a';
                    } else {
                        choose = 'c';
                    }
                } else {
                    if (b > c) {
                        choose = 'b';
                    } else {
                        choose = 'c';
                    }
                }
            } else {
                if (sb.length() < 2) {
                    char pre = sb.charAt(sb.length() - 1);
                    if (pre == 'a' && a > 0) choose = 'a';
                    if (pre == 'b' && b > 0) choose = 'b';
                    if (pre == 'c' && c > 0) choose = 'c';
                } else {
                    char pre = sb.charAt(sb.length() - 1);
                    char ppre = sb.charAt(sb.length() - 2);
                    // 选择最多的一个插入
                    if (pre == ppre) {
                        if (pre == 'a') {
                            if (b > c) {
                                choose = 'b';
                            } else {
                                choose = 'c';
                            }
                        }
                        if (pre == 'b') {
                            if (a > c) {
                                choose = 'a';
                            } else {
                                choose = 'c';
                            }
                        }
                        if (pre == 'c') {
                            if (a > b) {
                                choose = 'a';
                            } else {
                                choose = 'b';
                            }
                        }
                    } else {
                        // 选择数量最大的插入
                        if (a > b) {
                            if (a > c) {
                                choose = 'a';
                            } else {
                                choose = 'c';
                            }
                        } else {
                            if (b > c) {
                                choose = 'b';
                            } else {
                                choose = 'c';
                            }
                        }
                    }
                    // 结束条件
                    if (choose == 'a' && a == 0) break;
                    if (choose == 'b' && b == 0) break;
                    if (choose == 'c' && c == 0) break;
                }
            }
            // 选择值减一
            if (choose == 'a') a--;
            if (choose == 'b') b--;
            if (choose == 'c') c--;
            sb.append(choose);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



