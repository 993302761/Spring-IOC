package IOC;

import parser.xml.XmlBeanDefinitionReader;
import pojo.BeanDefinition;
import pojo.MutablePropertyValue;
import pojo.PropertyValue;
import registry.BeanDefinitionRegistry;
import utils.StringUtils;

import java.lang.reflect.Method;

/**
 * IOC容器具体的子实现类
 * 该类主要是加载类路径下的配置文件，并进行bean对象的创建
 *
 * 主要功能有：
 * 1.在构造方法中创建BeanDefinitionReader对象
 * 2.在构造方法中调用refresh方法，用于配置文件加载、创建bean对象并存储
 * 3.重写getBean方法，并实现依赖注入操作
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{

    public ClassPathXmlApplicationContext(String configLocation) {
        this.configLocation=configLocation;
        //构建解析器对象
        this.beanDefinitionReader=new XmlBeanDefinitionReader();
        try {
            refresh();
        }catch (Exception e){

        }
    }



    @Override
    public Object getBean(String beanName) throws Exception {
        Object o = map.get(beanName);
        if (o!=null){
            return o;
        }else {
            //获取BeanDefinition对象
            BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();

            BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);

            if (beanDefinition==null){
                return null;
            }

            //获取bean信息中的className
            String className = beanDefinition.getClassName();

            //通过反射创建对象
            Class<?> aClass = Class.forName(className);

            Object o1 = aClass.newInstance();

            //进行依赖注入操作
            MutablePropertyValue mutablePropertyValue = beanDefinition.getMutablePropertyValue();
            for (PropertyValue propertyValue : mutablePropertyValue) {
                String name = propertyValue.getName();
                String value = propertyValue.getValue();
                String ref = propertyValue.getRef();
                if (ref!=null&&!"".equals(ref)){
                    //获取依赖的bean对象
                    Object bean = getBean(ref);
                    //拼接方法名
                    String methodName = StringUtils.getSetterMethodByFieldName(name);
                    //获取所有的方法对象
                    Method[] methods = aClass.getMethods();
                    for (Method method : methods) {
                        if (methodName.equals(method.getName())){
                            //执行该setter方法
                            method.invoke(o1,bean);
                            break;
                        }
                    }
                }

                if (value!=null&&!"".equals(value)){
                    //拼接方法名
                    String methodName = StringUtils.getSetterMethodByFieldName(name);

                    //获取Method
                    Method method = aClass.getMethod(methodName, String.class);
                    method.invoke(o1,value);
                }
            }

            //在返回bean对象之前将该对象存储到map容器中
            map.put(beanName,o1);

            return o1;
        }
    }



    @Override
    public <T> T getBean(String beanName, Class<? extends T> clazz) throws Exception {
        Object bean = getBean(beanName);

        if (bean==null){
            return null;
        }else {
            return clazz.cast(bean);
        }

    }
}
