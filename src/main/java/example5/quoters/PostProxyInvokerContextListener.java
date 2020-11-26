package example5.quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;

/**
 * @author Alexey Druzik on 3/24/2020
 */
public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            String originalClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> originalClass = Class.forName(originalClassName);
                Method[] methods = originalClass.getMethods();
                for (Method method : methods) {
                    if(method.isAnnotationPresent(PostProxy.class)) {
                        /*Won't work! But it will work if we use cjlib
                        method.invoke();*/
                        Object bean = context.getBean(name);
                        Class<?> proxyClass = bean.getClass();
                        Method currentMethod = proxyClass.getMethod(method.getName());
                        currentMethod.invoke(bean);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*Here is my shorter way. It's not working by mistake. Try to understand what's the problem. */
/*    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            Object bean = factory.getBean(name);
            try {
                Class<?> originalClass = bean.getClass();
                Method[] methods = originalClass.getMethods();
                for (Method method : methods) {
                    if(method.isAnnotationPresent(PostProxy.class)) {
                        Method currentMethod = originalClass.getMethod(method.getName());
                        currentMethod.invoke(bean);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/
}
