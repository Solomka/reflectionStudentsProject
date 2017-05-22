package ua.training.reflection_student;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Proxy;

import org.junit.Test;

import ua.training.reflection_student.model.proxy.GraduateStudentProxyHandler;
import ua.training.reflection_student.model.student.GraduateStudent;
import ua.training.reflection_student.model.student.GraduateStudentImpl;

public class GraduateStudentProxyHandlerTest {

	@Test
	public void testGetId() {
		GraduateStudent graduateStudent = (GraduateStudent) Proxy.newProxyInstance(
				GraduateStudent.class.getClassLoader(), new Class[] { GraduateStudent.class },
				new GraduateStudentProxyHandler(new GraduateStudentImpl(new Long(1), "Adam Smith", 4,
						"Knowledge-based recommendation system")));

		Long expectedId = new Long(1);
		Long actualId = graduateStudent.getId();
		assertEquals(expectedId, actualId);
	}

	@Test
	public void testGetFullName() {
		GraduateStudent graduateStudent = (GraduateStudent) Proxy.newProxyInstance(
				GraduateStudent.class.getClassLoader(), new Class[] { GraduateStudent.class },
				new GraduateStudentProxyHandler(new GraduateStudentImpl(new Long(1), "Adam Smith", 4,
						"Knowledge-based recommendation system")));

		String expectedFullName = "Adam Smith";
		String actualFullName = graduateStudent.getFullName();

		assertEquals(expectedFullName, actualFullName);
	}

	@Test
	public void testGetCourse() {
		GraduateStudent graduateStudent = (GraduateStudent) Proxy.newProxyInstance(
				GraduateStudent.class.getClassLoader(), new Class[] { GraduateStudent.class },
				new GraduateStudentProxyHandler(new GraduateStudentImpl(new Long(1), "Adam Smith", 4,
						"Knowledge-based recommendation system")));

		int expectedCourse = 4;
		int actualCourse = graduateStudent.getCourse();

		assertEquals(expectedCourse, actualCourse);
	}

	@Test
	public void testGetDiplomaTheme() {
		GraduateStudent graduateStudent = (GraduateStudent) Proxy.newProxyInstance(
				GraduateStudent.class.getClassLoader(), new Class[] { GraduateStudent.class },
				new GraduateStudentProxyHandler(new GraduateStudentImpl(new Long(1), "Adam Smith", 4,
						"Knowledge-based recommendation system")));

		String expectedDiplomaTheme = "Knowledge-based recommendation system";
		String actualDiplomaTheme = graduateStudent.getDiplomaTheme();

		assertEquals(expectedDiplomaTheme, actualDiplomaTheme);
	}

	@Test
	public void testToString() {
		GraduateStudent graduateStudent = (GraduateStudent) Proxy.newProxyInstance(
				GraduateStudent.class.getClassLoader(), new Class[] { GraduateStudent.class },
				new GraduateStudentProxyHandler(new GraduateStudentImpl(new Long(1), "Adam Smith", 4,
						"Knowledge-based recommendation system")));

		String expectedString = "GraduateStudentImpl: id = 1, fullName = Adam Smith, course = 4, diplomaTheme = Knowledge-based recommendation system";
		String actualString = graduateStudent.toString();

		assertEquals(expectedString, actualString);
	}

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
	public void testSetId() {
		GraduateStudent graduateStudent = (GraduateStudent) Proxy.newProxyInstance(
				GraduateStudent.class.getClassLoader(), new Class[] { GraduateStudent.class },
				new GraduateStudentProxyHandler(new GraduateStudentImpl(new Long(1), "Adam Smith", 4,
						"Knowledge-based recommendation system")));

		graduateStudent.setId(new Long(1));
	}

	@Test(expected = RuntimeException.class)
	public void testSetFullName() {
		GraduateStudent graduateStudent = (GraduateStudent) Proxy.newProxyInstance(
				GraduateStudent.class.getClassLoader(), new Class[] { GraduateStudent.class },
				new GraduateStudentProxyHandler(new GraduateStudentImpl(new Long(1), "Adam Smith", 4,
						"Knowledge-based recommendation system")));

		graduateStudent.setFullName("Test Test");
	}

	@Test(expected = RuntimeException.class)
	public void testSetCourse() {
		GraduateStudent graduateStudent = (GraduateStudent) Proxy.newProxyInstance(
				GraduateStudent.class.getClassLoader(), new Class[] { GraduateStudent.class },
				new GraduateStudentProxyHandler(new GraduateStudentImpl(new Long(1), "Adam Smith", 4,
						"Knowledge-based recommendation system")));

		graduateStudent.setCourse(1);
	}

	@Test(expected = RuntimeException.class)
	public void testSetDiplomaTheme() {
		GraduateStudent graduateStudent = (GraduateStudent) Proxy.newProxyInstance(
				GraduateStudent.class.getClassLoader(), new Class[] { GraduateStudent.class },
				new GraduateStudentProxyHandler(new GraduateStudentImpl(new Long(1), "Adam Smith", 4,
						"Knowledge-based recommendation system")));

		graduateStudent.setDiplomaTheme("Test theme");
	}

}
