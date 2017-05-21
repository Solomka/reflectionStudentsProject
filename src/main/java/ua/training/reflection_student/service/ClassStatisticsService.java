package ua.training.reflection_student.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import ua.training.reflection_student.model.Student;
import ua.training.reflection_student.utils.annotation.RunnableMethod;
import ua.training.reflection_student.view.View;

public class ClassStatisticsService {

	private View view;

	public ClassStatisticsService(View view) {
		this.view = Objects.requireNonNull(view);
	}

	public void showClassStatistics(Student student) {
		Class clazz = student.getClass();
	
		Object obj = null;
		try {
			obj = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// class name
		System.out.println("Class  name: " + clazz.getSimpleName());

		// superclass name
		System.out.println("Super class name: " + clazz.getSuperclass().getSimpleName());

		// package name and short class name
		System.out.println("Package name/short class name: " + clazz.getName());

		// class modifiers
		System.out.println("Class modifiers: " + Modifier.toString(clazz.getModifiers()));

		// class annotations
		System.out.println("Class annotations: " + Arrays.toString(clazz.getAnnotations()));

		// class interfaces
		List<Class<?>> interfaces = getAllInterfaces(new ArrayList<Class<?>>(), clazz);
		System.out.println("Class interfaces: " + interfaces.toString());

		// class fields with names, types, modifiers, annotations
		List<Field> fields = getAllFields(new ArrayList<Field>(), clazz);
		System.out.println("Class fields: " + fields.toString());

		// class constructors with params
		Constructor[] constructors = clazz.getDeclaredConstructors();

		for (Constructor constructor : constructors) {
			System.out.println("Constructor: " + constructor.getName() + " ");
			Class[] paramTypes = constructor.getParameterTypes();
			for (Class paramType : paramTypes) {
				System.out.println("Parameter type: " + paramType.getName() + " ");
			}
			System.out.println();
		}

		// class methods with names, modifiers, params types, annotations
		System.out.println("Class methods: ");
		for (Method m : clazz.getMethods()) {
			System.out.println(Modifier.toString(m.getModifiers()) + " " + m.getReturnType() + " " + m.getName());

			Class[] paramTypes = m.getParameterTypes();
			System.out.print("Parametr types: ");
			for (Class paramType : paramTypes) {
				System.out.print(" " + paramType.getName());
			}
			System.out.println("\n");

			System.out.println("Annotations");
			Annotation[] annotations = m.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println("Annotation: " + annotation);
			}
		}
		// invoke annotated methods
		for (Method m : clazz.getMethods()) {

			if (m.isAnnotationPresent(RunnableMethod.class)) {
				Object res = null;
				try {
					res = m.invoke(obj);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (res != null) {
					System.out.println("Method invokation: " + res);
				}
			}
		}
	}

	public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
		fields.addAll(Arrays.asList(type.getDeclaredFields()));

		if (type.getSuperclass() != null) {
			getAllFields(fields, type.getSuperclass());
		}

		return fields;
	}

	public static List<Class<?>> getAllInterfaces(List<Class<?>> interfaces, Class<?> type) {
		interfaces.addAll(Arrays.asList(type.getInterfaces()));

		if (type.getSuperclass() != null) {
			getAllInterfaces(interfaces, type.getSuperclass());
		}

		return interfaces;
	}

}
