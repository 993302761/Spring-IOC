package IOC;

/**
 * 定义非延时加载功能
 * 该接口的所有子实现类对bean对象的创建都是非延时的，所以在其中定义refresh方法
 * 该方法主要完成加载配置文件和根据注册表中的BeanDefinition对象封装的数据进行bean对象的创建
 */
public interface ApplicationContext extends BeanFactory{

    //进行配置文件加载并进行对象创建
    void refresh()throws IllegalAccessError,Exception;
}
