package ua.training.reflection_student.controller;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import ua.training.reflection_student.constants.GlobalConstants;
import ua.training.reflection_student.model.dto.ConstructorDTO;
import ua.training.reflection_student.model.dto.FieldDTO;
import ua.training.reflection_student.model.dto.MethodDTO;
import ua.training.reflection_student.service.ClassStatisticsService;
import ua.training.reflection_student.view.View;
import ua.training.reflection_student.view.ViewMessage;
import ua.training.reflection_student.view.ViewMessageUtils;

public class ClassStatisticsController {

	private View view;
	private ClassStatisticsService classStatisticsService;

	public ClassStatisticsController(ClassStatisticsService classStatisticsService, View view) {
		this.view = Objects.requireNonNull(view);
		this.classStatisticsService = Objects.requireNonNull(classStatisticsService);
	}

	public void processObtainingClassStatistics() {
		view.printMessage(ViewMessage.GREETING, ViewMessageUtils.NEW_LINE);

		showClassStatistics();
	}

	private void showClassStatistics() {

		showClassName(classStatisticsService.getShortClassName());
		showSuperClassName(classStatisticsService.getShortSuperClassName());
		showPackageAndClassName(classStatisticsService.getPackageAndClassName());
		showClassModifiers(classStatisticsService.getClassModifiers());

		showClassAnnotations(classStatisticsService.getClassAnnotations());
		showClassInterfaces(classStatisticsService.getClassAndClassInheritedInterfaces());

		showClassFields(classStatisticsService.getClassAndClassInheritedFields());
		showClassConstructors(classStatisticsService.getClassConstructors());
		showClassMethods(classStatisticsService.getClassMethods());

		showClassAnnotatedMethodsResults(classStatisticsService.invokeAnnotatedMehods(GlobalConstants.ANNOTATION_TYPE));
	}

	public void showClassName(String className) {
		view.printMessage(ViewMessage.CLASS_NAME, className);
	}

	public void showSuperClassName(String superClassName) {
		view.printMessage(ViewMessage.SUPERCLASS_NAME, superClassName);
	}

	public void showPackageAndClassName(String packageAndClassName) {
		view.printMessage(ViewMessage.PACKAGE_AND_SHORT_CLASS_NAME, packageAndClassName);
	}

	public void showClassModifiers(String classModifiers) {
		view.printMessage(ViewMessage.CLASS_MODIFIERS, classModifiers);
	}

	public void showClassAnnotations(List<Annotation> classAnnotations) {
		view.printObjectsList(ViewMessage.ClASS_ANNOTATIONS, classAnnotations);
	}

	public void showClassInterfaces(List<Class<?>> classInterfaces) {
		view.printObjectsList(ViewMessage.CLASS_INTERFACES, classInterfaces);
	}

	public void showClassFields(List<FieldDTO> classFields) {
		view.printObjectsList(ViewMessage.CLASS_FIELDS, classFields);
	}

	public void showClassConstructors(List<ConstructorDTO> classConstructors) {
		view.printObjectsList(ViewMessage.CLASS_CONSTRUCTORS, classConstructors);
	}

	public void showClassMethods(List<MethodDTO> classMethods) {
		view.printObjectsList(ViewMessage.CLASS_METHODS, classMethods);
	}

	public void showClassAnnotatedMethodsResults(Map<String, Object> methodsInvokationResults) {
		view.printClassAnnotatedMethodsResults(methodsInvokationResults);
	}

}
