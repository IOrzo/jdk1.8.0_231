package an.sixtofly.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xie yuan bing
 * @date 2021-07-07 15:43
 */
public class House {

    private Television tv;

    public Television getTv() {
        return tv;
    }

    public void setTv(Television tv) {
        this.tv = tv;
    }

    @Override
    public String toString() {
        return "House{" +
                "tv=" + tv +
                '}';
    }

    public static void main(String[] args) throws IntrospectionException {
        House house = new House();
        BeanInfo beanInfo = Introspector.getBeanInfo(House.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            if ("tv".equals(pd.getName())) {
                try {
                    TelevisionEditor editor = (TelevisionEditor) pd.getPropertyEditorClass().newInstance();
                    editor.setAsText("1,2,3");
                    house.setTv((Television) editor.getValue());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(house);
    }

}
