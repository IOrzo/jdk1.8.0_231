package an.sixtofly.beans;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * @author xie yuan bing
 * @date 2021-07-07 15:49
 */
public class HouseBeanInfoDeprecate extends SimpleBeanInfo {

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        PropertyDescriptor pd = null;
        try {
            pd = new PropertyDescriptor("tv", House.class,"getTv", "setTv");
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        pd.setPropertyEditorClass(TelevisionEditor.class);
        return new PropertyDescriptor[]{pd};
    }
}
