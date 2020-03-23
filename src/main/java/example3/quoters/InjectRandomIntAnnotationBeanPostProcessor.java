package example3.quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * @author Alexey Druzik on 3/23/2020
 */
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            InjectRandomInt injectRandomInt = declaredField.getAnnotation(InjectRandomInt.class);
            if (injectRandomInt != null) {
                int min = injectRandomInt.min();
                int max = injectRandomInt.max();
                Random random = new Random();
                int i = min + random.nextInt(max - min);
                declaredField.setAccessible(true);
                ReflectionUtils.setField(declaredField, bean, i);

            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
