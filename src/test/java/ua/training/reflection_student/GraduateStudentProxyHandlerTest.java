package ua.training.reflection_student;

import static org.junit.Assert.*;

import java.lang.reflect.Proxy;

import org.junit.Test;

import ua.training.reflection_student.model.proxy.GraduateStudentProxyHandler;
import ua.training.reflection_student.model.student.GraduateStudent;
import ua.training.reflection_student.model.student.GraduateStudentImpl;

public class GraduateStudentProxyHandlerTest {

	@Test
	public void testAllowedMethodCall() {
		GraduateStudent graduateStudent = (GraduateStudent) Proxy.newProxyInstance(
				GraduateStudent.class.getClassLoader(), new Class[] { GraduateStudent.class },
				new GraduateStudentProxyHandler(new GraduateStudentImpl(new Long(1), "Adam Smith", 4,
						"Knowledge-based recommendation system")));

		String expectedFullName = "Adam Smith";
		String actualFullName = graduateStudent.getFullName();
		assertEquals(expectedFullName, actualFullName);

	}

	@Test(expected = RuntimeException.class)
	public void testForbiddenedMethodCall() {
		GraduateStudent graduateStudent = (GraduateStudent) Proxy.newProxyInstance(
				GraduateStudent.class.getClassLoader(), new Class[] { GraduateStudent.class },
				new GraduateStudentProxyHandler(new GraduateStudentImpl(new Long(1), "Adam Smith", 4,
						"Knowledge-based recommendation system")));

		graduateStudent.setFullName("Test Test");
	}

}
