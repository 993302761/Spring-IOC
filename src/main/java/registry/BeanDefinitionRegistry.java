package registry;

import pojo.BeanDefinition;

/**
 * 注册表接口
 * BeanDefinitionRegistry需要实现的相关操作有
 * 1.注册BeanDefinition对象到注册表中
 * 2.从注册表中删除指定的BeanDefinition对象
 * 3.根据名称获取指定的BeanDefinition对象
 * 4.判断注册表中是否包含指定的BeanDefinition对象
 * 5.获取注册表中BeanDefinition对象的个数
 * 6.获取注册表中所有BeanDefinition的名称
 */
public interface BeanDefinitionRegistry {

    //注册BeanDefinition对象到注册表中
    void registryBeanDefinition (String beanName, BeanDefinition beanDefinition);

    //从注册表中删除指定的BeanDefinition对象
    void removeBeanDefinition(String beanName) throws Exception;

    //根据名称获取指定的BeanDefinition对象
    BeanDefinition getBeanDefinition(String name) throws Exception;

    //判断注册表中是否包含指定的BeanDefinition对象
    boolean containsBeanDefinition(String name);

    //获取注册表中BeanDefinition对象的个数
    int getBeanDefinitionCount();

    //获取注册表中所有BeanDefinition的名称
    String[] getBeanDefinitionName();
}
