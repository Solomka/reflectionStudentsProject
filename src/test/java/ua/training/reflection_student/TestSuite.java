package ua.training.reflection_student;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ua.training.reflection_student.model.proxy.GraduateStudentProxyHandler;
import ua.training.reflection_student.service.ClassStatisticsServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ ClassStatisticsServiceTest.class, GraduateStudentProxyHandler.class })
public class TestSuite {
	/*
	 * empty class
	 */
}
