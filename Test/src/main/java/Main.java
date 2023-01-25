import IOC.ApplicationContext;
import IOC.ClassPathXmlApplicationContext;
import service.userService;

public class Main {
    public static void main(String[] args) throws Exception {
        //创建spring容器对象
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        //从容器中获取userService对象
        userService service=applicationContext.getBean("userService",userService.class);

        service.test();
    }
}
