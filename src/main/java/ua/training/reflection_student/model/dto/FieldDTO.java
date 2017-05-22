package ua.training.reflection_student.model.dto;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.List;

public class FieldDTO {

	private int modifiers;
	private String type;
	private String name;

	private List<Annotation> annotations;

	public FieldDTO() {
	}

	public FieldDTO(int modifiers, String type, String name, List<Annotation> annotations) {

		this.modifiers = modifiers;
		this.type = type;
		this.name = name;
		this.annotations = annotations;
	}

	public int getModifiers() {
		return modifiers;
	}

	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Annotation> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(List<Annotation> annotations) {
		this.annotations = annotations;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Field { ").append(Modifier.toString(modifiers)).append(" ").append(type).append(" ")
				.append(name).append(", annotations=").append(annotations).append("}");

		return builder.toString();
	}
}
