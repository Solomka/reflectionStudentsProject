package ua.training.reflection_student.view;

import java.util.List;
import java.util.Map;

public class View {

	public void printObjectsList(String message, List<?> classInterfaces) {
		StringBuilder stringBuilder = new StringBuilder();

		for (Object classInterface : classInterfaces) {
			stringBuilder.append(classInterface.toString()).append(ViewMessageUtils.NEW_LINE);
		}

		printMessage(message, ViewMessageUtils.NEW_LINE, stringBuilder.toString());
	}

	public void printClassAnnotatedMethodsResults(Map<String, Object> methodsInvokationResults) {
		StringBuilder stringBuilder = new StringBuilder();

		for (String methodName : methodsInvokationResults.keySet()) {
			stringBuilder.append(methodName).append(ViewMessageUtils.COLON).append(ViewMessageUtils.EMPTY_STR)
					.append(methodsInvokationResults.get(methodName)).append(ViewMessageUtils.NEW_LINE);
		}

		printMessage(ViewMessage.CLASS_ANNOTATED_METHODS_INVOKATION_RESULTS, ViewMessageUtils.NEW_LINE,
				stringBuilder.toString());
	}

	/**
	 * Shows constructed message
	 * 
	 * @param messages
	 *            parts of the message (one or many)
	 */
	public void printMessage(String... messages) {
		String resultedMessage = generateMessageFromParts(messages);
		System.out.println(resultedMessage);
	}

	/**
	 * Generates one message from its parts (one or many)
	 * 
	 * @param messages
	 *            parts of the message (one or many)
	 * @return constructed message
	 */
	private String generateMessageFromParts(String... messages) {
		StringBuilder builder = new StringBuilder();

		for (String mgs : messages) {
			builder.append(mgs);
		}
		return builder.toString();
	}
}
