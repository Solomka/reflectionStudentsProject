package ua.training.reflection_student.controller;

import java.util.Objects;

import ua.training.reflection_student.model.GraduateStudent;
import ua.training.reflection_student.service.ClassStatisticsService;
import ua.training.reflection_student.view.View;

public class ClassStatisticsController {

	private View view;

	public ClassStatisticsController(View view) {
		this.view = Objects.requireNonNull(view);
	}

	public void processObtainingClassStatistics() {
				ClassStatisticsService classStatisticsService = new ClassStatisticsService(view);
		classStatisticsService.showClassStatistics(
				new GraduateStudent(new Long(1), "Test Test", 4, "Knowledge-based recommendation system"));
	}

}
