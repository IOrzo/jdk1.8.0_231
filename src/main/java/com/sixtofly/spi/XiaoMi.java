package com.sixtofly.spi;

/**
 * @author xie yuan bing
 * @date 2021-06-24 17:11
 */
public class XiaoMi implements MobilePhone {
    @Override
    public void call(String msg) {
        System.out.println("使用 XiaoMi 打电话:" + msg);
    }
}
