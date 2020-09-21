package common.bpp;

import common.Audit;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Alexey Druzik on 21.09.2020
 */
public class AuditAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = bean.getClass();
        Method[] methods = beanClass.getMethods();
        for (Method method: methods) {
            if (method.isAnnotationPresent(Audit.class)) {
                return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method1, args) -> {
                    Object retVal = method1.invoke(bean, args);
                    System.out.println("Logging...");
                    return retVal;
                });
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }

}
