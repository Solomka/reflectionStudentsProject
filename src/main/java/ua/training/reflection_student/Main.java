package ua.training.reflection_student;

import ua.training.reflection_student.constants.GlobalConstants;
import ua.training.reflection_student.controller.ClassStatisticsController;
import ua.training.reflection_student.service.ClassStatisticsService;
import ua.training.reflection_student.view.View;

public class Main {
	public static void main(String[] args) {

		ClassStatisticsService classStatisticsService = new ClassStatisticsService(GlobalConstants.CLASS_FULLNAME,
				new Class<?>[] { Long.class, String.class, int.class, String.class },
				new Object[] { new Long(1), "Adam Smith", 4, "Knowledge-based recommendation system" });
		View view = new View();
		ClassStatisticsController controller = new ClassStatisticsController(classStatisticsService, view);

		controller.processObtainingClassStatistics();
	}
}
