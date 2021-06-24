package an.sixtofly.spi;

import java.util.ServiceLoader;

/**
 * SPI全称Service Provider Interface，是Java提供的一套用来被第三方实现或者扩展的接口，它可以用来启用框架扩展和替换组件。
 * SPI的作用就是为这些被扩展的API寻找服务实现。
 * SPI 是调用方来指定接口规范，提供给外部来实现，调用方在调用时则选择自己需要的外部实现。从使用人员来说，SPI 被框架扩展人员使用
 * @author xie yuan bing
 * @date 2021-06-24 17:12
 */
public class SpiTest {

    /**
     * 调用方需先定义接口信息
     * 实现方: 需要在resources目录下新建META-INF/services目录，并且在这个目录下新建一个与上述接口的全限定名一致的文件，在这个文件中写入接口的实现类的全限定名
     * @param args
     */
    public static void main(String[] args) {
        ServiceLoader<MobilePhone> mobilePhones = ServiceLoader.load(MobilePhone.class);
        for (MobilePhone mobilePhone : mobilePhones) {
            mobilePhone.call("hello 呀");
        }
    }
}
