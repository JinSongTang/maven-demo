package annotation;

import java.lang.reflect.Field;

/**
 * @author tangjinsong
 * @Classname UserAnnotation
 * @Description TODO
 * @Date 2019/8/14 15:53
 * @Created by tangjinsong
 */


public class UserAnnotation {
    @UserName(value = "姓名")
   String name;
    @UserName(value = "年龄")
   int age;



}
