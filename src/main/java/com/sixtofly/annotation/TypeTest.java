package com.sixtofly.annotation;

/**
 * [基础篇：深入解析JAVA泛型和Type类型体系](https://www.shuzhiduo.com/A/l1dy7M0VJe/)
 *
 * Type下面又有四个子接口类ParameterizedType、TypeVariable、GenericArrayType、WildcardType
 * List<E>表示泛型，E是TypeVariable类型，List<String>则是ParameterizedType(参数化类型)，List<String>里的String称为实际参数类型
 * 具体化泛型中的类型时，可以使用 ? extends 或 ? super来表示继承关系；如List<\? extends Data\>，而里面的 ? 称为通配符类型
 * GenericArrayType 表示一种元素类型是ParameterizedType（参数化类型）或者TypeVariable（类型变量）的数组类型，如T[] 或者 List[]
 *
 * 上界限定通配符 < ? extends E>
 * 下界限定通配符 < ? super E>
 *
 * 注解是JDK1.5才出现了的，为了表示被注解的类型的，加入AnnotatedElement类型，字面意思就是被注解的元素。
 * JDK1.8又有了AnnotatedType将Type和被注解元素的概念关联起来。
 *
 * AnnotatedType也有四个子接口，和Type的四个子接口一一对应，
 * 如：ParameterizedType类型被注解则被编译器解析成AnnotatedParameterizedType: @AnTest("list")List<String>list
 *
 * @author xie yuan bing
 * @date 2021-12-09 14:55
 */
public class TypeTest {


}
