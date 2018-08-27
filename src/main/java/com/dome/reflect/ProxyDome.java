package com.dome.reflect;

/**
 * java.lang.reflect.Proxy类提供用于创建动态代理类和实例的静态方法，它也是由这些方法创建的所有动态代理类的超类。
 * 以下是java.lang.reflect.Proxy类的字段 -
 *
 *      protected InvocationHandler h - 该代理实例调用的处理程序。
 *
 *序号	方法	描述
 * 1	protected Proxy(InvocationHandler h)	从一个子类(通常是一个动态代理类)构造一个新的Proxy实例，并为其调用处理程序指定一个值。
 *
 *
 * 类方法
 * 序号	方法	描述
 * 1	static InvocationHandler getInvocationHandler(Object proxy)	返回指定代理实例的调用处理程序。
 * 2	static Class<?> getProxyClass(ClassLoader loader, Class<?>… interfaces)	给定类加载器和接口数组的代理类的java.lang.Class对象。
 * 3	static boolean isProxyClass(Class<?> cl)	当且仅当使用getProxyClass方法或newProxyInstance方法将指定的类动态生成为代理类时，才返回true。
 * 4	static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)	返回指定接口的代理类的实例，该接口将方法调用分派给指定的调用处理程序。
 */
public class ProxyDome {
}
