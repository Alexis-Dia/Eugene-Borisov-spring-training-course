package example7.quoters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Alexey Druzik on 3/24/2020
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {
    Class newImpl();
}
