package com.dome.reflect;

/**
 * java.lang.reflect.Constructor类提供了一个类的单个构造函数的信息和访问权限。
 * 构造函数允许在将实际参数传到newInstance()与底层构造函数的形式参数进行匹配时进行扩展转换，但如果发生缩小转换，则会抛出IllegalArgumentException异常。
 *类方法
 * 序号	方法	描述
 * 1	boolean equals(Object obj)	将此构造函数与指定对象进行比较。
 * 2	T getAnnotation(Class annotationClass)	如果存在这样的注释，则返回该元素的指定类型的注释，否则返回null。
 * 3	Annotation[] getDeclaredAnnotations()	返回此元素上直接存在的所有注释。
 * 4	Class getDeclaringClass()	返回表示由此构造函数对象表示的构造函数的类的Class对象。
 * 5	Class<?>[] getExceptionTypes()	返回一个Class对象数组，该数组表示由此构造方对象表示的底层构造函数声明的异常类型。
 * 6	Type[] getGenericExceptionTypes()	返回一个Type对象数组，它以声明顺序表示由此构造方法对象表示的方法的形式参数类型。
 * 7	Type[] getGenericParameterTypes()	返回一个Type对象数组，它以声明顺序表示由此构造方法对象表示的方法的形式参数类型。
 * 8	int getModifiers()	返回由此Constructor对象表示的构造函数的Java语言修饰符，以整数形式返回。
 * 9	String getName()	以字符串形式返回此构造函数的名称。
 * 10	Annotation[][] getParameterAnnotations()	返回一个数组数组，表示由Constructor对象表示的方法的形式参数(以声明顺序)的注释。
 * 11	Class<?>[] getParameterTypes()	返回一个Class对象数组，它们以声明顺序表示由此构造函数对象表示的构造函数的形式参数类型。
 * 12	int hashCode()	返回此构造函数的哈希码。
 * 13	boolean isSynthetic()	如果此构造函数是合成构造函数，则返回true; 否则返回false。
 * 14	boolean isVarArgs()	如果该构造函数被声明为采用可变数量的参数，则返回true; 否则返回false。
 * 15	T newInstance(Object… initargs)	使用此Constructor对象表示的构造函数，使用指定的初始化参数来创建和初始化构造函数的声明类的新实例。
 * 16	String toGenericString()	返回描述此构造方法的字符串，包括类型参数。
 * 17	String toString()	返回描述此构造函数的字符串。
 *
 */
public class ConstructorDome {
}
