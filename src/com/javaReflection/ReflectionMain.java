package com.javaReflection;

public class ReflectionMain {


    private static String hello = "Hello";
    private static String world = "World";

    public static void main(String[] args) throws ClassNotFoundException {

        Class helloClass = hello.getClass();
        System.out.println(helloClass.toString());

        Class<?> helloClass_1 = "Hello".getClass();
        Class<?> helloClassSuperClass = helloClass_1.getSuperclass();
        Class<?>[] helloClassInterface = helloClass_1.getInterfaces();//will return empty array if the class doesn't implement any Interface
        System.out.println(helloClassSuperClass.toString());
        System.out.println(helloClassInterface.toString());

        //Class<String> helloClass_2 = "Hello".getClass(); //compilation error
        //Class<Object> helloClass_2 = "Hello".getClass(); //compilation error  // Class<String>, Class<Object> will not extend the Class<?>
        System.out.println(helloClass_1.toString());

        Class<? extends String> helloClass_2 = "Hello".getClass();
        System.out.println(helloClass_2.toString());


        Class<? extends Object> helloClass_3 = "Hello".getClass();
        System.out.println(helloClass_3.toString());


        System.out.println(helloClass == helloClass_1);

        Class worldClass = world.getClass();
        System.out.println(worldClass.toString());

        System.out.println(helloClass == worldClass);


        Class<?> stringClass = String.class;
        System.out.println(stringClass.toString());

        String className = "java.lang.String";
        Class<?> stringClassUsingForName = Class.forName(className);
        System.out.println(stringClassUsingForName.toString());

        //String newString = "TODO";
        //Class<?> classType = Class.forName(newString); //classNotFoundException
        //System.out.println(classType.toString());



        /*String test = "com.jpmc.ib.colt.CustomerInformationPanelDataDTO";
        String[] splitString = test.split("\\.");
        System.out.println(splitString[splitString.length-1]);*/


    }

}
