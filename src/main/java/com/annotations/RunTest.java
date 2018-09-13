package com.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class RunTest {

    public static void main(String[] args) {
        System.out.println("testing ...");

        int passed = 0, failed = 0, count = 0, ignore = 0;

        Class<TestExample> testExampleClass = TestExample.class;

        if(testExampleClass.isAnnotationPresent(TesterInfo.class)){
            TesterInfo annotation = testExampleClass.getAnnotation(TesterInfo.class);
            System.out.println(annotation.priority());
            System.out.println(annotation.createdBy());
            Arrays.stream(annotation.tags()).forEach(t -> System.out.println(t.toString()));

        }

        Method[] declaredMethods = testExampleClass.getDeclaredMethods();


        for (Method method : declaredMethods) {
            if(method.isAnnotationPresent(Test.class)) {
                Test annotation = method.getAnnotation(Test.class);
                System.out.println(annotation.enabled());
                if(annotation.enabled()) {
                    try {
                        method.invoke(testExampleClass.newInstance());

                        System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
                        passed++;
                    } catch (Throwable ex) {
                        System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());
                        failed++;
                    }

                } else {
                    System.out.printf("%s - Test '%s' - ignored%n", ++count, method.getName());
                    ignore++;
                }
            }
        }

        System.out.printf("%nResult : Total : %d, Passed: %d, Failed %d, Ignore %d%n", count, passed, failed, ignore);


    }
}
