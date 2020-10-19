package test.customtag;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class DemoTest {
    public static void main(String[] args) {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("test.xml"));
        User user = (User) bf.getBean("testbean");
        System.out.println(user);
    }
}
