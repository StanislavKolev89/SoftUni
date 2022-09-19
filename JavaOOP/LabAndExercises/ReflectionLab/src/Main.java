import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class clazz = Reflection.class;
        List<Field> fields = Arrays.stream(clazz.getDeclaredFields()).toList();
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> getters = fillGetters(methods);
        List<Method> setters = fillSetters(methods);



        fields.stream().filter(field -> checkAccessModifierField(field)).sorted
                ((e1, e2) -> e1.getName().compareTo(e2.getName())).forEach(field -> System.out.printf("%s must be private!%n", field.getName()));


        getters.stream().

                sorted((e1, e2) -> e1.getName().

                        compareTo(e2.getName())).

                forEach(method ->

                        checkAccessModifierGetter(method));

        setters.stream().

                sorted((e1, e2) -> e1.getName().

                        compareTo(e2.getName())).

                forEach(method ->

                        checkAccessModifierSetter(method));


    }

    private static boolean checkAccessModifierField(Field field) {
        int modifiers = field.getModifiers();
        String string = Modifier.toString(modifiers);
        if (!string.startsWith("private")) {
            return true;
        }
        return false;
    }

    private static void checkAccessModifierSetter(Method method) {
        int modifiers = method.getModifiers();
        String string = Modifier.toString(modifiers);
        if (!string.startsWith("private")) {
            System.out.println(method.getName() + " have to be private!");
        }
    }

    private static void checkAccessModifierGetter(Method method) {
        int modifiers = method.getModifiers();
        String string = Modifier.toString(modifiers);
        if (!string.startsWith("public")) {
            System.out.println(method.getName() + " have to be public!");
        }
    }


    private static String getParameter(Class<?> parameterType) {
        return parameterType == int.class ? "class " + parameterType : parameterType.toString();
    }

    private static List<Method> fillSetters(Method[] methods) {
        List<Method> setters = new ArrayList<>();
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                setters.add(method);
            }
        }
        return setters;
    }

    private static List<Method> fillGetters(Method[] methods) {
        List<Method> getters = new ArrayList<>();
        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                getters.add(method);
            }
        }
        return getters;
    }
}


