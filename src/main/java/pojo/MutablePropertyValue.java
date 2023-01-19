package pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 一个bean标签可以有多个Property子标签，这个类用来管理并存储多个PropertyValue类
 * Iterable为迭代器接口
 */
public class MutablePropertyValue implements Iterable<PropertyValue>{

    private final List<PropertyValue> propertyValueList;



    public MutablePropertyValue(List<PropertyValue> propertyValueList) {
        if (propertyValueList==null){
            this.propertyValueList =new ArrayList<>();
        }else {
            this.propertyValueList =propertyValueList;
        }
    }

    public MutablePropertyValue() {
        this.propertyValueList =new ArrayList<>();
    }

    /**
     * 获取迭代器对象
     * @return
     */
    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }

    /**
     * 获取所有的PropertyValue
     * @return
     */
    public PropertyValue[] getPropertyValues(){
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据name属性获取PropertyValue对象
     * @param name
     * @return
     */
    public PropertyValue getPropertyValue(String name){
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(name)){
                return propertyValue;
            }
        }
        return null;
    }

    /**
     * 判断集合是否为空
     * @return
     */
    public boolean isEmpty(){
        return propertyValueList.isEmpty();
    }

    /**
     * 添加PropertyValue对象
     * @param propertyValue
     * @return
     */
    public MutablePropertyValue addPropertyValue(PropertyValue propertyValue){
        for (int i = 0; i < propertyValueList.size(); i++) {
            if (propertyValueList.get(i).getName().equals(propertyValue.getName())){
                propertyValueList.set(i,propertyValue);
                return this;
            }
        }
        propertyValueList.add(propertyValue);
        return this;
    }

    /**
     * 判断是否有指定name属性的方法
     * @param name
     * @return
     */
    public boolean contains(String name){
        return getPropertyValue(name)!=null;
    }
}
