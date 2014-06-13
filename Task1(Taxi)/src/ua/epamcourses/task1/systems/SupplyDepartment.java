package ua.epamcourses.task1.systems;

import ua.epamcourses.task1.cars.Car;
import ua.epamcourses.task1.enums.CarModel;

/**
 * 
 * This class is a singleton system which creates instances 
 * of car with unique state number.
 * 
 * @author Fridon
 *
 */

public class SupplyDepartment {
	private String region = "AI";
	private String series = "AT";
	private int number = 1;
	private static SupplyDepartment supplyDepartment = null;
	
	private SupplyDepartment(){};
	
	
	/**
	 * This method returns instance of class(singleton)
	 * 
	 * @return
	 */
	public static SupplyDepartment getInstance(){
		if(supplyDepartment == null)
			supplyDepartment = new SupplyDepartment();
		return supplyDepartment;
	}
	
	/**
	 * This method creates a instance of car model with state number.
	 * 
	 * @param carModel
	 * @return
	 */	
	public Car buyCar(CarModel carModel){
		String temp = String.format("%4d", number);
		number++;
		return new Car(carModel, region+temp+series);
	}
}
