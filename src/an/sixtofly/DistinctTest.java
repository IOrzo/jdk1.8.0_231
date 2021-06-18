package an.sixtofly;

/**
 * 通过位计算去重
 * @author xie yuan bing
 * @date 2021-06-15 16:49
 */
public class DistinctTest {

    public static final byte[] operate = new byte[]{
            (byte) 0B00000001,
            (byte) 0B00000010,
            (byte) 0B00000100,
            (byte) 0B00001000,
            (byte) 0B00010000,
            (byte) 0B00100000,
            (byte) 0B01000000,
            (byte) 0B10000000,
    };

    // 大小100个数
    public byte[] bits = null;

    {
        int num = 100 / 8;
        int remain = 100 % 8;
        if (remain > 0) {
            num++;
        }
        bits = new byte[num];
    }

    public void put(int num) {
        int index = num / 8;
        int remain = num % 8;
        bits[index] = (byte) (bits[index] | operate[remain]);
    }

    public boolean test(int num) {
        int index = num / 8;
        int remain = num % 8;
        byte c = (byte) (bits[index] & operate[remain]);
         if (c != 0) {
            return true;
        }
        return false;
    }




    public static void main(String[] args) {
        DistinctTest distinctTest = new DistinctTest();
        distinctTest.put(0);
        System.out.println(distinctTest.test(0));

        distinctTest.put(8);
        System.out.println(distinctTest.test(8));

        distinctTest.put(10);
        System.out.println(distinctTest.test(10));

        distinctTest.put(68);
        System.out.println(distinctTest.test(68));

        distinctTest.put(100);
        System.out.println(distinctTest.test(100));

        System.out.println(distinctTest.test(6));
        System.out.println(distinctTest.test(99));
        System.out.println(distinctTest.test(101));




    }
}
