package ua.training.reflection_student.model.dto;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.List;

public class MethodDTO {

	private int modifiers;
	private String returnType;
	private String name;

	private List<String> parametersTypes;
	private List<Annotation> annotations;

	public MethodDTO() {
	}

	public MethodDTO(int modifiers, String returnType, String name, List<String> parametersTypes,
			List<Annotation> annotations) {

		this.modifiers = modifiers;
		this.returnType = returnType;
		this.name = name;
		this.parametersTypes = parametersTypes;
		this.annotations = annotations;
	}

	public int getModifiers() {
		return modifiers;
	}

	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getParametersTypes() {
		return parametersTypes;
	}

	public void setParametersTypes(List<String> parametersTypes) {
		this.parametersTypes = parametersTypes;
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
		builder.append("Method { ").append(Modifier.toString(modifiers)).append(" ").append(returnType).append(" ")
				.append(name).append(", parametersTypes=").append(parametersTypes).append(", annotations=")
				.append(annotations).append("}");
		return builder.toString();
	}
}
