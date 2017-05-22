package ua.training.reflection_student.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import ua.training.reflection_student.model.student.GraduateStudent;

public class GraduateStudentProxyHandler implements InvocationHandler {

	private GraduateStudent graduateStudent;

	public GraduateStudentProxyHandler(GraduateStudent graduateStudent) {
		this.graduateStudent = graduateStudent;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();

		switch (methodName) {
		case "getId":
			return graduateStudent.getId();
		case "getFullName":
			return graduateStudent.getFullName();
		case "getCourse":
			return graduateStudent.getCourse();
		case "getDiplomaTheme":
			return graduateStudent.getDiplomaTheme();
		case "toString":
			return graduateStudent.toString();
		default:
			throw new RuntimeException("Modifiers calls are forbiddend");
		}

	}
}
