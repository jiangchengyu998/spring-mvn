package test.lookup.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class GetBeanTest {

    public void showMe(){
        this.getBean().showMe();
    }

    public abstract User getBean();

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("looupTest.xml");
        GetBeanTest getBeanTest = (GetBeanTest)bf.getBean("getBeanTest");
        getBeanTest.showMe();
    }
}
