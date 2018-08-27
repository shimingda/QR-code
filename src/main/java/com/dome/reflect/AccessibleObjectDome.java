package com.dome.reflect;

/**
 * java.lang.reflect.AccessibleObject类是Field，Method和Constructor类对象的基类。
 * 它提供了将反射对象标记为在使用它时抑制默认Java语言访问控制检查的功能。
 * 当使用Fields，Methods或Constructors类对象来设置或获取字段，调用方法，或创建和初始化新的类实例时，执行访问分别检查(对于public，默认(包)访问，protected和private成员) 。
 * 在反射对象中设置可访问标志允许具有足够权限的复杂应用程序(如Java对象序列化或其他持久性机制)以被禁止的方式操作对象。
 * 编号	构造函数	描述
 * 1	T getAnnotation(Class annotationClass)	如果存在注解，则返回该元素的指定类型的注解，否则返回null。
 * 2	Annotation[] getAnnotations()	返回此元素上存在的所有注解。
 * 3	Annotation[] getDeclaredAnnotations()	返回此元素上直接存在的所有注解。
 * 4	boolean isAccessible()	获取此对象的可访问标志的值。
 * 5	boolean isAnnotationPresent(Class<? extends Annotation> annotationClass)	如果此元素上存在指定类型的注解，则返回true，否则返回false。
 * 6	static void setAccessible(AccessibleObject[] array, boolean flag)	使用单一安全检查来设置对象数组的可访问标志的一个方便的方法(为了效率)。
 * 7	void setAccessible(boolean flag)	将此对象的可访问标志设置为指示的布尔值。
 */
public class AccessibleObjectDome {
}
