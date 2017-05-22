package ua.training.reflection_student.model;

import ua.training.reflection_student.utils.annotation.ConcreteClass;
import ua.training.reflection_student.utils.annotation.ConcreteField;
import ua.training.reflection_student.utils.annotation.RunnableMethod;
import ua.training.reflection_student.view.ViewMessage;

@ConcreteClass
public class GraduateStudent extends Student implements DiplomaWritable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ConcreteField
	private String diplomaTheme;

	public GraduateStudent() {
	}

	public GraduateStudent(String diplomaTheme) {
		this.diplomaTheme = diplomaTheme;
	}

	public GraduateStudent(Long id, String fullName, int course, String diplomaTheme) {
		super(id, fullName, course);
		this.diplomaTheme = diplomaTheme;
	}

	@RunnableMethod
	public String getDiplomaTheme() {
		return diplomaTheme;
	}

	public void setDiplomaTheme(String diplomaTheme) {
		this.diplomaTheme = diplomaTheme;
	}

	@Override
	@RunnableMethod
	public String writeDiploma() {
		return ViewMessage.DIPLOMA_WRITING;
	}

	@Override
	@RunnableMethod
	public String toString() {
		return super.toString() + ", diplomaTheme =" + diplomaTheme;
	}
}
