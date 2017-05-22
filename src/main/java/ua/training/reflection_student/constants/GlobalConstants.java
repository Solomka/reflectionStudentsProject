package ua.training.reflection_student.constants;

import java.lang.annotation.Annotation;

import ua.training.reflection_student.utils.annotation.RunnableMethod;

public interface GlobalConstants {

	String  CLASS_FULLNAME = "ua.training.reflection_student.model.student.GraduateStudent";
	Class<? extends Annotation> ANNOTATION_TYPE = RunnableMethod.class;	
}
