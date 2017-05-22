package ua.training.reflection_student.service;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import ua.training.reflection_student.model.dto.ConstructorDTO;
import ua.training.reflection_student.model.dto.FieldDTO;
import ua.training.reflection_student.model.dto.MethodDTO;

public interface ClassStatisticsService {

	public Class<?> getClazz();

	public Object getClazzInstance();

	public String getShortClassName();

	public String getShortSuperClassName();

	public String getPackageAndClassName();

	public String getClassModifiers();

	public List<Annotation> getClassAnnotations();

	public List<Class<?>> getClassAndClassInheritedInterfaces();

	public List<FieldDTO> getClassAndClassInheritedFields();

	public List<ConstructorDTO> getClassConstructors();

	public List<MethodDTO> getClassMethods();

	public Map<String, Object> invokeAnnotatedMehods(Class<? extends Annotation> annotationType);
}
