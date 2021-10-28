package an.sixtofly.lang;

import java.util.concurrent.TimeUnit;

/**
 * HashCode 值测试
 * @author xie yuan bing
 * @date 2021-10-22 09:27
 */
public class HashCodeValueTest {

    public static void main(String[] args) {
//        ideaGenerate();
        defaultHashCode();
    }

    /**
     * idea 自动生产的
     */
    public static void ideaGenerate() {
        // 改变对象值, 会影响 hashCode 值不
        HashCodeValueEntity entity = new HashCodeValueEntity("user", "123");
        System.out.println("idea: " + entity.hashCode());
        entity.setUsername("modified");
        System.out.println("idea: " + entity.hashCode());
    }

    /**
     * 默认方法
     */
    public static void defaultHashCode() {
        PlainObject plain = new PlainObject("user", "123");
        System.out.println("default:" + plain.hashCode());
        plain.setUsername("modified");
        System.out.println("default:" + plain.hashCode());

        // 创建新线程测试
        Thread thread = new Thread(() -> {
            System.out.println("new thread:" + plain.hashCode());
            plain.setUsername("modified again");
            System.out.println("new thread:" + plain.hashCode());
        });
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class PlainObject {
        private String username;

        private String password;


        public PlainObject(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


    static class HashCodeValueEntity {

        private String username;

        private String password;



        public HashCodeValueEntity(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            HashCodeValueEntity that = (HashCodeValueEntity) o;

            if (!username.equals(that.username)) return false;
            return password.equals(that.password);
        }

        @Override
        public int hashCode() {
            int result = username.hashCode();
            result = 31 * result + password.hashCode();
            return result;
        }

    }

}


