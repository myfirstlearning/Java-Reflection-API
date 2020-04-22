package com.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        String personClassName = "com.model.Person";
        Class<?> personClass = Class.forName(personClassName);
        Class<?> personSuperClass = personClass.getSuperclass();

        System.out.println("Person Class = " + personClass);
        System.out.println("Super Class of Person Class = " + personSuperClass);

        Field[] fields = personClass.getFields();//returns only the public fields from current and superClass
        System.out.println("Fields :");
        System.out.println(Arrays.toString(fields));

        Field[] declaringFields = personClass.getDeclaredFields();//returns all the fields of current class not superClass
        System.out.println("Declaring Fields :");
        System.out.println(Arrays.toString(declaringFields));

        Field specificField = personClass.getField("name");//returns public field based on given parameter
        System.out.println("Particular Field : " + specificField.toString());

        Method[] methods = personClass.getMethods();//returns only the public methods from current and superClass
        System.out.println("!!!! >>>>>>>>>>>>>>>>");
        Arrays.stream(methods).forEach(method -> {
            System.out.println("Methods name : " + method.toString());
        });


        Method[] declareMethods = personClass.getDeclaredMethods();//returns only all the methods from current class
        System.out.println("!!!! >>>>>>>>>>>>>>>>");
        Arrays.stream(declareMethods).forEach(declaringMethod -> {
            System.out.println("Declaring Methods name : " + declaringMethod.toString());
        });

        //prints the static methods only from declaringMethods
        System.out.println("Static Declaring Methods :");
        Arrays.stream(declareMethods)
                .filter(declareMethod -> Modifier.isStatic(declareMethod.getModifiers()))
                .forEach(System.out::println);

    }

}
