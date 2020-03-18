package design_pattern.template;

/**
 * Created by sylvanasp on 2016/8/30.
 */
public class Tea extends CommonMake {

    @Override
    protected void brew() {
        System.out.println("泡制茶..!");
    }

    @Override
    protected void addCondiments() {
        System.out.println("不想加入调料..!");
    }

    @Override
    protected boolean invoke1() {
        return true;
    }

    @Override
    protected boolean invoke2() {
        return false;
    }

    public static void main(String[] args) {
        new Tea().TemplateMethod();
    }
}
