package an.sixtofly.annotation;

import java.lang.annotation.*;

/**
 * 父类可继承注解
 * @author xie yuan bing
 * @date 2021-12-01 15:46
 * @description
 */
@SuperInSuperAnnotation
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SuperAnnotation {
}
