package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {

        Resume resume = new Resume();
        Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");
        System.out.println(resume);
        System.out.println();

        Method[] methods = resume.getClass().getDeclaredMethods();

        for (Method m :
                methods) {
            System.out.println(m.getName());
        }
        System.out.println();

        Object o = methods[1].invoke(resume);
        System.out.println(o);
        field.setAccessible(false);
    }


}