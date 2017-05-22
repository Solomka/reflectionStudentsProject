package ua.training.reflection_student.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import ua.training.reflection_student.model.dto.ConstructorDTO;
import ua.training.reflection_student.model.dto.FieldDTO;
import ua.training.reflection_student.model.dto.MethodDTO;

public class ClassStatisticsServiceImpl implements ClassStatisticsService{

	private Class<?> clazz;
	private Object clazzInstance;

	public ClassStatisticsServiceImpl(String className, Class<?>[] types, Object[] values) {
		Objects.requireNonNull(className);
		Objects.requireNonNull(types);
		Objects.requireNonNull(values);

		try {
			this.clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		instantiateClassObject(types, values);
	}

	private void instantiateClassObject(Class<?>[] types, Object[] values) {
		Constructor<?> cons = null;
		try {
			cons = clazz.getConstructor(types);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		try {
			this.clazzInstance = cons.newInstance(values);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public Class<?> getClazz() {
		return this.clazz;
	}

	public Object getClazzInstance() {
		return this.clazzInstance;
	}

	public String getShortClassName() {
		return clazz.getSimpleName();
	}

	public String getShortSuperClassName() {
		return clazz.getSuperclass().getSimpleName();
	}

	public String getPackageAndClassName() {
		return clazz.getName();
	}

	public String getClassModifiers() {
		return Modifier.toString(clazz.getModifiers());
	}

	public List<Annotation> getClassAnnotations() {
		return new ArrayList<>(Arrays.asList(clazz.getAnnotations()));
	}

	public List<Class<?>> getClassAndClassInheritedInterfaces() {
		return getAllInterfaces(new ArrayList<Class<?>>(), clazz);
	}

	private List<Class<?>> getAllInterfaces(List<Class<?>> interfaces, Class<?> type) {
		interfaces.addAll(Arrays.asList(type.getInterfaces()));
		if (type.getSuperclass() != null) {
			getAllInterfaces(interfaces, type.getSuperclass());
		}
		return interfaces;
	}

	public List<FieldDTO> getClassAndClassInheritedFields() {
		List<FieldDTO> resultedFields = new ArrayList<>();

		List<Field> fields = getAllFields(new ArrayList<Field>(), clazz);
		for (Field field : fields) {
			resultedFields.add(new FieldDTO(field.getModifiers(), field.getType().getName(), field.getName(),
					new ArrayList<>(Arrays.asList(field.getAnnotations()))));
		}

		return resultedFields;
	}

	private List<Field> getAllFields(List<Field> fields, Class<?> type) {
		fields.addAll(Arrays.asList(type.getDeclaredFields()));

		if (type.getSuperclass() != null) {
			getAllFields(fields, type.getSuperclass());
		}

		return fields;
	}

	public List<ConstructorDTO> getClassConstructors() {
		List<ConstructorDTO> resultedConstructors = new ArrayList<>();

		for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
			resultedConstructors.add(
					new ConstructorDTO(constructor.getName(), getStringParameters(constructor.getParameterTypes())));
		}

		return resultedConstructors;
	}

	public List<MethodDTO> getClassMethods() {
		List<MethodDTO> resultedMethods = new ArrayList<>();

		for (Method method : clazz.getMethods()) {
			resultedMethods.add(new MethodDTO(method.getModifiers(), method.getReturnType().getName(), method.getName(),
					getStringParameters(method.getParameterTypes()),
					new ArrayList<>(Arrays.asList(method.getAnnotations()))));
		}

		return resultedMethods;
	}

	private List<String> getStringParameters(Class<?>[] params) {
		List<String> stringParameters = new ArrayList<>();

		for (Class<?> param : params) {
			stringParameters.add(param.getName());
		}

		return stringParameters;
	}

	public Map<String, Object> invokeAnnotatedMehods(Class<? extends Annotation> annotationType) {

		Map<String, Object> methodsInvokationResults = new HashMap<>();

		for (Method m : clazz.getMethods()) {
			if (m.isAnnotationPresent(annotationType)) {
				Object methodInvokationResult = null;
				try {
					methodInvokationResult = m.invoke(clazzInstance);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
				if (methodInvokationResult != null) {
					methodsInvokationResults.put(m.getName(), methodInvokationResult);
				}
			}
		}
		return methodsInvokationResults;
	}
}
