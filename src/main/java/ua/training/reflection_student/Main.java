package ua.training.reflection_student;

import ua.training.reflection_student.controller.ClassStatisticsController;
import ua.training.reflection_student.view.View;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	View view = new View();
    	ClassStatisticsController controller = new ClassStatisticsController(view);
		controller.processObtainingClassStatistics();
    }
}
