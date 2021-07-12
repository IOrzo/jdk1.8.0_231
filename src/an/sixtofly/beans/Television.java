package an.sixtofly.beans;

/**
 * @author xie yuan bing
 * @date 2021-07-07 15:44
 */
public class Television {

    private int length;

    private int with;

    private int height;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWith() {
        return with;
    }

    public void setWith(int with) {
        this.with = with;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Television{" +
                "length=" + length +
                ", with=" + with +
                ", height=" + height +
                '}';
    }
}
