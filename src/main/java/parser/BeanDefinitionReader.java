package parser;

import registry.BeanDefinitionRegistry;

/**
 * 用来解析配置文件并在注册表中注册bean的信息，定义了两个规范
 * 1.获取注册表，让外界可以通过该对象获取注册表对象
 * 2.加载配置文件，并配置bean数据
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    void loadBeanDefinitions(String configLocation)throws Exception;
}
