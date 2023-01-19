package pojo;

/**
 * BeanDefinition类用来封装bean的主要信息，包括id（bean对象名称），class（需要交给spring管理的类的全类名）以及子标签property的数据
 * 注：此类里面并没有解决循环依赖问题，可能会出现栈溢出异常
 */
public class BeanDefinition {

    private String name;
    private String className;

    MutablePropertyValue mutablePropertyValue;

    public BeanDefinition() {
        mutablePropertyValue=new MutablePropertyValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public MutablePropertyValue getMutablePropertyValue() {
        return mutablePropertyValue;
    }

    public void setMutablePropertyValue(MutablePropertyValue mutablePropertyValue) {
        this.mutablePropertyValue = mutablePropertyValue;
    }
}
