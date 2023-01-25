package pojo;

/**
 * 封装了bean标签下的property标签的属性
 */
public class PropertyValue {

    private String name;
    private String value;
    private String ref;

    public PropertyValue() {
    }

    public PropertyValue(String name, String value, String ref) {
        this.name = name;
        this.value = value;
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
