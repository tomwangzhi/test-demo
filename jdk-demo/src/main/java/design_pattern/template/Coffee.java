package design_pattern.template;

/**
 *
 * Created by sylvanasp on 2016/8/30.
 */
public class Coffee extends CommonMake {

    @Override
    protected void brew() {
        System.out.println("泡制咖啡..!");
    }

    @Override
    protected void addCondiments() {
        System.out.println("加入糖和牛奶..!");
    }

    public static void main(String[] args) {
        new Coffee().TemplateMethod();
    }

}
