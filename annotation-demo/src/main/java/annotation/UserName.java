package annotation;

import java.lang.annotation.*;

/**
 * @author tangjinsong
 * @Classname UserName
 * @Description TODO
 * @Date 2019/8/14 15:52
 * @Created by tangjinsong
 */

@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface UserName {
    String value() default "";

}
