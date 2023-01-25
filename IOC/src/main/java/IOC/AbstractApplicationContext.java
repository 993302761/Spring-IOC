package IOC;

import parser.BeanDefinitionReader;
import registry.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 *当我们在创建容器对象时就会加载配置文件
 */
public abstract class AbstractApplicationContext implements ApplicationContext{

    //进行xml文件的解析,BeanDefinitionReader类型的对象交由子类去实现，只有子类才明白要创建哪个BeanDefinitionReader的子类实现
    protected BeanDefinitionReader beanDefinitionReader;

    //存放bean的容器
    protected Map<String,Object> map=new HashMap<>();


    //声明配置文件路径的变量
    protected String configLocation;


    @Override
    public void refresh() throws IllegalAccessError, Exception {
        //加载BeanDefinition对象
        beanDefinitionReader.loadBeanDefinitions(configLocation);

        //初始化bean
        finishBeanInitialization();

    }


    //bean对象的初始化
    private void finishBeanInitialization() throws Exception {
        //获取注册表对象
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();

        //获取BeanDefinition对象
        String[] beanDefinitionName = registry.getBeanDefinitionName();

        for (String name :
                beanDefinitionName) {
            //初始化bean
            getBean(name);
        }
    }

}
