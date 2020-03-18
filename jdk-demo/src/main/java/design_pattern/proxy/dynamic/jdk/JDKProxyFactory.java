package design_pattern.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyFactory {

    private Object target;

    public JDKProxyFactory(Object object) {
        this.target = object;
    }

    public Object getProxy() {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务");
                method.invoke(proxy, args);
                System.out.println("结束事务");
                return null;
            }
        });
    }
}
