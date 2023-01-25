package IOC;

/**
 * 这个接口定义了获取bean对象的统一规范
 */
public interface BeanFactory {

    Object getBean(String beanName)throws Exception;

    //根据bean对象的名称获取对象，并进行强制类型转换
    <T> T getBean(String beanName,Class<? extends T> clazz)throws Exception;
}
