package design_pattern.template;

/**
 * 抽象基类 CommonMake   模板基类，
 *  可以自定义 boolean类型的钩子函数。让子类返回不同的 true or false
 *  来决定模板方法 中对应的业务逻辑是否执行。
 *  模板函数适用于
 *  固定的一段执行逻辑，在基类抽象方法中定义好结构，让子类去重载方法类执行让模板方法产生不同的执行效果
 * <p>
 *
 */
public abstract class CommonMake {

    /**
     * 制备饮料的基本模板方法
     */
    public final void TemplateMethod() {
        // 1.将水煮沸
        boilWater();
        // 2.泡制饮料
        brew();
        // 3.将饮料倒入杯中
        if (invoke2()) {
            System.out.println("执行钩子函数2");
        }
        pourInCup();
        if (invoke1()) {
            // 4.加入调味料
            addCondiments();
        }

    }

    /**
     * 基本方法 将饮料倒入杯中
     */
    protected void pourInCup() {
        System.out.println("将饮料倒入杯中..!");
    }

    /**
     * 基本方法 将水煮沸
     */
    protected void boilWater() {
        System.out.println("水已经煮沸了..!");
    }

    /**
     * 泡制饮料,需要子类自定义实现
     */
    protected abstract void brew();

    /**
     * 加入调味料,需要子类自定义实现
     */
    protected abstract void addCondiments();

    /**
     * 钩子函数,默认返回为true.
     * 用于是否执行加入调料,具体的子类可以自定义是否挂钩及挂钩条件.
     */
    protected boolean invoke1() {
        return true;
    }

    /**
     * 钩子函数,默认返回为true.
     * 用于是否执行加入调料,具体的子类可以自定义是否挂钩及挂钩条件.
     */
    protected boolean invoke2() {
        return true;
    }
}
