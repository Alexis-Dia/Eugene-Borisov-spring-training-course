package commonAnnotations.bpp;

import commonAnnotations.Audit;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexey Druzik on 21.09.2020
 */
@Component
public class AuditAnnotationBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        final Method[] beanClassMethods = beanClass.getMethods();
        for (Method method : beanClassMethods) {
            if (method.isAnnotationPresent(Audit.class)) {
                map.put(beanName, bean.getClass());
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class originalBeanClass = map.get(beanName);
        if (originalBeanClass != null) {
            Method[] methods = originalBeanClass.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Audit.class)) {
                    return Proxy.newProxyInstance(originalBeanClass.getClassLoader(), originalBeanClass.getInterfaces(), (proxy, method1, args) -> {
                        Object retVal = method1.invoke(bean, args);
                        System.out.println("Logging...");
                        return retVal;
                    });
                }
            }
        }
        return bean;
    }

}
