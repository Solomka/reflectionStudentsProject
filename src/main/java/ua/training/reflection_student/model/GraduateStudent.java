package ua.training.reflection_student.model;

import ua.training.reflection_student.utils.annotation.ConcreteClass;
import ua.training.reflection_student.utils.annotation.ConcreteField;
import ua.training.reflection_student.utils.annotation.RunnableMethod;

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
		return "The actuality of my dimploma thema consists in...";
	}

	@Override
	@RunnableMethod
	public String toString() {
		return super.toString() + ", diplomaTheme =" + diplomaTheme;
	}
}
