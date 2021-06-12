package an.sixtofly;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * @author xie yuan bing
 * @date 2021-04-13 16:44
 */
public class AnyTest {

    public static int[][] array = {
            {1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}
    };

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str1 = "str";
        String str2 = "ing";

        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //在堆上创建的新的对象
        String str5 = "string";//常量池中的对象
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false






    }

    public static boolean Find(int target, int [][] array) {
        int col = array[0].length - 1;

        for (int n = 0; n < array.length; n++) {

            for (; col > 0; col--) {
                // 如果大于目标数, 比较下一行
                if (array[n][col] < target) {
                    break;
                }

                if (array[n][col] == target) {
                    return true;
                }

                // 如果小于目标数, 比较左边列
            }
        }

        "".replace(" ", "%2d");

        return false;
    }
}
