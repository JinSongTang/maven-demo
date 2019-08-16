package annotation;

import java.lang.reflect.Field;

/**
 * @author tangjinsong
 * @Classname Main
 * @Description TODO
 * @Date 2019/8/14 16:15
 * @Created by tangjinsong
 */

public class Main {

    public static void main(String[] args) {
        UserAnnotation userAnnotation=new UserAnnotation();

        Field[] field=userAnnotation.getClass().getDeclaredFields();
        System.out.println(field);

        for(int i=0;i<field.length;i++){

            if(!field[i].isAccessible()){
                field[i].setAccessible(true);
                UserName annotation1= field[i].getAnnotation(UserName.class);
                System.out.println(annotation1.value());
            }
        }
    }

}
