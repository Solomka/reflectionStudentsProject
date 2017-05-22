package ua.training.reflection_student.model.dto;

import java.util.List;

public class ConstructorDTO {

	private String name;
	private List<String> parametersTypes;

	public ConstructorDTO() {
	}

	public ConstructorDTO(String name, List<String> parametersTypes) {

		this.name = name;
		this.parametersTypes = parametersTypes;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Constructor { ").append(name).append(", parametersTypes:").append(parametersTypes).append("}");
		return builder.toString();
	}
}
