package ua.training.reflection_student.service;

import static org.junit.Assert.assertEquals;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ClassStatisticsServiceTest {

	private static final String TEST_CLASS_FULLNAME = "ua.training.reflection_student.service.TestClass";
	private static final Class<?> TEST_CLASS = TestClass.class;

	@Test
	// @Ignore
	public void testConstructor() {
		ClassStatisticsService classStatisticsService = new ClassStatisticsServiceImpl(TEST_CLASS_FULLNAME,
				new Class<?>[] { String.class }, new Object[] { "Test value" });

		Object expectedClassObject = new TestClass("Test value");
		Object actualClassObject = classStatisticsService.getClazzInstance();

		assertEquals(expectedClassObject, actualClassObject);
	}

	@Test
	// @Ignore
	public void testGetClazzInstance() {
		ClassStatisticsService classStatisticsService = new ClassStatisticsServiceImpl(TEST_CLASS_FULLNAME,
				new Class<?>[] { String.class }, new Object[] { "Test value" });

		Class<?> expectedClass = TEST_CLASS;
		Class<?> actualClass = classStatisticsService.getClazz();

		assertEquals(expectedClass, actualClass);
	}

	@Test
	// @Ignore
	public void testGetShortClassName() {
		ClassStatisticsService classStatisticsService = new ClassStatisticsServiceImpl(TEST_CLASS_FULLNAME,
				new Class<?>[] { String.class }, new Object[] { "Test value" });

		String expectedShortName = "TestClass";
		String actualShortName = classStatisticsService.getShortClassName();

		assertEquals(expectedShortName, actualShortName);
	}

	@Test
	// @Ignore
	public void testGetShortSuperClassName() {
		ClassStatisticsService classStatisticsService = new ClassStatisticsServiceImpl(TEST_CLASS_FULLNAME,
				new Class<?>[] { String.class }, new Object[] { "Test value" });

		String expectedShortName = "Object";
		String actualShortName = classStatisticsService.getShortSuperClassName();

		assertEquals(expectedShortName, actualShortName);
	}

	@Test
	// @Ignore
	public void testGetPackageAndClassName() {
		ClassStatisticsService classStatisticsService = new ClassStatisticsServiceImpl(TEST_CLASS_FULLNAME,
				new Class<?>[] { String.class }, new Object[] { "Test value" });

		String expectedName = TEST_CLASS_FULLNAME;
		String actualName = classStatisticsService.getPackageAndClassName();

		assertEquals(expectedName, actualName);
	}

	@Test
	// @Ignore
	public void testGetClassModifiers() {
		ClassStatisticsService classStatisticsService = new ClassStatisticsServiceImpl(TEST_CLASS_FULLNAME,
				new Class<?>[] { String.class }, new Object[] { "Test value" });

		String expectedClassModifiers = "public";
		String actualClassModifiers = classStatisticsService.getClassModifiers();

		assertEquals(expectedClassModifiers, actualClassModifiers);
	}

	@Test
	// @Ignore
	public void testGetClassAnnotations() {
		ClassStatisticsService classStatisticsService = new ClassStatisticsServiceImpl(TEST_CLASS_FULLNAME,
				new Class<?>[] { String.class }, new Object[] { "Test value" });

		List<Annotation> expectedClassAnnotations = new ArrayList<>(Arrays.asList(TEST_CLASS.getAnnotations()));
		List<Annotation> actualClassAnnotations = classStatisticsService.getClassAnnotations();

		assertEquals(expectedClassAnnotations, actualClassAnnotations);
	}
}