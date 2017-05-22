package ua.training.reflection_student.model.student;

public interface GraduateStudent {

	Long getId();

	void setId(Long id);

	String getFullName();

	void setFullName(String fullName);

	int getCourse();

	void setCourse(int course);

	String getDiplomaTheme();

	void setDiplomaTheme(String diplomaTheme);

	public String toString();

}
