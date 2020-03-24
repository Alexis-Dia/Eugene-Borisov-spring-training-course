package example5.quoters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Alexey Druzik on 3/23/2020
 * In each method of this bean with annotation @Profiling add logic for profilling.
 * Check time before than run method and then check time after and display difference.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Profiling {
}
