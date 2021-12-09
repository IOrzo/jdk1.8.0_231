package an.sixtofly.annotation;


import java.lang.annotation.Annotation;

/**
 * AnnotatedElement 接口方法测试
 * @author xie yuan bing
 * @date 2021-12-01 14:57
 */
public class AnnotatedElementTest {


    public static void main(String[] args) {
        // false
        System.out.println("isAnnotationPresent：" + SubAnnotationConfig.class.isAnnotationPresent(EnableAspectJAutoProxy.class));

        // null
        System.out.println("getAnnotation：" + print(SubAnnotationConfig.class.getAnnotation(SuperAnnotation.class)));

        // getAnnotations：interface an.sixtofly.annotation.SuperAnnotation,interface an.sixtofly.annotation.Indexed,
        // 获取作用在该类上的注解，包括父类中可继承的注解
        System.out.println("getAnnotations：" + print(SubAnnotationConfig.class.getAnnotations()));

        // getAnnotationsByType：interface an.sixtofly.annotation.SuperAnnotation
        System.out.println("getAnnotationsByType：" + print(SubAnnotationConfig.class.getAnnotationsByType(SuperAnnotation.class)));

        // null
        System.out.println("getDeclaredAnnotation：" + print(SubAnnotationConfig.class.getDeclaredAnnotation(SuperAnnotation.class)));

        // null
        System.out.println("getDeclaredAnnotationsByType：" + print(SubAnnotationConfig.class.getDeclaredAnnotationsByType(SuperAnnotation.class)));

        // getDeclaredAnnotations：interface an.sixtofly.annotation.Indexed,
        // 获取直接声明在该类的注解，不包括父类的注解
        System.out.println("getDeclaredAnnotations：" + print(SubAnnotationConfig.class.getDeclaredAnnotations()));
    }


    static String print(Annotation annotation) {
        if (annotation == null) {
            return null;
        }
        return annotation.annotationType().toString();
    }

    static String print(Annotation[] annotations) {
        if (annotations == null || annotations.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Annotation annotation : annotations) {
            sb.append(annotation.annotationType().toString());
            sb.append(",");
        }
        return sb.toString();
    }
}
