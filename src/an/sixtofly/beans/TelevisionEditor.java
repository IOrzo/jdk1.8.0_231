package an.sixtofly.beans;

import java.beans.PropertyEditorSupport;

/**
 * @author xie yuan bing
 * @date 2021-07-07 15:52
 */
public class TelevisionEditor extends PropertyEditorSupport {

    /**
     * 将字面值转换为属性类型对象
     * @param text
     * @throws IllegalArgumentException
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(text == null || text.indexOf(",") == -1){
            throw new IllegalArgumentException("设置的字符串格式不正确");
        }
        String[] infos = text.split(",");
        Television tv = new Television();
        tv.setLength(Integer.parseInt(infos[0]));
        tv.setWith(Integer.parseInt(infos[1]));
        tv.setHeight(Integer.parseInt(infos[2]));

        // 调用父类的setValue()方法设置转换后的属性对象
        setValue(tv);
    }
}
