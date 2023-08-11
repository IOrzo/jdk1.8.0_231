package com.sixtofly.serializable;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author xie yuan bing
 * @date 2022-01-20 15:49
 */
public class CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 在序列化过程中，虚拟机会试图调用对象类里的 writeObject 和 readObject 方法，进行用户自定义的序列化和反序列化，
     * 如果没有这样的方法，则默认调用是 ObjectOutputStream 的 defaultWriteObject 方法
     * 以及 ObjectInputStream 的 defaultReadObject 方法。用户自定义的 writeObject 和 readObject 方法
     * 可以允许用户控制序列化的过程，比如可以在序列化的过程中动态改变序列化的数值。
     * 基于这个原理，可以在实际应用中得到使用，用于敏感字段的加密工作。
     */
    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }
}
