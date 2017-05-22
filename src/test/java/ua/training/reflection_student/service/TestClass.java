package ua.training.reflection_student.service;

import ua.training.reflection_student.utils.annotation.ConcreteClass;
import ua.training.reflection_student.utils.annotation.ConcreteField;
import ua.training.reflection_student.utils.annotation.RunnableMethod;

@ConcreteClass
public class TestClass {

	@ConcreteField
	private String value;

	public TestClass() {
	}

	public TestClass(String value) {
		this.value = value;
	}

	@RunnableMethod
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestClass other = (TestClass) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@RunnableMethod
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Test [value=").append(value).append("]");
		return builder.toString();
	}

}