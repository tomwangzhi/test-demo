package design_pattern.proxy.dynamic.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory {

    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    public CglibProxyFactory() {
    }

    public Object getProxy() {
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("开启事务");
                //执行目标对象的方法
            Object returnValuemethod=method.invoke(target, objects);
                System.out.println("结束事务");
                return returnValuemethod;
            }
        });
        //4.创建子类(代理对象)
        return en.create();
    }


}
