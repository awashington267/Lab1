package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.beans.Class;

public class SpringApp {
    public static void main(String[] args) {
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Character.class, Class.class);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Character chars = context.getBean("character", Character.class);

        Class role = context.getBean("class", Class.class);


        System.out.println(chars.getCharacter_ID());
        System.out.println(chars.getName());
        System.out.println(role.getClassID());
        System.out.println(role.getRole());

        context.close();

    }
}
