package ua.training.reflection_student.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import ua.training.reflection_student.model.student.GraduateStudent;

public class GraduateStudentProxyHandler implements InvocationHandler {

	private static final String GET_ID_METHOD = "getId";
	private static final String GET_FULLNAME_METHOD = "getFullName";
	private static final String GET_COURSE_METHOD = "getCourse";
	private static final String GET_DIPLOMA_THEME_METHOD = "getDiplomaTheme";
	private static final String TO_STRING = "toString";

	private GraduateStudent graduateStudent;

	public GraduateStudentProxyHandler(GraduateStudent graduateStudent) {
		this.graduateStudent = graduateStudent;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();

		switch (methodName) {
		case GET_ID_METHOD:
			return graduateStudent.getId();
		case GET_FULLNAME_METHOD:
			return graduateStudent.getFullName();
		case GET_COURSE_METHOD:
			return graduateStudent.getCourse();
		case GET_DIPLOMA_THEME_METHOD:
			return graduateStudent.getDiplomaTheme();
		case TO_STRING:
			return graduateStudent.toString();
		default:
			throw new RuntimeException("Modificators calls on the immutable objects are forbidden");
		}

	}
}
