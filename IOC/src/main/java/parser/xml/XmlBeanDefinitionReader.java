package parser.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import parser.BeanDefinitionReader;
import pojo.BeanDefinition;
import pojo.MutablePropertyValue;
import pojo.PropertyValue;
import registry.BeanDefinitionRegistry;
import registry.SimpleBeanDefinitionRegistry;

import java.io.InputStream;
import java.util.List;

/**
 *
 * 针对xml文件进行解析的类
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    //声明注册表对象
    private BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader() {
        registry=new SimpleBeanDefinitionRegistry();
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public void loadBeanDefinitions(String configLocation) throws Exception {
        //使用dom4j进行xml文件的解析
        SAXReader reader=new SAXReader();

        //获取类路径下的配置文件
        InputStream resourceAsStream = XmlBeanDefinitionReader.class.getClassLoader().getResourceAsStream(configLocation);
        Document read = reader.read(resourceAsStream);

        //根据read对象获取根标签对象
        Element rootElement = read.getRootElement();

        //获取根标签下所有的bean标签
        List<Element> bean = rootElement.elements("bean");

        //遍历集合
        for (Element element : bean) {
            //获取id属性
            String id = element.attributeValue("id");

            //获取class属性
            String aClass = element.attributeValue("class");

            //将id和class封装到BeanDefinition对象中
            BeanDefinition beanDefinition=new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(aClass);

            MutablePropertyValue mutablePropertyValue=new MutablePropertyValue();

            //获取bean标签下的所有property对象
            List<Element> property = rootElement.elements("property");
            for (Element element1 : property) {
                //获取name属性
                String name = element.attributeValue("name");
                //获取value属性
                String value = element.attributeValue("value");
                //获取ref属性
                String ref = element.attributeValue("ref");

                PropertyValue propertyValue=new PropertyValue(name,value,ref);

                mutablePropertyValue.addPropertyValue(propertyValue);
            }

            //将MutablePropertyValue封装到BeanDefinition中
            beanDefinition.setMutablePropertyValue(mutablePropertyValue);

            //将beanDefinition对象注册到注册表中
            registry.registryBeanDefinition(id,beanDefinition);
        }
    }
}
