import com.java0829.MyTestBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MyTestBeanTest {
    @Test
    public void testSimpleLoad(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");
        Assert.assertEquals("testStr", myTestBean.getTestStr());
    }

    @Test
    public void testClass() throws Exception{
        Class<?> aClass = Class.forName("com.java0829.MyTestBean");
        Object o = aClass.getConstructor().newInstance();
        MyTestBean myTestBean = (MyTestBean) o;
        Assert.assertEquals("testStr", myTestBean.getTestStr());
    }
}




